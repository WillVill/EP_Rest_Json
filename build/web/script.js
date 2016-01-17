angular.module('app',[])
        .controller('controller',['$scope','$http',function($scope,$http){
                $http.get('http://localhost:8080/EP_Rest_Json/api/data/15/lname,fname,street')
                .success(function(data){
                    $scope.data = data;
                })
                .error(function(data){
                    
                });
        }])