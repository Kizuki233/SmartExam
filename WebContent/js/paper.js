/**
 * Created by lichunyu on 16/9/28.
 * 试卷模块
 */
angular.module("app.paper",["ng","app.subject"])
    //试卷查询控制器
    .controller("paperListController",["$scope","paperService",function ($scope,paperService) {
        //将查询到的试卷绑定
        paperService.findAllPapers(function (data) {
            $scope.papers = data;
        })
    }])
    //试卷添加控制器
    .controller("paperAddController",["$scope","commonService","$routeParams","paperModel","paperService",function ($scope,commonService,$routeParams,paperModel,paperService) {
        commonService.getAllDepartmentes(function (data) {
            //将全部方向绑定到作用域的dps
            $scope.dps = data;
        });
        var subjectId = $routeParams.id;
        if(subjectId!=0){
            //将要添加的题目的id添加到数组中
            paperModel.addSubjectId(subjectId);
            paperModel.addSubject(angular.copy($routeParams))

        }
        //双向绑定的模板
        $scope.pmodel =paperModel.model;
        $scope.savePaper = function () {
            var model = {
                departmentId:1, //方向id
                    title:"",       //试卷标题
                    desc:"",        //试卷描述
                    at:0,           //答题时间
                    total:0,        //总分
                    scores:[],      //每个题目的分值
                    subjectIds:[],   //每个题目的id
                    subjects:[]
            };
            paperService.savePaper($scope.pmodel,function (data) {
                alert(data);
                //重置表单
                angular.copy(model,paperModel.model);
            })
        }
    }])
    //试卷删除控制器
    .controller("paperDelController",["$scope",function ($scope) {

    }])
    .factory("paperService",function ($httpParamSerializer,$http) {
        return {
            findAllPapers:function (handler) {
                $http.get("http://127.0.0.1:8888/exam/manager/getAllExamPapers.action").success(function (data) {
                    handler(data);
                });
            },
            savePaper:function (param, handler) {
                var obj = {};
                for(var key in param){
                    var val = param[key];
                    switch (key){
                        case "departmentId":
                            obj['paper.department.id'] = val;
                            break;
                        case "title":
                            obj['paper.title'] = val;
                            break;
                        case "desc":
                            obj['paper.description'] = val;
                            break;
                        case "at":
                            obj['paper.answerQuestionTime'] = val;
                            break;
                        case "total":
                            obj['paper.totalPoints'] = val;
                            break;
                        case "scores":
                            obj['scores'] = val;
                            break;
                        case "subjectIds":
                            obj['subjectIds'] = val;
                            break;
                    }
                }
                obj = $httpParamSerializer(obj);
                $http.post("http://127.0.0.1:8088/exam/manager/saveExamPaper.action",obj,{
                    headers:{
                        "Content-Type":"application/x-www-form-urlencoded"
                    }
                }).success(function (data) {
                    handler(data);
                });
            }
        }
    })
    .factory("paperModel",function () {
        return {
            //模板  单例如
            model:{
                departmentId:1, //方向id
                title:"",       //试卷标题
                desc:"",        //试卷描述
                at:0,           //答题时间
                total:0,        //总分
                scores:[],      //每个题目的分值
                subjectIds:[],   //每个题目的id
                subjects:[]
            },
            addSubjectId:function (id) {
                this.model.subjectIds.push(id);
            },
            addSubject:function (subject) {
                this.model.subjects.push(subject);
            }
        }
    });

