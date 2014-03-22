var minutesControllers = angular.module('minutesControllers');

minutesControllers.controller('MeetingListControl', ['$scope', 'Meeting',
	function MeetingListControl($scope, Meeting) {
		$scope.meetings = Meeting.query();
	/**
		$scope.meetings = [
		                   {'topic':'TOPIC01'}, {'topic':'TOPIC02'}
		                   ];
		                   **/
	
	}
]);