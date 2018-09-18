
$(document).ready(function(){
	var getWindowHeight = function(){
		var height = 0;
		// 获取窗口宽度
		if (window.innerWidth){
			height = window.innerHeight;
		}else if ((document.body) && (document.body.clientWidth)){
			height = document.body.clientHeight;
		}
		if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth){
			height = document.documentElement.clientHeight;
		}
		return height;
	};
	$("#listTableDiv").height(getWindowHeight() - 31);
	$('#roleTable').datagrid({ 
		url:'/roleList',
		idField:"id",
        fit:true,//自动补全  
        sortName:'roleCode',
        rownumbers:true,
        sortOrder:'asc',
        columns:[[      //每个列具体内容  
            {field:'id',title:'用户id',width:150,hidden:true},
            {field:'roleCode',title:'角色编号',width:100,sortable:true},
            {field:'roleName',title:'角色名称',width:100,sortable:true}
       ]],
       
	});
});
