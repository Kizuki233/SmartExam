<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<script>
	
		$(function(){
			$.get("/exam/paper/getAllPapers.action",function(data){
				$(".examPaper").html("");
				var json=eval("( "+data+" )") ;
				for(var i = 0; i < json.length; i++)
					$(".examPaper").append(
					  "<tr>"+
					  "<td class='tc'><input type='checkbox' name='examPaperIds' value='"+json[i].id+"'></td>"+
					  "<td class='tc'>"+json[i].title+"</td>"+
					  "<td class='tc'>"+json[i].description+"</td>"+
					  "<td class='tc'>"+json[i].department.name+"</td>"+
					  "<td class='tc'>"+json[i].createTime+"</td>"+
					  "<td class='tc'>"+json[i].answerQuestionTime+"</td>"+
					  "<td class='tc'>"+json[i].totalPoints+"</td>"+
					  "</tr>");
				btnInit();
				
			})
		})
		
		
		function btnInit(){
			$(".delBtn").click(function(){
				console.log($("#deleteForm").serialize());
				$.post( $("#deleteForm").attr("action"),$("#deleteForm").serialize(),function(data){
					$(".editingarea").parents("#right").load("/exam/paper/paperManagerPage.action");
					return false;
				})
			})
		}
	
		
		
		
	</script>




<div class="editingarea">
    <div class="c_flex"><span class="c_flexible"></span></div>
    <div class="c_editview">
	<h3>试卷列表</h3>
	    <form id="deleteForm" action="/exam/paper/deleteExamPapers.action">
           <div class="divtable">
               <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tab1">
                <thead>
                 <tr>
                     <th width="30" class="tc">选择</th>
                     <th class="tc"><span>试题名称</span></th>
                     <th class="tc" width="300" ><span>试题描述</span></th>
                     <th class="tc"><span>所属方向</span></th>
                     <th class="tc"><span>创建时间</span></th>
                     <th class="tc"><span>答题时间</span></th>
                     <th class="tc"><span>总分</span></th>
                 </tr>
                </thead>
                 <tbody class="examPaper">
                 <!-- <tr ng-repeat="paper in papers">
                    <td class="tc"><input type="checkbox"></td>
                    <td class="tc">{{paper.title}}</td>
                    <td class="tc">{{paper.description}}</td>
                    <td class="tc">{{paper.department.name}}</td>
                    <td class="tc">{{paper.createTime}}</td>
                    <td class="tc">{{paper.answerQuestionTime}}h</td>
                    <td class="tc">{{paper.totalPoints}}</td>
                 </tr> -->
        
                </tbody>
            </table>
          </div>
        </form>
        
        
        
        <div class="btn_left">
            <span class="btnL"><em class="btnR delBtn">删除</em></span>
        </div>
    </div>
</div>

<div>
<div class="clear"></div>
</div>