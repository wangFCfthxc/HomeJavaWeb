function statusChangeCallback(response) {
  if (response.status === 'connected') {
    testAPI();
  } else if (response.status === 'not_authorized') {
	  $('#status').html('請登入此應用程式，方能註冊');
  } else {
	  $('#status').html('請登入您的Facebook的帳號');
  }
}

function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}

window.fbAsyncInit = function() {
FB.init({
  appId      : '815543765252009',
  status	 : true,
  xfbml      : true,  
  version    : 'v2.8' 
});

FB.getLoginStatus(function(response) {
  statusChangeCallback(response);
});

};
//以下此段是獲取fb的 apk
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


function testAPI() {
  FB.api('/me','get',{fields:'id,name,email'}, function(response) {
    $.ajax({
    	type:'post',
    	url:'Login_Reg.jsp',
    	data:response,
    	datatype:'jsonp',
    	success:function(response){
    		$('#sp').html(response);
    	}
    })
    });
}

//以下是電話號碼判斷
function func(f){
	var a =document.getElementById('obj');
	var b =document.getElementById('mesg');
	var re = /^[09]{2}[0-9]{8}$/ ;
	if(!re.test(f.tel.value)){
		b.innerHTML = "總共要輸入10碼";
	}
	else if(re.test(f.tel.value)){
		return true ;
	}
	
	return false;
}