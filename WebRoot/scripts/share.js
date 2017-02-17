function shareNote(){
						//获取笔记ID
						var $li = $("#note_list a.checked").parent();
						var noteId = $li.data("noteId");
						//alert(noteId);
						//发送Ajax请求
						$.ajax({
							url:"share.do",
							type:"post",
							data:{"noteId":noteId},
							dataType:"json",
							success:function(result){
								if(result.status==0){
									alert(result.msg);//提示
								}
							},
							error:function(){
								alert("分享失败");
							}
						});
				
					}