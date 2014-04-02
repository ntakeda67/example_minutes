var minutesControllers = angular.module('minutesControllers');
minutesControllers.controller('LoginControl', ['$scope', '$http', '$filter', '$location', 
    function($scope, $http, $filter, $location){
        $scope.doLogin = function() {
            var loginDto = {};
            loginDto.loginId = $scope.loginId;
            loginDto.password = $scope.password;
            
            var parameter = $filter('json')(loginDto);
            
            $http({
            	method : 'POST',
            	url : '/minutes/rest/doLogin',
            	headers: { 'Content-Type': 'application/json; charset=UTF-8' },
            	data: parameter
            }).success(function(data, status, headers, config) {
            	$location.path('/menu')
            }).error(function(data, status, headers, config) {
            	alert('login failed');
            });
            
            
        }
    }
]);
