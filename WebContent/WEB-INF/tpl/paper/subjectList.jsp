<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.Catalogcontentup ul {
	margin: 15px;
}

.Catalogcontentup ul li {
	line-height: 22px;
}
.selected{
	background-color:#DCDCDC;
	color:#ffffff;
}
</style>
<script>

	var obj={};
	obj['subject.subjectType.id']=0;
	obj['subject.subjectLevel.id']=0;
	obj['subject.department.id']=0;
	obj['subject.topic.id']=0;
	obj['simplePageInfo.currentPage']=1;
	
	//异步加载开始
	
	
	$(function() {
		$(".toAction").click(function() {
			$(this).parents("#right").load($(this).attr('href'));
			return false;
		})
		getSubjectTypes();
	})
    function getSubjectTypes(){
		
		 $.get("/exam/manager/getAllSubjectTypes.action", function(data) {
				$(".subjectType").html("<a href='javacript:void(0)'class='active3'  id=0>全部</a>");
				var json = eval("(" + data + ")");
				for (var i = 0; i < json.length; i++) {
					$(".subjectType").append(
							"<a href='javacript:void(0)'  id="+json[i].id+">" + json[i].realName
									+ "</a>");
				}
				//btnInit();
				getAllSubjectLevels();
			}) 
		
	}
   
	function getAllSubjectLevels(){
		$.get("/exam/manager/getAllSubjectLevels.action", function(data) {
			$(".subjectLevel").html("<a href='javascript:void(0)' class='active3' id=0>全部</a> ");
			var json = eval("(" + data + ")");
			for (var i = 0; i < json.length; i++) {
				$(".subjectLevel").append(
						"<a href='javascript:void(0)' id="+json[i].id+">" + json[i].realName
								+ "</a>");
			}
			//btnInit();
			getAllDepartments();
		}) 
		
	}
	function getAllDepartments(){
		$.get("/exam/manager/getAllDepartments.action", function(data) {
			$(".department").html("<a href='javascript:void(0)' class='active3' id=0>全部</a> ");
			var json = eval("(" + data + ")");
			for (var i = 0; i < json.length; i++) {
				$(".department").append(
						"<a href='javascript:void(0)' id="+json[i].id+">" + json[i].name
						+ "</a>");
			}
			getAllTopics();	
			btnInit();
			subjectRefresh();
		})
		
	}
	
	
	function getAllTopics(){
		
		
		if(obj['subject.department.id']==0){
			
			$(".subjectTopic").html("<a href='javascript:void(0)' class='active3' id=0>全部</a> ");
			/* $.get("/exam/manager/getAllTopics.action", function(data) {
				$(".subjectTopic").html("<a href='javascript:void(0)' class='active3' id=0>全部</a> ");
				var json = eval("(" + data + ")");
				for (var i = 0; i < json.length; i++) {
					$(".subjectTopic").append(
							"<a href='javascript:void(0)' id="+json[i].id+">" + json[i].title
							+ "</a>");
				}
			})  */
		}
		else{
			$.get("/exam/manager/getTopicsbyDepartmentId.action?departmentId="+obj['subject.department.id'], function(data) {
				$(".subjectTopic").html("<a href='javascript:void(0)' class='active3' id=0>全部</a> ");
				var json = eval("(" + data + ")");
				for (var i = 0; i < json.length; i++) {
					$(".subjectTopic").append(
							"<a href='javascript:void(0)' id="+json[i].id+">" + json[i].title
							+ "</a>");
				}
				topicBtnInit();
			}) 
		}
		
	}
	
	//事件绑定

	function btnInit(){
		$(".subjectType").find("a").click(function(){
			$(this).siblings("a").removeClass("active3");
			$(this).addClass("active3");
			obj['subject.subjectType.id']=$(this).attr("id");
			subjectRefresh();
		})
		$(".subjectLevel").find("a").click(function(){
			$(this).siblings("a").removeClass("active3");
			$(this).addClass("active3");
			obj['subject.subjectLevel.id']=$(this).attr("id");
			subjectRefresh();
		})
		$(".department").find("a").click(function(){
			$(this).siblings("a").removeClass("active3");
			$(this).addClass("active3");
			obj['subject.department.id']=$(this).attr("id");
			obj['subject.topic.id']=0;
			getAllTopics();
			subjectRefresh();
		})
		
		$("#stemInput").focus();
		//失去焦点的事件...
		$("#stemInput").blur(function(){
			if($(this).val()!=obj['subject.stem']){
				obj['subject.stem']=$(this).val();
				
				subjectRefresh();
			}
		})
		
		//键盘敲下去离开的事件
		
		$("#stemInput").bind("keyup",function(){
			if($(this).val()!=obj['subject.stem']){
				obj['subject.stem']=$(this).val();
				
				subjectRefresh();
			}
			
			
		})
		
		/* $("#stemInput").change(function(){
			obj['subject.stem']=$(this).val();
			
			subjectRefresh();
		}) */
	}
	
	function topicBtnInit(){
		$(".subjectTopic").find("a").click(function(){
			$(this).siblings("a").removeClass("active3");
			$(this).addClass("active3");
			obj['subject.topic.id']=$(this).attr("id");
			subjectRefresh();
		})
		
	}
	
	
	//subject容器
	var $subjectContainer=$(".subjectContainer");
	//subject模板，用于复制生成subject
	var $subjectModel=$(".Catalog_rightnei");
	
	var $subjectTitle=$(".Catalogtitle");
	
	
	$subjectModel.hide();
	
	titleBtnInit();
	
	subjectBtnInit();
	var str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	//var pageCount=1;
	
	
	//subject刷新
	
	function subjectRefresh(){
		$.post("/exam/manager/getSubjectsByCriteria.action",obj,function(data) {
			/*  $(".subjectTopic").html("<a href='javascript:void(0)' hidden='0'>全部</a> ");
			var json = eval("(" + data + ")");
			for (var i = 0; i < json.length; i++) {
				$(".subjectTopic").append(
						"<a href='javascript:void(0)' hidden="+json[i].id+"'>" + json[i].title
						+ "</a>");
			}  */
			$subjectContainer.html("");
			
			//$subjectContainer.append($subjectTitle);
			
			
			
			var pageInfo= eval("(" + data + ")");
			
			//pageCount=pageInfo.pageCount;
				
			var totalCount=pageInfo.totalCount;
			$("#totalCount").text(totalCount);
			var currentPage=pageInfo.currentPage;
			
			obj['simplePageInfo.currentPage']=currentPage;
			$("#currentPage").text(currentPage);
			var pageCount=pageInfo.pageCount;
			var subjects=pageInfo.models;
			for(var i=0;i<subjects.length;i++){
				var $subject=$subjectModel.clone(true);
				
				$subject.find(".stem").text(subjects[i].stem);
				
				$subject.find(".id").text(subjects[i].id);
				
				$subject.find(".subjectType").text(subjects[i].subjectType.realName);
				
				$subject.find(".subjectLevel").text(subjects[i].subjectLevel.realName);
				
				$subject.find(".checkState").text(subjects[i].checkState);
				
				$subject.find(".user").text(subjects[i].user);
				
				$subject.find(".uploadTime").text(subjects[i].uploadTime);
				
				$subject.find(".topic").text(subjects[i].topic.title);
				
				var choices=subjects[i].choices;
				
				var $choices=$subject.find(".choices");
				
				$choices.html("");
				
				for(var j=0;j<choices.length;j++){
					$choices.append("<li>"+str.substring(j,j+1)+" "+choices[j].content+"</li>");
				}
				
				$subject.find(".analysis").text(subjects[i].analysis);
				
				$subject.find(".answer").text(subjects[i].answer);
				
				$subjectContainer.append($subject);
				
				
				$subject.show();
			}
			showAnswerAndAnalysis();
			//subjectBtnInit();
		}) 
		
	}
	
	
	
	
	//根据选择是否显示答案和解析
	function showAnswerAndAnalysis(){
		if($("#showAnswerBtn").attr("checked")=="checked"){
			$(".answerAndAnalysis").show();
		}else{
			$(".answerAndAnalysis").hide();
		}
	}
	
	function titleBtnInit(){
		
		$(".pageone").click(function(){
			obj['simplePageInfo.currentPage']=obj['simplePageInfo.currentPage']-1;
			/*if(obj['simplePageInfo.currentPage']<=0){
				obj['simplePageInfo.currentPage']=1;
			}
			alert(obj['simplePageInfo.currentPage']);*/			
			subjectRefresh();
		})
		$(".pagetwo").click(function(){
			obj['simplePageInfo.currentPage']=obj['simplePageInfo.currentPage']+1;
			/*if(obj['simplePageInfo.currentPage']>pageCount){
				obj['simplePageInfo.currentPage']=pageCount;
			}
			alert(obj['simplePageInfo.currentPage']);*/
			subjectRefresh();
		})
		$("#showAnswerBtn").click(function(){
			showAnswerAndAnalysis();
		})
		
	}
	var $paperSubjectModel=$(".paperSubjectModel");
	
	
	function subjectBtnInit(){
		$(".addSubjectBtn").click(function(){
			var $self=$(this);
			var $subject=$self.parents(".Catalog_rightnei");
			var id=$subject.find(".id").text();
			var stem=$subject.find(".stem").text();
			var subjectLevel=$subject.find(".subjectLevel").text();
			var subjectType=$subject.find(".subjectType").text();
			var topic=$subject.find(".topic").text();
			var $paperSubjects=$(".editingarea").parents(".subjectList").siblings(".editingarea").find(".paperSubjects");
			var $paperSubject=$paperSubjectModel.clone(true);
			
			
			$paperSubject.find(".stem").text(stem);
			$paperSubject.find(".level").text(subjectLevel);
			$paperSubject.find(".topic").text(topic);
			$paperSubject.find(".type").text(subjectType);
			$paperSubject.find(".subjectIds").val(id);
			$paperSubjects.append($paperSubject);
			$paperSubject.show();
			sumScores();
		})
		
	} 
	
	
</script>



<div class="editingarea">
	<div class="c_flex">
		<span class="c_flexible"></span>
	</div>
	<div class="c_editview">
		<div class="c_condition">
			<span><select><option>题干</option></select></span> <span class="pl5 "><input
				id="stemInput" type="text"></span> 
		</div>
		<div class="divtable">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="tablea">
				<tr>
					<td align="center" style="width: 50px;">题型</td>
					<td align="left">
						<div class="subjectType chose">
							<a  href="javacript:void(0)">全部</a>
						</div>
					</td>
				</tr>
				<tr>
					<td align="center">难度</td>
					<td align="left">
						<div class="subjectLevel chose" >
							<a href="javascript:void(0)" >全部</a> 
						</div>
					</td>
				</tr>
				<tr>
					<td align="center">方向</td>
					<td align="left">
						<div class="department chose">
							<a href="javascript:void(0)">全部</a> 
						</div>
					</td>
				</tr>
				<tr>
					<td align="center">知识点</td>
					<td align="left">
						<div class="subjectTopic chose">
							<a
								href="javacript:void(0)">全部</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="Catalog">

			<div class="Catalog_right">
				<div class="Catalogtitle">
					总计<em id="totalCount">totalCount</em>道题&nbsp;&nbsp; 提示：单击体面可显示答案和解析&nbsp;&nbsp; <input
						id="showAnswerBtn" type="checkbox" ng-model="isShow" /><b>显示答案和解析</b>&nbsp;&nbsp;
					<div>
						<i id="currentPage">currentPage</i><a href="javascript:void(0)" class="pageone">前</a><a href="javascript:void(0)"
							class="pagetwo">后</a>
					</div>
				</div>
			</div>
			<div class="Catalog_rightnei" ng-repeat="subject in subjects">
					<div class="Catalogtitwo">
						<b>题号：</b><span class="id">3</span>&nbsp;&nbsp; 
						<b>题型：</b><span class="subjectType">单选</span>&nbsp;&nbsp; 
						<b>难度：</b><span class="subjectLevel">中等</span>&nbsp;&nbsp;
						<b>审核状态：</b><span class="checkState" style="color: red">未审核</span>&nbsp;&nbsp; 
						<b>上传人：</b><span class="user">王江涛</span>&nbsp;&nbsp;
						<b>上传时间:</b><span class="uploadTime">2018-08-24</span>&nbsp;&nbsp;
						<b class="topic" style="display:none"></b>
					</div>
					<div class="Catalogcontent">
						<div class="Catalogcontentup">
							<!--题干-->
							<div style="margin-top:10px"><b class="stem">java的特性不包括哪项</b></div>
							
							<!--题目选项-->
							<ul class="choices">
								<li ng-repeat="choice in subject.choices">A 继承</li>
								<li ng-repeat="choice in subject.choices">B 封装</li>
							
								<li ng-repeat="choice in subject.choices">C 多态</li>
							
								<li ng-repeat="choice in subject.choices">D 面向过程</li>
							</ul>
							<div class="answerAndAnalysis" ng-show="isShow">
								<b>正确答案：</b> <span class="answer">D</span> <br><br>
								<b>答案解析：</b> <span class="analysis">很明显不对</span>
							</div>
						</div>
						<div class="Catalogcontentdown">
                            <a  href="javascript:void(0)" class="addSubjectBtn">加入试卷</a>
                        </div>
					</div>
				</div>
			
			<div class="subjectContainer">
				
			
			<div>
			<div class="clear"></div>
		</div>
	</div>
</div>
</div>
</div>
</div>