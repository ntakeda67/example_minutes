var minutesServices = angular.module('minutesServices');
// 会議操作コントローラ間で状態を共有するサービス
var meetingService = minutesServices.factory('MeetingStateService', ['$rootScope', 'Meeting',
	function MeetingStateService($rootScope, Meeting){
	
		var list = [];
		var editted = {};
		var service = {
			getList: function getList(forceRefresh){
				if(forceRefresh){
					return requestList();
				}
				return list;
			},
			setEditted: function(_editted){
				editted = _editted;
				$rootScope.$broadcast('RefreshedEdittedMeeting');
			},
			getEditted: function(){return editted;}
		}
		var requestList = function(){
			list = Meeting.query();
			$rootScope.$broadcast('RefreshedMeetingList');
			return list;
		}
		
		
		return service;
}]);
var minutesControllers = angular.module('minutesControllers');

meetingService.controller('MeetingListControl', ['$scope', '$http', 'Meeting', 'MeetingType', 'MeetingStateService', 
	function MeetingListControl($scope, $http, Meeting, MeetingType, MeetingStateService) {
		$scope.meetings = MeetingStateService.getList(true);
		$scope.meetingTypes = MeetingType.query();
		$scope.doEdit = function(target){
			MeetingStateService.setEditted(angular.copy(target));
		}
		
		$scope.$on('RefreshedEdittedMeeting', function(){
			$scope.edittedMeeting = MeetingStateService.getEditted();
		});
		$scope.$on('RefreshedMeetingList', function(){
			$scope.meetings = MeetingStateService.getList(false);
		});
	}
]);

meetingService.controller('ModifyMeetingControl', ['$scope', '$http', 'Meeting', 'MeetingType','MeetingStateService',
	function ModifyMeetingControl($scope, $http, Meeting, MeetingType, MeetingStateService){
		$scope.doRegister = function(){
			var editted = MeetingStateService.getEditted();
			editted.rid = null;
			$http({
				method: 'PUT',
				url: '../rest/meetings',
				data: editted
			}).success(function(data, status, headers, config){
				MeetingStateService.setEditted({});
				MeetingStateService.getList(true);
			});
		}
		
		$scope.$on('RefreshedEdittedMeeting', function(){
			$scope.edittedMeeting = MeetingStateService.getEditted();
		});
		
		$scope.doUpdate = function(){
			$http({
				method: 'PUT',
				url: '../rest/meetings',
				data: MeetingStateService.getEditted()
			}).success(function(data, status, headers, config){
				MeetingStateService.setEditted({});
				MeetingStateService.getList(true);
			});
			// FIXME 排他エラーのハンドリング
		}
}]);
