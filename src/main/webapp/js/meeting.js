var minutesControllers = angular.module('minutesControllers');

minutesControllers.controller('MeetingListControl', ['$scope', '$http', 'Meeting', 'MeetingType', 
	function MeetingListControl($scope, $http, Meeting, MeetingType) {
		$scope.meetings = Meeting.query();
		$scope.meetingTypes = MeetingType.query();
		$scope.edittedMeeting = {};
		$scope.doRegister = function(){
			
		}
		
		$scope.doUpdate = function(){
			
		}
		
		$scope.doEdit = function(target){
			$scope.edittedMeeting = angular.copy(target);
		}
	}
]);

minutesControllers.controller('ModifyMeetingControl', ['$scope', '$http', 'Meeting', 'MeetingType',
	function ModifyMeetingControl($scope, $http, Meeting, MeetingType){
		$scope.purpose = $scope.edittedMeeting.purpose;
}]);
