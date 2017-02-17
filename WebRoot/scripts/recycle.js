function sureRecycleNote(){
	//获取笔记ID
	var $li = $("#note_list a.checked").parent();
	var noteId = $li.data("noteId");
	//发送Ajax请求
	$.ajax({
		url:"recycle.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				$li.remove();//删除li
				alert(result.msg);//提示
			}
		},
		error:function(){
			alert("将笔记放入回收站失败");
		}
	});
	return false;
}
