/**
 * Created by lichunyu on 17/1/8.
 */

angular.module("app.subjectType",["ng"])
    .controller("subjectTypeController",["$scope","$routeParams","$location","subjectTypeService",
        function($scope,$routeParams,$location,subjectTypeService){
            subjectTypeService.getAllTypes(function (data) {
                $scope.types = data;
            })
    }])
    .factory("subjectTypeService",function ($http) {
        return {
            getAllTypes : function (handler) {
                $http.get("/exam/manager/getAllSubjectType.action")
                    .success(function (data)  {
                        handler(data);
                    });
            }
        }
});


