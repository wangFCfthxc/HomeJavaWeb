<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="zh-TW.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.modal-header, h4 {
	background-color: #0059b3;
	text-align: center;
	font-size: 30px;
	color:#fff;
}

</style>

<script>
	var bkTimePos = 1;
	$(function() {
		$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
		$("#calendar").datepicker({
			minDate : +1,
			maxDate : "+1M",
			showAnim : "slideDown",
			dateFormat : "yy-mm-dd",
			showButtonPanel : true
		});
	});

	function checkBookIn() {	
		if ($('#calendar').val() == '') {
			$('#meg01').html('<em>請選擇預約日期</em>');
		} else {
			$('#meg01').html('');
		}
		if ($('#time').val() == null) {
			$('#meg02').html('<em>請選擇預約時間</em>');
		} else {
			$('#meg02').html('');
		}
		if ($('#num').val() == '') {
			$('#meg03').html('<em>請填選人數</em>');
		} else {
			$('#meg03').html('');
		}
		if ($('#ckbox').prop("checked") == false) {
			$('#meg04').html('<em>未同意</em>');
		} else {
			$('#meg04').html('');
		}
		if ($('#roombox').val() == null){
			$('#meg05').html('<em>請填選分店</em>');
		} else {
			$('#meg05').html('');
		}
		if(bkTimePos == 0){
			$('#meg06').html('<em>沒有位置了</em>');
		} else {
			$('#meg06').html('');
		}
		if ($('#calendar').val() != '' &&
				$('#time').val() != null &&
				$('#roombox').val() != null &&
				$('#num').val() != '' &&
				$('#ckbox').prop("checked") == true &&
				bkTimePos != 0)
			return true;
		return false;
	}

	$(document).ready(function() {
		$("#myModal3").modal();
		$('[data-toggle="tooltip"]').tooltip();
		$("#demo").on("hide.bs.collapse",function() {
			$("#csCheck").html('<span class="glyphicon glyphicon-collapse-down"></span> 訂位須知');
		});
		$("#demo").on("show.bs.collapse",function() {
			$("#csCheck").html('<span class="glyphicon glyphicon-collapse-up"></span> 訂位須知');
		});
		$("#csCheck").click(function() {
			$("#ckbox").prop("checked", true);
		});
		$("#bookbtn").click(function() {
			$("#ckbox").prop("checked", false);
		});
		$("#calendar").change(function() {
			if ($("#calendar").val() != '') {
				$("#roombox").removeAttr('disabled');
			}
		});
		$("#roombox").change(function() {
			$("#time option").remove();
			if ($("#roombox").val() != '') {
				$("#time").removeAttr('disabled');
			}
			
			if($("#roombox").prop('selectedIndex') == 1){
				$("#time").append(
						"<option disabled selected>--請選擇時--</option>",
						"<option value='50'>00:00</option>",
						"<option value='51'>03:00</option>",
						"<option value='52'>06:00</option>",
						"<option value='53'>09:00</option>",
						"<option value='54'>12:00</option>",
						"<option value='55'>15:00</option>",
						"<option value='56'>18:00</option>",
						"<option value='57'>21:00</option>"
						);
			}
			if($("#roombox").prop('selectedIndex') == 2){
				$("#time").append(
						"<option disabled selected>--請選擇時--</option>",
						"<option value='60'>00:00</option>",
						"<option value='61'>03:00</option>",
						"<option value='62'>06:00</option>",
						"<option value='63'>09:00</option>",
						"<option value='64'>12:00</option>",
						"<option value='65'>15:00</option>",
						"<option value='66'>18:00</option>",
						"<option value='67'>21:00</option>"
						);
			}
			if($("#roombox").prop('selectedIndex') == 3){
				$("#time").append(
						"<option disabled selected>--請選擇時--</option>",
						"<option value='70'>00:00</option>",
						"<option value='71'>03:00</option>",
						"<option value='72'>06:00</option>",
						"<option value='73'>09:00</option>",
						"<option value='74'>12:00</option>",
						"<option value='75'>15:00</option>",
						"<option value='76'>18:00</option>",
						"<option value='77'>21:00</option>"
						);
			}
		});

	});

	window.onload = function() {
		$('#calendar').change(function() {
			var a = $('#calendar').val();
			$('#roombox').prop('selectedIndex', 0);
			$('#time').prop('selectedIndex', 0);
			$('#roombox').change(function() {
				var b = $('#roombox').val();
				$('#time').prop('selectedIndex', 0);
				$('#time').change(function() {
					var c = $('#time').val();
					var response = {
							calendar : a,
							roombox : b,
							time : c
					};
					
					$.ajax({
						type : 'post',
						url : 'bookInAjax.jsp',
						data : response,
						datatype : 'jsonp',
						success : function(response) {
							$('#sp').html(response);
						}
					});
				});
			});
		});
	}
</script>

<title>BookIn</title>
</head>

<body>
	<div class="container">
		<!-- Trigger the modal with a button -->

		<!-- Modal -->
		<div class="modal fade" id="myModal3" role="dialog" data-backdrop="static" data-toggle="modal">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">

					<div class="modal-header" style="padding: 80px 50px;">
						<!-- <button type="button" class="close" data-dismiss="modal">×</button> -->
							<h4 class="modal-title">線上訂位</h4>
					</div>

					<div class="modal-body">
						<form role="form" class="form-horizontal" method="get"
							action="booking02.jsp" onsubmit="return checkBookIn()">
							<div class="form-group">
								<div class="row">
									<label class="control-label col-md-3" for="calendar">預約日期：</label>
									<div class="col-md-6">
										<input type="text" class="form-control" readonly
											id="calendar" name="calendar" data-toggle="tooltip"
											data-placement="top" title="必選欄位"><span
											class="help-block" id="meg01"></span>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-md-3" for="roombox">預約分店：</label>
									<div class="col-md-6">
										<select class="form-control" name="roombox" id="roombox"
											data-toggle="tooltip" data-placement="top" title="必選欄位"
											disabled>
											<option disabled selected>--請選分店--</option>
											<option>旗艦店</option>
											<option>逢甲店</option>
											<option>梧棲店</option>
										</select><span class="help-block" id="meg05"></span>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-md-3" for="time">預約時間：</label>
									<div class="col-md-6">
										<select class="form-control" name="time" id="time"
											data-toggle="tooltip" data-placement="top" title="必選欄位"
											disabled>
											<option disabled selected>--請選擇時--</option>
										</select><span class="help-block" id="meg02"></span>
									</div>
									<div class="col-md-3">
										<span class="help-block" id="sp"></span>
										<span class="help-block" id="meg06"></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-md-3" for="num">預約人數：</label>
									<div class="col-md-6">
										<input type="number" class="form-control" name="num" id="num"
											value="1" min="1" max="100" data-toggle="tooltip"
											data-placement="top" title="必選欄位"><span
											class="help-block" id="meg03"></span>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-md-3" for="ckbox">同意 <input
										type="checkbox" class="w3-check" id="ckbox" name="ckbox"
										disabled></label>
									<div class="col-md-6">
										<button type="button" id="csCheck" name="csCheck"
											class="btn btn-primary btn-block" data-toggle="collapse"
											data-target="#demo">
											<span class="glyphicon glyphicon-collapse-down"></span>訂位須知
										</button>
										<span class="help-block" id="meg04"></span>
										<div id="demo" class="collapse">
											<ul class="list-group">
												<li class="list-group-item list-group-item-success">訂位資訊：當天可以訂位30天的位子，每天增加一天。</li>
												<li class="list-group-item list-group-item-info">訂位資訊：當天可以訂位30天的位子，每天增加一天。</li>
												<li class="list-group-item list-group-item-warning">訂位資訊：當天可以訂位30天的位子，每天增加一天。</li>
												<li class="list-group-item list-group-item-danger">訂位資訊：當天可以訂位30天的位子，每天增加一天。</li>
											</ul>
										</div>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-3"></div>
									<div class="col-md-6">
										<div class="btn-group btn-group-justified">
											<div class="btn-group">
												<button type="submit" id="save"
													class="btn btn-primary btn-block">
													<i class="material-icons">music_note</i>確認送出
												</button>
											</div>
											<div class="btn-group">
												<button type="reset" id="rst" value="Reset"
													class="btn btn-primary btn-block">
													<i class="material-icons">music_note</i>清除資料
												</button>
											</div>
										</div>
									</div>
									<div class="col-md-3"></div>
								</div>
							</div>
							</from>
					</div>
					<div class="modal-footer">
						<button class="btn btn-danger btn-default pull-left" onclick="javascript:location.href='../index.html'">
							<span class="glyphicon glyphicon-remove"></span> 取消
						</button>
						<p>
							不是會員? <a href="../Login/menberRegister01.html">註冊</a>
						</p>
					</div>

				</div>

			</div>
		</div>

	</div>

</body>

</html>
