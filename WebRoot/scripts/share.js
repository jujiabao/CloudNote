function shareNote(){
						//��ȡ�ʼ�ID
						var $li = $("#note_list a.checked").parent();
						var noteId = $li.data("noteId");
						//alert(noteId);
						//����Ajax����
						$.ajax({
							url:"share.do",
							type:"post",
							data:{"noteId":noteId},
							dataType:"json",
							success:function(result){
								if(result.status==0){
									alert(result.msg);//��ʾ
								}
							},
							error:function(){
								alert("����ʧ��");
							}
						});
				
					}