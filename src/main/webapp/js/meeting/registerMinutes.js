/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var registerMinutesApp = angular.module('registerMinutesApp', ["ui.bootstrap"]);

registerMinutesApp.controller('registerMinutesControl',  ['$scope', '$http', '$filter', '$modal', function($scope, $http, $filter, $modal) {
	
	// Initialize
	var dateFilter = $filter('date');
	$scope.startDate =  dateFilter(new Date().getTime(), 'yyyy-MM-ddTHH:mm');
	$scope.endDate = dateFilter(new Date().getTime(), 'yyyy-MM-ddTHH:mm');
	$scope.nextStartDate = dateFilter(new Date().getTime(), 'yyyy-MM-ddTHH:mm');
	
	alert($scope.startDate);
	
	$scope.onConfirm = function() {
		
        $modal.open({controller: "confirmMinutesControl",
        	         templateUrl:"./confirmMinutes.html",
        	         scope: $scope});
		
	}
	
	
    $scope.onCancel = function() {
    	window.location = "./searchMeetingList.html";
	}
    
}]);


registerMinutesApp.controller('confirmMinutesControl',  ['$scope', '$modalInstance', '$http', '$filter', function($scope, $modalInstance, $http, $filter) {
	
    $scope.onRegister = function() {
		
    	var registerMinutesRequestDto = {};
    	registerMinutesRequestDto.purpose = $scope.purpose; 
    	registerMinutesRequestDto.startDate = $scope.startDate +':00.000+0900';
    	registerMinutesRequestDto.endDate = $scope.endDate +':00.000+0900';
    	registerMinutesRequestDto.place = $scope.place;
    	registerMinutesRequestDto.decision = $scope.desicion;
    	registerMinutesRequestDto.todo = $scope.todo;
    	registerMinutesRequestDto.nextStartDate = $scope.nextStartDate +':00.000+0900';
    	registerMinutesRequestDto.nextPlace = $scope.nextPlace;
    	
    	var parameter = $filter('json')(registerMinutesRequestDto);
        
        $http({
            method : 'POST',
            url : '/example_minutes/rest/registerMinutes',
            headers: { 'Content-Type': 'application/json; charset=UTF-8' },
            data: parameter
        }).success(function(data, status, headers, config) {
            
        	alert("success!!!");
        	
        	
        }).error(function(data, status, headers, config) {
            
        	alert("fail!!!");
        	
        });
		
	}
    
	
}]);

