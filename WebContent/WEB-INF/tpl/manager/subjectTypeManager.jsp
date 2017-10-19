<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="frameworks/jquery-2.1.4/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	$.get("/exam/manager/getAllSubjectTypes.action", function(data) {
		$(".subjecttype").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".subjecttype").append(
				"<tr>"+
				"<td class='tc'><input type='checkbox' name='subjectTypeIds' value='"+json[i].id+"'></td>"+
                "<td class='tc'><input type='text' disabled='true' value='"+json[i].name+"' style='text-align:center'></td>"+
                "<td class='tc'><input type='text' disabled='true' value='"+json[i].realName+"' style='text-align:center'></td>"
                +"<td class='tc'><input id='modify' type='button' value='修改'></td>"
                +"</tr>");
	  }
})
	Init();	
})

function Init(){
	$("#btndelete").click(function(){
		console.log($("#deleteForm").serialize());
		$.post(  $("#deleteForm").attr("action"),$("#deleteForm").serialize(),function(data){
			$(".editingarea").parents("#right").load("/exam/manager/subjectTypeManagerPage.action");
			return false;
		}) 
	})
	
	$("#btnadd").click(function(){
		$(".subjecttype").append(
		   "<tr>"+
		   "<td class='tc'><input type='checkbox'></td>"+
               "<td class='tc'><input type='text' name='subjecttype.name' style='text-align:center'></td>"+
               "<td class='tc'><input type='text' name='subjecttype.realName' style='text-align:center'></td>"
               +"<td class='tc'><input type='button' value='修改'></td>"
               +"</tr>"
		);		
	})
	
	$(".editingarea").on('click',"#modify",function(){
		$(this).parent("td").prev().children("input").attr("disabled",false).attr("name","subjecttype.realName");
		$(this).parent("td").prev().prev().children("input").attr("disabled",false).attr("name","subjecttype.name")
		$(this).parent("td").prev().prev().prev().children("input").attr("name","subjecttype.id");	
	})
	
	$("#btnsave").click(function(){
		var obj = {};
		obj['subjectType.id']=$("input[name='subjecttype.id']").val();
		obj['subjectType.name']=$("input[name='subjecttype.name']").val();
		obj['subjectType.realName']=$("input[name='subjecttype.realName']").val();
		$.post("/exam/manager/saveSubjectType.action",obj,function(event){
			$(".editingarea").parents("#right").load(
			   "/exam/manager/subjectTypeManagerPage.action");
		})
		
	})
}
</script>


<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>题型管理</h3>
        <form id="deleteForm" action="/exam/manager/deleteSubjectType.action">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>名称（英文）</span></th>
                    <th  class="tc" width="300" ><span>真实名称（中文）</span></th>
                    <th  class="tc" width="300" ><span>修改</span></th>
                </tr>
                <tbody class="subjecttype">
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