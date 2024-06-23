function register(){
 var username = Document.getElementById("usernameRegister").value;
 var password = Document.getElementById("passwordRegister").value;
 var mail = Document.getElementById("mailRegister").value;

 var registerResponse = {
     username: username,
     password: password,
     mail: mail
 };

 var xhr = new XMLHttpRequest();
 xhr.open("POST","http://localhost:8080/user/register");
 xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var responseText = xhr.responseText;
                console.log("Answer: ", responseText);
            } else {
                console.log("Answer: ", "User cannot added");
            }
        }
    };
    xhr.send(JSON.stringify(registerResponse));

}

