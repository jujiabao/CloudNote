//弹出转移笔记对话框
function showMoveNoteWindow(){
			//alert("---");
			//弹出对话框
			$(".opacity_bg").show();//显示背景
			$("#can").load("alert/alert_move.html",function(){
				//在load页面载入#can之后，执行该function
				//获取笔记本列表，生成option添加到下拉选项
				var bookLis=$("#book_list li");
				for(var i=0;i<bookLis.length;i++){
				var bookName = $(bookLis[i]).text();
				var bookId=$(bookLis[i]).data("bookId");
				//拼一个option
				var s_opt="<option value='"+bookId+"'>"+bookName+"</option>";
				//将option添加到下拉单
				$("#moveSelect").append(s_opt);
				}
			});
			return false();//阻止li单击
		}
function showRecycleNoteWindow(){
			//alert("---");
			//弹出对话框
			$(".opacity_bg").show();//显示背景
			$("#can").load("alert/alert_delete_note.html");
		}
//弹出添加笔记本对话框
function showAddBookWindow(){
			//alert("---");
			//弹出对话框
			$(".opacity_bg").show();//显示背景
			$("#can").load("alert/alert_notebook.html");
		}
//弹出转移笔记对话框
function showMoveNoteWindow(){
			//alert("---");
			//弹出对话框
			$(".opacity_bg").show();//显示背景
			$("#can").load("alert/alert_move.html",function(){
				//在load页面载入#can之后，执行该function
				//获取笔记本列表，生成option添加到下拉选项
				var bookLis=$("#book_list li");
				for(var i=0;i<bookLis.length;i++){
				var bookName = $(bookLis[i]).text();
				var bookId=$(bookLis[i]).data("bookId");
				//拼一个option
				var s_opt="<option value='"+bookId+"'>"+bookName+"</option>";
				//将option添加到下拉单
				$("#moveSelect").append(s_opt);
				}
			});
			return false();//阻止li单击
		}
//关闭笔记对话框
function closeWindow(){
			$(".opacity_bg").hide();//隐藏背景div
			$("#can").empty();//清空对话框内容
		}
//弹出添加笔记对话框
function showAddNoteWindow(){
			//判断是否选中笔记本
			var $bookLi=$("#book_list a.checked");
			if($bookLi.length==0){
				alert("请选择笔记本");	
			}else{
				$(".opacity_bg").show();//显示背景
			    $("#can").load("alert/alert_note.html");
			}
			//弹出对话框	
		}