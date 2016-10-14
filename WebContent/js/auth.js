$(function() {

    $('#login-form-link').click(function(e) {
		$("#loginForm").delay(100).fadeIn(100);
 		$("#registerForm").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#registerForm").delay(100).fadeIn(100);
 		$("#loginForm").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
});

$(document).ready(function() {
	document.getElementById("loginForm:nickname").placeholder = "Nickname";
	document.getElementById("loginForm:password").placeholder = "Password";
	document.getElementById("registerForm:nickname").placeholder = "Nickname";
	document.getElementById("registerForm:email").placeholder = "Email";
	document.getElementById("registerForm:password").placeholder = "Password";
});

function switchRegisterToLogin(){
		$('#loginForm').delay(100).fadeIn(100);
		$('#registerForm').fadeOut(100);
		$('#register-form-link').removeClass('active');
		$('#login-form-link').addClass('active');
		document.getElementById('registerForm:nickname').value= '';
		document.getElementById('registerForm:email').value= '';
		document.getElementById('registerForm:password').value= '';
		document.getElementById('loginForm:nickname').value= '';
		document.getElementById('loginForm:password').value= '';
		e.preventDefault();	
}

function clearLoginRegister(){
	document.getElementById('registerForm:nickname').value= '';
	document.getElementById('registerForm:email').value= '';
	document.getElementById('registerForm:password').value= '';
	document.getElementById('loginForm:nickname').value= '';
	document.getElementById('loginForm:password').value= '';
}

function hideModal(){
	$('#myModal').modal('toggle');
}

function shakeModal(){
	$('#myModal').effect('shake');
}