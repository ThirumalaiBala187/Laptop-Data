function togglePassword() {
      const passwordField = document.getElementById('password');
      const passwordToggle = document.querySelector('.toggle');
      
      if (passwordField.type == 'password') {
        passwordField.type = 'text';
        passwordToggle.innerHTML = '<i class="fa-solid fa-eye-slash"></i>';
      } else {
        passwordField.type = 'password';
        passwordToggle.innerHTML = '<i class="fa-solid fa-eye">';
      }
}

document.getElementById("submit").addEventListener("click", function(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;

	var userData={
		"userName":username,
		"password":password,
		"type":"manual"
	}
	sendToServlet(userData);
});

function handleCredentialResponse(response) {
    const responsePayload = parseJwt(response.credential);
    console.log("User:", responsePayload);
    console.log(responsePayload.email);
    var userData={
		"userName":responsePayload.email,
		"type":"google"
	}
    sendToServlet(userData);
}

function sendToServlet(userData){
	fetch("LoginServlet", {
		method:"POST",
		headers:{
			'Content-Type':"application/json"
		},
		body:JSON.stringify(userData),
		credentials:"include"
	}).then(response => response.text())
	.then(text => {
		console.log("Raw text : ", text);
		try{
			return JSON.parse(text);
		}
		catch(e){
			throw new Error("Server did not return a valid JSON");
		}
	})
	.then(data => {
		console.log("Parsed Response : ", data);
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
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    return JSON.parse(atob(base64));
}
