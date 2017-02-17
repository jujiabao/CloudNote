//加载用户笔记本列表
function loadUserBooks(){
$.ajax({
			url:"loadbooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var books=result.data;//笔记本数组
					for(var i=0;i<books.length;i++){
					var bookname=books[i].cn_notebook_name;
					var bookId=books[i].cn_notebook_id;
					//拼一个li元素
					var s_li='<li class="online">';
						s_li+='<a>';
						s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
						s_li+='</i>'+bookname;
						s_li+='</a>';
					    s_li+='</li>';
					   //将bookId和li元素绑定
					   var $li=$(s_li);
					   $li.data("bookId",bookId);
					   //将li元素添加到ul
					   $("#book_list").append($li);
					}
			   }
			},
			error:function(){
				alert("加载笔记本失败")
			}
		});
}
function createBookLi(bookName,bookId){
	  var s_li='<li class="online">';
	 	  s_li+='<a>';
		  s_li+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
		  s_li+='</i>'+bookName;
		  s_li+='</a>';
	      s_li+='</li>';
	   //将bookId和li元素绑定
	  var $li=$(s_li);
	      $li.data("bookId",bookId);
	   //将li元素添加到ul
	      $("#book_list").append($li);
}
function sureAddBook(){
	//获取请求参数
	var bookName=$("#input_notebook").val().trim();					
	//检查格式
	//发送Ajax请求
	$.ajax({
		url:"add.do",
		type:"post",
		data:{"userId":userId,"bookName":bookName},
		dataType:"json",
		success:function(result){
			if(result.status==0){
			//关闭对话框
			closeWindow();
			//添加一个笔记本li
			var bookId=result.data;
			//拼一个li元素
	     	createBookLi(bookName,bookId);
			alert(result.msg);
			}
		},
		error:function(){
			alert("创建笔记本失败");
			}
		});	
	}
