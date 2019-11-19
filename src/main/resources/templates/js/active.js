$(function ()
		{
	/*$.ajax({
		url:"/acms/navigationBar/getAuths",
		type:"POST",
		data:null,
		async: false,
		success:function(result){
			for(var i=0;i<result.length;i++){
				$("#"+result[i]).show();
				}
			 $("#sidebar_menu li").each(function(){
			    alert($(this).attr('id'))
			  });
			alert(result); 
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log(XMLHttpRequest.status+"--"+XMLHttpRequest.readyState+"--"+textStatus);
			alert("失败");
		}
		
	})*/
	
		     $('.sidebar-menu li').find('a').each(function () {
		            if (this.href == document.location.href || document.location.href.search(this.href) >= 0) {
		                $(this).parent().siblings('li').removeClass('active');
		                $(this).parent().addClass('active'); 
		                $(this).parent().parent().parent().addClass('active'); 
		            }
		        });
		     
		});