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
function teacher_list(currPage, data){
	if(data == null || data.length <= 0){
		for(var i = 0; i < pageSize; i++){
			$("#teacher_list").append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
		}
		return;
	}
	//将除首行外的数据，都清空
	$("#teacher_list tr:not(:first)").empty();
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
		var teacher_id = data[i + (currPage - 1) * pageSize]["teacher_id"];
		var teacher_name = data[i + (currPage - 1) * pageSize]["teacher_name"];
		var college_name = data[i + (currPage - 1) * pageSize]["college"]["college_name"];
		$("#teacher_list").append("<tr><td>"+teacher_id+"</td>" +
				"<td>"+teacher_name+"</td>" +
				"<td>"+college_name+"</td>" +
				"<td><a href='#' data-toggle='modal' data-target='#mymodal'>修改</a></td>" +
				"<td><a href='"+contextPath+"/teacher/deleteById/"+teacher_id+"'>删除</a></td></tr>");
	}
	//如果是最后一页，页面记录可能不够pageSize条，这时将其补足
	for(var i = currPageSize; i < pageSize; i++){
		$("#teacher_list").append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
	}
}

/*
 * 此函数可以通过点击超链接切换按钮
 * */
$(function() {
	$("#teacher_a_select").click(function() {
		$("#selectByName").show();
		$("#teacher_button_add").hide();
	});
	$("#teacher_a_add").click(function() {
//		$("#selectByName")[0].style.display = 'none';
//		$("#teacher_button_add")[0].style.display = 'block';
		$("#selectByName").hide();
		$("#teacher_button_add").show();
	});
});

/*
* 此函数通过jQuery动态显示当前页面记录，实现分页功能
*/
$(function() {
	var url2 = contextPath+"/college/selectAllCollege";
	$("#filter_college").load(url2);
	var filter_college = 0;
	var teacher_name = null;
	//此函数实现了查询功能
	$("#selectByName").click(function() {
		//将除首行外的数据，都清空
		$("#teacher_list tr:not(:first)").empty();
		filter_college = $("#filter_college").val();
		teacher_name = $("#teacher_name").val();
		//通过post方式也可以实现页面的局部刷新
		var url = contextPath+"/teacher/selectByName";
		var args = {"filter_college": filter_college, "teacher_name": teacher_name};
		$.post(url, args, function(data) {
			total_page = Math.ceil(data.length/pageSize);
			//显示总页数
			$("#total_page").val(total_page);
			$("#total_page").html("共"+total_page+"页");
			//当前为第几页，默认显示第一页
			var currPage = 1;
			teacher_list(currPage, data);
			
			//上一页
			$("#prevPage").click(function() {
				if(currPage > 1){
					currPage = currPage - 1;
					teacher_list(currPage, data);
				}else{
					return false;
				}
			});
			
			//下一页
			$("#nextPage").click(function() {
				if(currPage < total_page){
					currPage = currPage + 1;
					teacher_list(currPage, data);
				}else{
					return false;
				}
			});
			
			//第一页
			$("#firstPage").click(function() {
				if(currPage != 1){
					currPage = 1;
					teacher_list(1, data);
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
					teacher_list(total_page, data);
				}
			});
		});
	});
	
	//对添加按钮添加时间，如果学院未选择则提示并终止提交
	$("#teacher_button_add").click(function() {
		var college_id = $("#filter_college").val();
		if(college_id == 0 || college_id == ""){
			alert("请选择学院");
			return false;
		}
	});
	
	
	//通过post方式也可以实现页面的局部刷新
	var url = contextPath+"/teacher/selectByName";
	var args = {"filter_college": filter_college, "teacher_name": teacher_name};
	$.post(url, args, function(data) {
		total_page = Math.ceil(data.length/pageSize);
		//显示总页数
		$("#total_page").val(total_page);
		$("#total_page").html("共"+total_page+"页");
		//当前为第几页，默认显示第一页
		var currPage = 1;
		teacher_list(currPage, data);
		
		//上一页
		$("#prevPage").click(function() {
			if(currPage > 1){
				currPage = currPage - 1;
				teacher_list(currPage, data);
			}else{
				return false;
			}
		});
		
		//下一页
		$("#nextPage").click(function() {
			if(currPage < total_page){
				currPage = currPage + 1;
				teacher_list(currPage, data);
			}else{
				return false;
			}
		});
		
		//第一页
		$("#firstPage").click(function() {
			if(currPage != 1){
				currPage = 1;
				teacher_list(1, data);
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
				teacher_list(total_page, data);
			}
		});
	});
});

