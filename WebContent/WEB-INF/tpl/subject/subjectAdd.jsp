<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
$(function() {
	$.get("/exam/manager/getAllSubjectTypes.action", function(data) {
		$(".subjectType").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".subjectType").append(
					"<option value='"+json[i].id+"'>" + json[i].realName
							+ "</option>");
		}
	})
	$.get("/exam/manager/getAllSubjectLevels.action", function(data) {
		$(".subjectLevel").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".subjectLevel").append(
					"<option value='"+json[i].id+"'>" + json[i].realName
							+ "</option>");
		}
	})
	$.get("/exam/manager/getAllDepartments.action", function(data) {
		$(".department").html("");
		var json = eval("(" + data + ")");
		for (var i = 0; i < json.length; i++) {
			$(".department").append(
					"<option value='"+json[i].id+"'>" + json[i].name
							+ "</option>");
		}
		$.get("/exam/manager/getTopicsbyDepartmentId.action?departmentId="
				+ $(".department option:selected").val(), function(
				data) {
			$(".subjectTopic").html("");
			var json = eval("(" + data + ")");
			for (var i = 0; i < json.length; i++) {
				$(".subjectTopic").append(
						"<option value='"+json[i].id+"'>" + json[i].title
								+ "</option>");
			}
		})
	})

	$(".department").click(
			function() {
				$.get(
				"/exam/manager/getTopicsbyDepartmentId.action?departmentId="
						+ $(".department option:selected").val(), function(data) {
					$(".subjectTopic").html("");
					var json = eval("(" + data + ")");
					for (var i = 0; i < json.length; i++) {
						$(".subjectTopic").append(
								"<option value='"+json[i].id+"'>"
										+ json[i].title
										+ "</option>");
					}
				})
			})

	$("#multiSelect").hide();
	$("#SingleSelect").show();

	$(".subjectType").click(function() {
		var id = $(this).find("option:selected").val();

		if (Number(id) == 1) {
			$("#multiSelect").hide();
			$("#SingleSelect").show();
		} else if (Number(id) == 2) {
			$("#multiSelect").show();
			$("#SingleSelect").hide();
		} else {
			$("#multiSelect").hide();
			$("#SingleSelect").hide();
		}
	})

	$(".btnR").click(
	  function() {
			var text=$(this).text();
			/*
			var obj = {};
			  obj['subject.subjectType.id'] = $(".subjectType").find("option:selected").attr("id");
			  obj['subject.subjectLevel.id'] =$(".subjectLevel").find("option:selected").attr("id");
			  obj['subject.department.id'] = $(".department").find("option:selected").attr("id");
			  obj['subject.topic.id'] = $(".subjectTopic").find("option:selected").attr("id");
			  obj['subject.stem'] =$("#stem").val();
			  obj['subject.analysis'] = $("#analysis").val();
			  obj['subject.answer'] = $("#answer").val();
			obj['choiceContent'] = {};
			obj['choiceCorrect'] = {};

			var id = $(".subjectType").find("option:selected").attr(
					"id");
			if (Number(id) == 1) {
				var $answers = $("#SingleSelect").find("textarea");
				for (var i = 0; i < $answers.length; i++) {
					alert($($answers[i]).val());
					obj['choiceContent'][i] = $($answers[i]).val();
				}
				var $correct = $("#SingleSelect").find(
						'input[name="correct"]');
				for (var i = 0; i < $correct.length; i++) {
					obj['choiceCorrect'][i] = $($correct[i]).attr(
							"checked") == "checked";
				}
			} else if (Number(id) == 2) {

			} else {

			}
			$.get("/exam/manager/saveSubject.action", obj, function() {

				if ($(this).text() == "保存并继续") {
					$(this).parents("#right").load(
							"/exam/subject/subjectAddPage.action");
				} else {
					$(this).parents("#right").load(
							"/exam/subject/subjectListPage.action");
				}

			})
			 */
			 $.post("/exam/manager/saveSubject.action", $("form").serialize(), function() {

					if (text == "保存并继续") {
						$(".editingarea").parents("#right").load(
								"/exam/subject/subjectAddPage.action");
					} else {
						$(".editingarea").parents("#right").load(
								"/exam/subject/subjectListPage.action");
					}
				})
		})		
})
	
	
	var str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var now=3;
	$(function(){
		$(".icon_add").click(function(){
			
			if(now==25){
				return false;
			}
			now++;
			
			var $option=$(this).parents(".Answeroptions").find(".Answercontent").find(".Answerpart:first").clone();
			$option.find("p").text(str.substring(now,now+1));
			$(this).parents(".Answeroptions").find(".Answercontent").append($option);
		})
		$(".icon_del").click(function(){
			if(now==1){
				return false;
			}
			now--;
			$(this).parents(".Answeroptions").find(".Answercontent").find(".Answerpart:last").remove();
			
		})
	});
</script>

<div class="editingarea">
	<div class="c_flex">
		<span class="c_flexible"></span>
	</div>
	<div class="Topictitle">添加题目</div>

	<div class="c_editview">
		<form action="/exam/manager/saveSubject.action">
			<div class="Problem">
				<div class="Attributetit">题目属性</div>
				题目类型 <select name="subject.subjectType.id" class="subjectType"></select>
				 &nbsp;&nbsp; 
				难度级别 <select name="subject.subjectLevel.id" class="subjectLevel"></select>
				&nbsp;&nbsp; 
				所属方向 <select name="subject.department.id" class="department"></select> &nbsp;&nbsp;
				所属知识点 <select name="subject.topic.id" class="subjectTopic"></select> &nbsp;&nbsp;
			</div>
			<div class="Problem">
				<div class="Attributetit">题目题干</div>
				<div class="Problemcontent">
					<textarea name="subject.stem" id="stem" cols="60" rows="4"></textarea>
				</div>
			</div>
			<!--单选视图-->
			<div id="SingleSelect" class="Answeroptions">
				<div class="Attributetit">
					答案选项<em>(通过勾选每个选项下面的框难吃时间点咳嗽打开)</em>
				</div>
				<div class="c_condition">
					<span class="icon_add"><em class="icon_r"
						style="float: left">添加选项</em></span>
						<span class="icon_del" style="float: left"><em class="icon_r"
						>减少选项</em></span>
				</div>
				<div class="Answercontent">
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>A</p>
							<span> <input name="singleCorrect" select-option value="0" 
								type="radio" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="singleContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>B</p>
							<span> <input name="singleCorrect" select-option value="1" 
								type="radio" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="singleContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>C</p>
							<span> <input name="singleCorrect" select-option value="2" 
								type="radio" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="singleContent" cols="40" rows="4"></textarea>
						</div>

						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>D</p>
							<span> <input name="singleCorrect" select-option value="3"
								type="radio" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="singleContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!--多选视图-->
			<div id="multiSelect" class="Answeroptions">
				<div class="Attributetit">
					答案选项<em>(通过勾选每个选项下面的框难吃时间点咳嗽打开)</em>
				</div>
				<div class="c_condition">
					<span class="icon_add"><em class="icon_r"
						style="float: left">添加选项</em></span>
						<span class="icon_del" style="float: left"><em class="icon_r"
						>减少选项</em></span>
				</div>
				<div class="Answercontent">
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>A</p>
							<span> <input name="multiCorrect" select-option value="0" 
								type="checkbox" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="multiContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>B</p>
							<span> <input name="multiCorrect" select-option value="1" 
								type="checkbox" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="multiContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>C</p>
							<span> <input name="multiCorrect" select-option value="2" 
								type="checkbox" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="multiContent" cols="40" rows="4"></textarea>
						</div>

						<div class="clear"></div>
					</div>
					<div class="Answerpart">
						<div class="Answerpart_left">
							<p>D</p>
							<span> <input name="multiCorrect" select-option value="3" 
								type="checkbox" /></span>
						</div>
						<div class="Answerpart_right">
							<textarea name="multiContent" cols="40" rows="4"></textarea>
						</div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>

			<div class="Problem">
				<div class="Attributetit">标准答案</div>
				<div class="Problemcontent">
					<textarea name="subject.answer" cols="60" rows="4"></textarea>
				</div>
			</div>

			<div class="Problem">
				<div class="Attributetit">答案解析</div>
				<div class="Problemcontent">
					<textarea name="subject.analysis" cols="60" rows="4"></textarea>
				</div>
			</div>

			<div class="btn_left">
				<span class="btnL"> <em class="btnR">保存并继续</em>
				</span> <span class="btnL"> <em class="btnR"">保存并关闭</em>
				</span>
			</div>
		</form>
	</div>

</div>