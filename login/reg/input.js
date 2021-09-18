function getdata()
{
	//const fs = require('fs')
	var line1 = document.getElementById("name").value;
	
	var m = document.getElementById("male");
	var f = document.getElementById("female");
	var o = document.getElementById("other");

	if(m.checked==true)
		var line2 = m.value;
	else if(f.checked==true)
		var line2 = f.value;
	else if(o.checked==true)
		var line2 = f.value;

	var line3 = document.getElementById("dob").value;
	var line4 = document.getElementById("phone").value;
	var line5 = document.getElementById("uname").value;

	var line6 = document.getElementById("pass").value;
	var buff = document.getElementById("cpass").value;

	if(line1=="" || line2=="" || line3=="" || line4=="" || line5=="" || line6=="" || buff=="")
	{
		alert("Fill up the empty fields!!");
		return;
	}
	else if(line6==buff)
	{
		alert("Regestration process completed successfully");
		window.close();
		return;
	}
	else
	{
		alert("Confirm password correctly!!!");
		return;
	}


	//alert(line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5+"\n"+line6);

	let userInfo = {
		'name': line1,
		'sex': line2,
		'dob': line3,
		'ph': line4,
		'uname': line5,
		'pass': line6,
		'type': 'User',
	};

	const request = new XMLHttpRequest();
	request.open('POST', '/processUserInfo/${JSON.stringify(userInfo)}')
	request.onload = () => {
		const flaskMessage = request.responseText;
		console.log(flaskMessage);
	}
	request.send()
}
