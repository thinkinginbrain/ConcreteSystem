setInterval(  //设置定时器，1s更新一次
		function(){
            $.ajax({
				url:"../TableServlet",
				type:"POST",
				dataType:"json",
				data:{},
				success:function(data){
					if(data[0].data=="正常"){
						}
					else{
						alert(data[0].data+'\n'+data[0].serial+'号节点异常');
						}
				}
			})
		},50000
);