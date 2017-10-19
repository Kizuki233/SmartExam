/**
 * Created by lichunyu on 17/1/8.
 */

angular.module("app.subjectLevel",["ng"])
    .controller("subjectLevelController",["$scope","$routeParams","$location","subjectLevelService",
        function($scope,$routeParams,$location,subjectLevelService){
                subjectLevelService.getAllLevels(function (data) {
                        $scope.levels = data;
                })
        }])
    .factory("subjectLevelService",function ($http) {
        return {
                getAllLevels : function (handler) {
                        $http.get("/exam/manager/getAllSubjectLevel.action")
                            .success(function (data) {
                                    handler(data);
                            });
                }
        }
});