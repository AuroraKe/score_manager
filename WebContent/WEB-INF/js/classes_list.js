//本js主要实现对班级的信息管理

//定义每页显示的条数
var pageSize = 5;

//定义当前页面大小，如果不是最后一页，其值都等于pageSize；如果是最后一页，其值就会小于等于pageSize
var currPageSize = 4;

//总页数
var total_page = 100;
/*
 * 此函数通过jQuery动态显示当前页面记录，实现分页功能
*/
function classes_list(currPage, data){
	//将除首行外的数据，都清空
	$("#classes_add tr:not(:first)").empty();
	//显示当前第几页
	//$("#currPage").val(currPage);
	$("#currPage").html(currPage);
	//当前页面有几条数据
	if(currPage < total_page || data.length%pageSize == 0){
		currPageSize = 5;
	}else{
		currPageSize = data.length%pageSize;
	}
	
	//循环显示当前页面的内容
	for(var i = 0; i < currPageSize; i++){
		var class_id = data[i + (currPage - 1) * pageSize]["class_id"];
		var class_name = data[i + (currPage - 1) * pageSize]["class_name"];
		$("#classes_add").append("<tr><td>"+class_id+"</td>" +
				"<td>"+class_name+"</td><td><a href='"+contextPath+"/classes/classes_edit?class_id="+class_id+"'>修改</a></td>" +
				"<td><a href='"+contextPath+"/classes/deleteById?class_id="+class_id+"'>删除</a></td></tr>");
	}
	//如果是最后一页，页面记录可能不够pageSize条，这时将其补足
	for(var i = currPageSize; i < pageSize; i++){
		$("#classes_add").append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
	}
}

/*
 * 此函数通过jQuery动态显示当前页面记录，实现分页功能
*/
$(function() {
	$.ajax({
		//contextPath已经在首页定义过，为应用的根路径
		type: "GET",
		url: contextPath+"/classes/selectAll",
		dataType: "JSON",
		success:function(data){
			total_page = Math.ceil(data.length/pageSize);
			//显示总页数
			$("#total_page").val(total_page);
			$("#total_page").html("共"+total_page+"页");
			//当前为第几页，默认显示第一页
			var currPage = 1;
			classes_list(currPage, data);
			
			//上一页
			$("#prevPage").click(function() {
				if(currPage > 1){
					currPage = currPage - 1;
					classes_list(currPage, data);
				}else{
					return false;
				}
			});
			
			//下一页
			$("#nextPage").click(function() {
				if(currPage < total_page){
					currPage = currPage + 1;
					classes_list(currPage, data);
				}else{
					return false;
				}
			});
			
			//第一页
			$("#firstPage").click(function() {
				if(currPage != 1){
					currPage = 1;
					classes_list(1, data);
				}else{
					return false;
				}
			});
			
			//最后一页
			$("#lastPage").click(function() {
				if(currPage == total_page){
					return false;
				}else{
					currPage = total_page;
					classes_list(total_page, data);
				}
			});
		}
	});
	//通过post方式也可以实现页面的局部刷新
	/*var url = contextPath+"/classes/getAll";
	var args = {"time": new Date()};
	$.post(url, args, function(data) {
		var pageSize = 5;
		alert(data);
		for(var i = 0; i < data.length; i++){
			var class_id = data[i].class_id;
			var class_name = data[i].class_name;
			alert(class_id);
			alert(class_name);
		}
		//如果每页为五行，则总共的页数
		var total_page = Math.ceil(data.length/pageSize);
		alert(total_page);
		$("#page").val(total_page);
		for(var i = 0; i < pageSize; i++){
			var class_id = data[i].class_id;
			var class_name = data[i].class_name;
			$("#classes_add").append("<tr><td>"+class_id+"</td>" +
					"<td>"+class_name+"</td><td><a href='#'>修改</a></td>" +
					"<td><a href='#'>删除</a></td></tr>");
		}
	});*/
});