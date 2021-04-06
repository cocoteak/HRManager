 function isNull() {
		var a=document.getElementById("TITLE").value;
		if(a.length==0){
			alert('文档标题名不能为空且长度为1-12个字符！');
		}
		document.getElementById("form1").submit();	
	}   
	
