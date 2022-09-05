function validateForm(){
	var name = document.forms["registration"]["full_name"].value;
	var email = document.forms["registration"]["email"].value;
	var pw = document.forms["registration"]["password"].value;
	var confirmPw = document.forms["registration"]["confirm_password"].value;
	var mobile = document.forms["registration"]["phone_number"].value;
	
	if(name==""){
		alert("Name must be filled out!");
		return false;
	}
	else if(email==""){
		alert("Email address must be filled out!");
		return false;	
	}
	else if(pw==""){
		alert("Password must be filled out!");
		return false;	
	}
	else if(confirmPw==""){
		alert("Password must be confirmed!");
		return false;	
	}
	else if(confirmPw!=pw) {
		alert("Confirm password not match with password!");
		return false;
	}
	else if(mobile==""){
		alert("Phone number must be filled out!");
		return false;	
	}
}
