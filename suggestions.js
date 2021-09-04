function suggest()
{
	const sym = Document.getElementsByid('txtbox').value;
	alert("sym")

	const arr = sym.split(", ")

	if(arr[0]=="cough" && arr[1]=="sneeze" && arr[2]=="headache")
		alert("Visit our ENT specialist");
	else if(arr[0]=="stomach pain")
		alert("Khobor asche");
}