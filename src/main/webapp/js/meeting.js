var minutesControllers = angular.module('minutesControllers');

minutesControllers.controller('MeetingListControl', ['$scope', '$http', 'Meeting', 'MeetingType', 
	function MeetingListControl($scope, $http, Meeting, MeetingType) {
		$scope.meetings = Meeting.query();
		$scope.meetingTypes = MeetingType.query();
		$scope.edittedMeeting = {};
		$scope.doEdit = function(target){
			$scope.edittedMeeting = angular.copy(target);
		}
	}
]);

minutesControllers.controller('ModifyMeetingControl', ['$scope', '$http', 'Meeting', 'MeetingType',
	function ModifyMeetingControl($scope, $http, Meeting, MeetingType){
		$scope.doRegister = function(){
			$http({
				method: 'PUT',
				url: '../rest/meetings',
				data: $scope.edittedMeeting
			}).success(function(data, status, headers, config){
				$scope.edittedMeeting = {};
				$scope.meetings = Meeting.query();
			})
				
			
		}
		
		$scope.doUpdate = function(){
				$scope.edittedMeeting = {};
				$scope.meetings = Meeting.query();
		}
}]);
