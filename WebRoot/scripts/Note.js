//加载笔记列表
function loadBookNotes(){
			//将当前笔记本li设置选中状态
			$("#book_list li a").removeClass("checked");
			$(this).find("a").addClass("checked");
			//alert("---");
			//获取请求参数
			var bookId=$(this).data("bookId");
			//发送Ajax请求
		$.ajax({
			url:"loadnotes.do",
			type:"post",
			data:{"bookId":bookId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var notes=result.data;//笔记数组
					$("#note_list").empty();//清除原有笔记
					//循环笔记数组，生成笔记列表
					for(var i=0;i<notes.length;i++){
						var noteTitle=notes[i].cn_note_title;
						var noteId=notes[i].cn_note_id;
						//拼成一个笔记li
				   		createNoteLi(noteId,noteTitle);
					}
				}
			},
			error:function(){
				alert("加载笔记列表失败");
			}
		});
		}
//加载笔记详情
function loadNoteDetail(){
						$("#note_list li a").removeClass("checked");
						$(this).find("a").addClass("checked");
						//alert("----");
						//获取请求参数
						var noteId=$(this).data("noteId");
						//发送Ajax请求
						$.ajax({
							url:"load.do",
							type:"post",
							data:{"noteId":noteId},	
							dataType:"json",
							success:function(result){
								if(result.status==0){
									var noteTitle=result.data.cn_note_title;
									var noteBody=result.data.cn_note_body;
									console.log(noteBody) ;
									//设置标题
									$("#input_note_title").val(noteTitle);
									//设置内容
									um.setContent(noteBody);
								}
							},
							error:function(){
						  	 alert("加载笔记失败")
						   }
						});
					}
function createNoteLi(noteId,noteTitle){
	                var s_li='<li class="online">';
						s_li+='<a>';
						s_li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
						s_li+='</a>';
						s_li+='<div class="note_menu" tabindex="-1">';
						s_li+='<dl>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
						s_li+='</dl>';
						s_li+='</div>';		
						s_li+='</li>';
						//将noteId绑定到li上
						var $li=$(s_li);
						$li.data("noteId",noteId);
						//将li添加到ul列表区
						$("#note_list").append($li);
}
function sureAddNote(){
	//获取请求参数
	var noteTitle=$("#input_note").val().trim();
	var $li=$("#book_list li a.checked").parent();
	var bookId=$li.data("bookId");
	//检查格式
	//发送Ajax请求
	$.ajax({
		url:"note/add.do",
		type:"post",
		data:{"bookId":bookId,"noteTitle":noteTitle,"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
			//关闭对话框
			closeWindow();
			//添加一个笔记本li
			var noteId=result.data;
			//拼一个li元素
	     	createNoteLi(noteId,noteTitle);
			alert(result.msg);
			}
		},
		error:function(){
			alert("创建笔记失败");
			}
		});	
	}
function showUpdateNote(){
						//检查是否选中笔记
						var $li=$("#note_list li a.checked").parent();
						if($li.length==0){
							alert("请选择笔记");
						}else{
							//获取请求参数
							var noteId =$li.data("noteId");
							var noteTitle=$("#input_note_title").val().trim();
							var noteBody=um.getContent();
							$.ajax({	
										url:"save.do",
										type:"post",
										data:{"noteTitle":noteTitle,"noteBody":noteBody,"noteId":noteId},
										dateType:"json",
										success:function(result){
											if(result.status==0){
											//更新笔记li名称
											var str='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
											$li.find("a").html(str);
											alert(result.msg);
							      }
								},
										error:function(){
											alert("保存失败")
						}
						});
						}
					}
function showNoteMenu(){
		$("#note_list").on("click",".btn_slide_down",function(){			
					//将所有笔记菜单隐藏
					$("#note_list .note_menu").hide();
					//将当前菜单显示
					var $li = $(this).parents("li");
					var $menu = $li.find(".note_menu");
					    $menu.slideDown(1000);
					$("#note_list li a.checked").removeClass("checked");
					$li.find("a").addClass("checked");
					return false;
					});
					//追加鼠标移动对笔记菜单的处理
					$("#note_list").on("mouseover",".note_menu",function(){
						$(this).show();//保持显示状态
					});
					$("#note_list").on("mouseout",".note_menu",function(){
						$(this).hide();//隐藏菜单
						});
					//点击body部分隐藏菜单
					$("body").click(function(){
					$("#note_list .note_menu").hide();
	});
					
}
//切换列表显示
function showNoteList(index){
	//将所有列表隐藏
	$(".col-xs-3").hide();
	//将指定列表显示
	$("#pc_part_"+index).show();
	
}

function showNote(index){
	//将所有列表隐藏
	$(".col-sm-7").hide();
	//将指定列表显示
	$("#pc_part_"+index).show();
	
}
//确认搜索分享笔记
function sureSearchShare(event){
	var code = event.keyCode;
	if(code==13){//按回车键
		//获取查询关键字
		var keyword = $("#search_note").val().trim();
		//发送Ajax请求
		$.ajax({
			url:"search.do",
			type:"post",
			data:{"key":keyword},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//切换列表显示区
					showNoteList(6);//搜索结果列表显示,其他隐藏
					showNote(5);
					//清空原有查询结果列表
					$("#search_list").empty();
					//循环生成笔记列表
					var notes = result.data;
					for(var i=0;i<notes.length;i++){
						var title = notes[i].cn_share_title;
						var shareId = notes[i].cn_share_id;
						var shareBody = notes[i].cn_share_body;
						//拼一个li
						var s_li ='<li class="online">';
							s_li +='	<a>';
							s_li +='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
							s_li += title;
							s_li +='	</a>';
							s_li +='</li>';
						//绑定shareId
						var $li = $(s_li);
						$li.data("shareId",shareId);
						//将li添加到搜索结果列表区
						$("#search_list").append($li);
						
						$("#noput_note_title").val(title);
						//设置内容
						um.setContent(shareBody);
					}
				}
			},
			error:function(){
				alert("检索笔记失败");
			}
		});
	}
}
function sureLookList(){
		//获取查询关键字
//		var $li=$("search_list li a").parent();
//		var shareId = $li.data("shareId");
	    var shareId=$(this).data("shareId");
//	    alert("22");
		//发送Ajax请求
		$.ajax({
			url:"look.do",
			type:"post",
			data:{"shareId":shareId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
				var shareTitle=result.data.cn_share_title;
				//alert(shareTitle);
				var shareBody=result.data.cn_share_body;
				$("#noput_note_title").html(shareTitle);
				$("#noput_note_body").html(shareBody);
				}
			},
			error:function(){
				alert("游览笔记失败");
			}
		});
	}
function sureMoveNote(){
//		//获取查询关键字
//		var $li=$("note_list li a").parent();
//	    var noteId=$li.data("noteId");
//		
//		
//		var bookId=$("#moveSelect").data("bookId");
//		//发送Ajax请求
//		$.ajax({
//			url:"move.do",
//			type:"post",
//			data:{"noteId":noteId,"bookId":bookId},
//			dataType:"json",
//			success:function(result){
//				if(result.status==0){
//					closeWindow();
//					$li.remove();
//					alert(result.msg);
//				}
//			},
//			error:function(){
//				alert("转移笔记失败");
//			}
//		});
	//获取请求参数
			var $noteLi = 
				$("#note_list a.checked").parent();
			var noteId = $noteLi.data("noteId");
			var bookId = $("#moveSelect").val();
			//TODO 检查是否选择笔记本
			//TODO 检查是否和原笔记本一样
			//发送Ajax请求
			$.ajax({
				url:"move.do",
				type:"post",
				data:{"noteId":noteId,"bookId":bookId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						closeWindow();//关闭对话框
						$noteLi.remove();//移除笔记
						alert(result.msg);//提示成功
					}
				},
				error:function(){
					alert("转移笔记失败");
				}
			});

}

