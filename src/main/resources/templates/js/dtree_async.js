$(function(){
	

         
         d2 = new dTree2('d2', true);   //参数一: 树名称。参数二：单选多选 true多选  false单选  默认单选      
         d2.add(100001, -1, '1');
         $.ajax({
				url : "/acms/dept/AjaxGetDeptList",
				async : false,//同步，等这个请求完成后才继续往下执行,这样myTree才能使用返回来的数据
				dataType: "json",
				success: function(myData) {
					for ( var i = 0; i < myData.length; i++) {
						var obj = myData[i];
						//right是window.parent的一个frame的name
						 d2.add(obj.deptid, obj.partDeptidChn, 'deptList',obj.deptid, obj.descr, false	, false);
					        
					}
					 document.write(d2);
				}
			});
      /*    <c:forEach var="deptList" items="${deptList}">
         d2.add("${deptList.deptid}", "${deptList.partDeptidChn}", 'deptList',"${deptList.deptid}", "${deptList.descr}", false	, false);
         </c:forEach> */
         
         //document.write(d2);
         //d2.openAll();
              //参数一: 树名称。参数二：单选多选 true多选  false单选  默认单选               
            /*  d.add(0, -1, '权限管理');

            // dTree实例属性以此为：  节点ID，父类ID，chechbox的名称，chechbox的值，chechbox的显示名称，
            //chechbox是否被选中--默认是不选，chechbox是否可用：默认是可用，节点链接：默认是虚链接
          
            d.openAll(); */
     		
})