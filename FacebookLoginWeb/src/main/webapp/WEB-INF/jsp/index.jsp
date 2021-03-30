
<!DOCTYPE html>
<html>
<head>
<title>Facebook Login </title>
<meta charset="UTF-8">
</head>
<body>
	<script>
		// This is called with the results from from FB.getLoginStatus().
		function statusChangeCallback(response) {
			console.log(response.authResponse.accessToken);
			if (response.status === 'connected') {
				window.location.href = 'asdfg?access_token='+ response.authResponse.accessToken;
			} else {
				document.getElementById('status').innerHTML = 'Please log '+ 'into this app.';
			}
		}
		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}
		window.fbAsyncInit = function() {
			FB.init({
				appId : 'id',	// **** Facebook id ****
				cookie : true, // enable cookies to allow the server to access 
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v8.0' // use graph api version 
			});
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		};

		// Load the SDK asynchronously
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "https://connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
		// Here we run a very simple test of the Graph API after login is
		// successful. See statusChangeCallback() for when this call is made.
	</script>
	<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
	</fb:login-button>
	<div id="status"></div>
</body>
</html>
