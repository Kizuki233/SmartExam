<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="frameworks/jquery-2.1.4/jquery.min.js"></script>

<style>
.a{
background-color:transparent;
border:0px;
} 
</style>

<script type="text/javascript">
$(function(){
	$.get("/exam/manager/getAllTopics.action", function(data) {
		$(".topic").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".topic").append(
				"<tr>"+
				"<td class='tc'><input class='a' type='checkbox' name='topicIds' value='"+json[i].id+"'></td>"+
                "<td class='tc'><input class='a' type='text' disabled='true' value='"+json[i].title+"' style='text-align:center'></td>"+
                "<td class='tc'><select  style='text-align:center' disabled='true' >"+
                "<option value='"+json[i].department.id+"'>"+json[i].department.name+"</option>"+
                "<td class='tc'><input id='modify' type='button' value='修改'></td>"+
                "</tr>");
	  }
})
	Init();	
})

function search(){
	$.get("/exam/manager/getAllDepartments.action", function(data) {
		$("select[name='topic.department.name']").html("");
	    var json = eval("(" + data + ")");
	    for (var i = 0; i < json.length; i++) {
		$("select[name='topic.department.name']").append(
		"<option value='"+json[i].id+"'>"+json[i].name+"</option>");
    }	
 })
} 

function Init(){

	$("#btndelete").click(function(){
		$.post(  $("#deleteForm").attr("action"),$("#deleteForm").serialize(),function(data){
			$(".editingarea").parents("#right").load("/exam/manager/topicManagerPage.action");
			return false;
		}) 
	})
	
	$("#btnadd").click(function(){
		$(".topic").append(
		   "<tr>"+
		   "<td class='tc'><input type='checkbox'></td>"+
               "<td class='tc'><input type='text' name='topic.title' style='text-align:center'></td>"+ 
               "<td class='tc'><select  name='topic.department.name' style='text-align:center' id='departmentname'>"+ 
               "</select></td>"+
               +"<td class='tc'><input type='button' value='修改'></td>"
               +"</tr>"
		);
		search();
})
	
	$(".editingarea").on('click',"#modify",function(){
		$(this).parent("td").prev().children("select").attr("disabled",false).attr("name","topic.department.name");
		$(this).parent("td").prev().prev().children("input").attr("disabled",false).attr("name","topic.title")
		$(this).parent("td").prev().prev().prev().children("input").attr("name","topic.id");
		search();
	})
	
	$("#btnsave").click(function(){
		var obj = {};
		obj['topic.id']=$("input[name='topic.id']").val();
		obj['topic.title']=$("input[name='topic.title']").val();
		obj['topic.department.id']=$("select[name='topic.department.name']").val();
		
		console.log($("select").val());
		console.log(obj);

		$.post("/exam/manager/saveTopic.action",obj,function(event){
			$(".editingarea").parents("#right").load(
			   "/exam/manager/topicManagerPage.action");
		})
		
	})

}
</script>


<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>知识点管理</h3>
        <form id="deleteForm" action="/exam/manager/deleteTopic.action">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>知识点</span></th>
                    <th  class="tc" width="300" ><span>所属方向</span></th>
                    <th  class="tc" width="300" ><span>修改</span></th>
                </tr>
                <tbody class="topic">
                  <tr>
				  </tr>
                </tbody>
            </table>
        </div>
        </form>
        <div class="btn_left">
            <span class="btnL"><em class="btnR" id="btnadd">添加</em></span>
           <!--  <span class="btnL"><em class="btnR">修改</em></span> -->
            <span class="btnL"><em class="btnR" id='btndelete'>删除</em></span>
            <span class='btnL'><em class='btnR' id='btnsave'>保存</em></span>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
</div>