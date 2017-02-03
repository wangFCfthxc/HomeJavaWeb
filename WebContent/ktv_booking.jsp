<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KTV_BOOK</title>
    <!-- bootstrap version 3.3.1  -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/infoNav.css" rel="stylesheet">
    <link href="css/infoCarousel.css" rel="stylesheet">
    <link href="css/context.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
</head>

<body>
    <!-- navbar================================================== -->
    <div class="navbar-wrapper">
        <div class="container">

            <nav class="navbar navbar-inverse navbar-static-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
                        <a class="navbar-brand" href="#">KTV</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="judgeRegistration.jsp">會員中心</a></li>
                            <li><a href="#">線上訂位</a></li>
                            <li><a href="#">手機點歌</a></li>
                            <li><a href="#">地址、電話</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>登  入</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
    </div>
    <!-- navbar================================================== -->

    <!-- Carousel================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide" src="img/AD01.jpg">
            </div>
            <div class="item">
                <img class="second-slide" src="img/AD02.jpg">
            </div>
            <div class="item">
                <img class="third-slide" src="img/AD03.jpg">
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- /Carousel================================================== -->

    <!-- context================================================== -->
    <div class="container">
        <div class="page-header">
            <h1>旗艦店</h1>
        </div>
        <h2>線上訂位</h2>
        <form class="form-horizontal" method="post" action="" onsubmit="return checkForm()">
            <div class="form-group">
                <label class="control-label col-md-2" for="date">日期:</label>
                <div class="col-md-6">
                    <input type="date" class="form-control" name="date" id="date">
                </div>
                <div class="col-md-4"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="time">時段:</label>
                <div class="col-md-6">
                    <select class="form-control" name="time" id="time">
						<option value="">--請選擇時段--</option>
						<option value="">--請選擇時段--</option>
						<option value="">--請選擇時段--</option>
					</select>
                </div>
                <div class="col-md-4"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="people">人數:</label>
                <div class="col-md-6">
                    <input type="number" class="form-control" name="people" id="people" value="1" min="1" max="100">
                </div>
                <div class="col-md-4"></div>
            </div>
            <div class="form-group">
                <div class="col-md-4"></div>
                <div class="col-md-4"><button type="submit" id="save" class="btn btn-lg btn-primary">確認送出</button></div>
                <div class="col-md-4"></div>
			</div>
        </form>
    </div>
    <!-- /context================================================== -->

    <!-- video================================================== -->
    <!-- 4:3 aspect ratio -->
    <!-- /video================================================== -->

    <!-- footer================================================== -->
    <div class="footer">
        <div class="container">
            <p class="text-muted">Place sticky footer content here.</p>
        </div>
    </div>
    <!-- /footer================================================== -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.1.1.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!-- people check -->
	<script>
	  function checkForm() {
	    var z = document.getElementById('people').value;
	    if (z == "") {
	      alert("people must be filled out");
	      return false;
	    }
	    else if (z >= 50) {
	      alert("大型活動建議直接洽詢客服人員");
	      return true;
	    }
	  }
	</script>
</body>
</html>