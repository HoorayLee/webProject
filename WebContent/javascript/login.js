function $(id){return document.getElementById(id)}

function validate(f){
	if(!(/\w+/.test(f.account.value))){
        alert("账号为空，请输入账号");
		f.username.focus();
		return false;
	}
	if(!(/\w+/.test(f.password.value))){
		
		alert("密码为空，请输入密码");
		f.password.focus();
		return false;
	}
	return true;
}







