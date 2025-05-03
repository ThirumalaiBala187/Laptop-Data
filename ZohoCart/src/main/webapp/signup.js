function togglePassword() {
      const passwordField = document.getElementById('password');
      const passwordToggle = document.getElementById('toggle');
      
      if (passwordField.type == 'password') {
        passwordField.type = 'text';
        passwordToggle.innerHTML = '<i class="fa-solid fa-eye-slash icon"></i>';
      } else {
        passwordField.type = 'password';
        passwordToggle.innerHTML = '<i class="fa-solid fa-eye icon">';
      }
}



document.getElementById("submit").addEventListener("click", function(){		
	var name=document.getElementById("name").value;
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var mobile=document.getElementById("mobile").value;
	var dob=document.getElementById("dob").value;
	var gender=document.querySelector("input[name='gender']:checked").value;
	
	if((name == null) || (username == null) || (password == null) || (mobile == "+91")){
		alert("Please Fill all the required details");		
	}
	else{
		let passwordPattern=/^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}$/;
		if(passwordPattern.test(password)){
			var userData={
				"name":name,
				"username":username,
				"password":password,
				"mobile":mobile,
				"dob":dob,
				"gender":gender,
				"auth_type":"Manual"	
			}
			sendToServlet(userData);
		}
		else{
			document.getElementById("password").value="";
			alert("Please Enter a strong password. Password should contain 1 Uppercase, 1 Number and 1 Special character.")
		}
	}
});

function handleCredentialResponse(response) {
    const data = parseJwt(response.credential);
    const name = data.name;
    const username = data.email;
    var userData={
		"name":name,
		"username":username,
		"password":"",
		"mobile":"",
		"dob":"",
		"gender":"NOTSET",
		"auth_type":"Google"	
	}
	sendToServlet(userData);
}

document.addEventListener("DOMContentLoaded", () => {
	document.querySelector(".nsm7Bb-HzV7m-LgbsSe-BPrWId").textContent="Sign up with Google";
})

function sendToServlet(userData){
	fetch("SignupServlet", {
		method: "POST",
		headers:{
			'Content-Type' : 'application/json'
		},
		body: JSON.stringify(userData),
		credentials:"include"
	}).then(response => response.json())
	.then(data =>{
		if(data.status=="success"){
			console.log(data);
			window.location.href=data.redirect;
		}
		else{
			alert(data.message);
		}
	})
	.catch(error => console.error(error));
}

function parseJwt(token) {
    try {
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        const jsonPayload = decodeURIComponent(
            atob(base64)
                .split('')
                .map(c => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2))
                .join('')
        );
        return JSON.parse(jsonPayload);
    } catch (e) {
        console.error("Invalid JWT Token:", e);
        return null;
    }
}


