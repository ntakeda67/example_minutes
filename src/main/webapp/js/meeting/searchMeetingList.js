/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var searchMeetingListApp = angular.module('searchMeetingListApp', []);

searchMeetingListApp.controller('searchMeetingControl',  ['$scope', '$http', '$filter',function($scope, $http, $filter) {
	
	// 配列
    var searchMeetingListDto = {};
    searchMeetingListDto.loginId = 'teramoto';
    
    var parameter = $filter('json')(searchMeetingListDto);
    
    $http({
    	method : 'POST',
    	url : '/example_minutes/rest/searchMeetingList',
    	headers: { 'Content-Type': 'application/json; charset=UTF-8' },
    	data: parameter
    }).success(function(data, status, headers, config) {
    	
    	$scope.meetingList = data;
    	
    }).error(function(data, status, headers, config) {
    	alert('Search failure');
    });
    
    $scope.editMeeting = function(rid) {
    	
    	window.location = "./registerMinutes.html";
    	
    }
    
    
}]);




