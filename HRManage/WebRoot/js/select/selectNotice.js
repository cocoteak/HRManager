function change(page){
     document.getElementById("pageNow").value=page;
     document.getElementById("form1").submit();
}

function change2(){
   if(document.getElementById("page").value<=document.getElementById("totalPage").value){
         change(document.getElementById("page").value);
  }else{
       alert("������1-"+document.getElementById("totalPage").value+"֮�������");
  }
}
  	
function myClick(){
		var hobbies = document.getElementsByName("del");
		var checkOrCancelAll = document.getElementById("cks");
		    
		if(checkOrCancelAll.checked){
		  	for (var i = 0; i < hobbies.length; i++) {hobbies[i].checked = true;}
		}else{
		    for (var i = 0; i < hobbies.length; i++) {hobbies[i].checked = false;}
		   }
		} 
function deleteItem(){
		var hobbies = document.getElementsByName("del");
		var ids=new Array();
		var len="";
		for (var i = 0; i < hobbies.length; i++){
		   if(hobbies[i].checked){
		      ids.push(hobbies[i].value);
		      len++;
		      }
	     }
	     if(len==0){
	             alert("��ѡ������һ����¼����ɾ����");
	     }else{
	             window.location.href="deleteNotice?ids="+ids;
	     }
	 
} 