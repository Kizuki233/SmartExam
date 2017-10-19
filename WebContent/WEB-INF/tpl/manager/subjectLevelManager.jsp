<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="frameworks/jquery-2.1.4/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	$.get("/exam/manager/getAllSubjectLevels.action", function(data) {
		$(".subjectlevel").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".subjectlevel").append(
				"<tr>"+
				"<td class='tc'><input type='checkbox' name='subjectLevelIds' value='"+json[i].id+"'></td>"+
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
			$(".editingarea").parents("#right").load("/exam/manager/subjectLevelManagerPage.action");
			return false;
		}) 
	})
	
	$("#btnadd").click(function(){
		$(".subjectlevel").append(
		   "<tr>"+
		   "<td class='tc'><input type='checkbox'></td>"+
               "<td class='tc'><input type='text' name='subjectlevel.name' style='text-align:center'></td>"+
               "<td class='tc'><input type='text' name='subjectlevel.realName' style='text-align:center'></td>"
               +"<td class='tc'><input type='button' value='修改'></td>"
               +"</tr>"
		);		
	})
	
	$(".editingarea").on('click',"#modify",function(){
		$(this).parent("td").prev().children("input").attr("disabled",false).attr("name","subjectlevel.realName");
		$(this).parent("td").prev().prev().children("input").attr("disabled",false).attr("name","subjectlevel.name")
		$(this).parent("td").prev().prev().prev().children("input").attr("name","subjectlevel.id");	
	})
	
	$("#btnsave").click(function(){
		var obj = {};
		obj['subjectLevel.id']=$("input[name='subjectlevel.id']").val();
		obj['subjectLevel.name']=$("input[name='subjectlevel.name']").val();
		obj['subjectLevel.realName']=$("input[name='subjectlevel.realName']").val();
		
		$.post("/exam/manager/saveSubjectLevel.action",obj,function(event){
			$(".editingarea").parents("#right").load(
			   "/exam/manager/subjectLevelManagerPage.action");
		})
		
	})
}
</script>


<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
        <h3>难度管理</h3>
        <form id="deleteForm" action="/exam/manager/deleteSubjectLevel.action">
        <div class="divtable">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <tr>
                    <th width="30" class="tc">选择</th>
                    <th class="tc"><span>名称（英文）</span></th>
                    <th  class="tc" width="300" ><span>真实名称（中文）</span></th>
                    <th  class="tc" width="300" ><span>修改</span></th>
                </tr>
                <tbody class="subjectlevel">
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