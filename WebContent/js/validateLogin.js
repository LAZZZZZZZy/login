/**
 * 
 */

console.log("loginjs");

function validate(form) {
	console.log("loginjs");
	 var username = form.username.value;
	 var pwd = form.pwd.value;
	 console.log("%s,%s",username,pwd);
       // var str = username.replace(/(^\s*)|(\s*$)/g, '');//去除空格;

        if (username == '' || username == undefined || username == null) {
            //return true;
            console.log('空');
            alert("empty name");
            return false;
        } else {
            //return false;
            console.log('非空');
            return true;
        }
    }

function validateRegister(form){
	console.log("regisjs");
	var username = form.username.value;
	 var pwd = form.pwd.value;
	 console.log("%s,%s",username,pwd);
      // var str = username.replace(/(^\s*)|(\s*$)/g, '');//去除空格;

       if (username == '' || username == undefined || username == null) {
           //return true;
           console.log('空');
           alert("empty name");
           return false;
       } else if(pwd == '' || pwd == undefined || pwd == null){
           //return false;
    	   alert("empty pwd");
           return false;
       } else {
    	   return true;
       }
}