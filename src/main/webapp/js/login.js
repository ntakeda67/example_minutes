/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function LoginControl($scope, $http, $filter) {
    $scope.doLogin = function() {
        //alert($scope.loginId ? 'Hello' + $scope.loginId + 'test' : 'test');
        
        var loginDto = {};
        loginDto.loginId = $scope.loginId;
        loginDto.password = $scope.password;
        
        var parameter = $filter('json')(loginDto);
        
        $http({
        	method : 'POST',
        	url : '/meeting/rest/doLogin',
        	headers: { 'Content-Type': 'application/json; charset=UTF-8' },
        	data: parameter
        }).success(function(data, status, headers, config) {
        	alert(data);
        }).error(function(data, status, headers, config) {
        	alert('login Ž¸”s');
        });
        
        
    }
}




