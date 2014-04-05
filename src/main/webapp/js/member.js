var minutesServices = angular.module('minutesServices');
// 会議操作コントローラ間で状態を共有するサービス
var memberService = minutesServices.factory('MemberStateService', ['$rootScope', 'Member',
	function MemberStateService($rootScope, Member){
	
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
				$rootScope.$broadcast('RefreshedEdittedMember');
			},
			getEditted: function(){return editted;}
		}
		var requestList = function(){
			list = Member.query();
			$rootScope.$broadcast('RefreshedMemberList');
			return list;
		}
		
		
		return service;
}]);
var minutesControllers = angular.module('minutesControllers');

memberService.controller('MemberListControl', ['$scope', '$http', 'Member', 'MemberStateService', 
	function MemberListControl($scope, $http, Member, MemberStateService) {
		$scope.members = MemberStateService.getList(true);
		$scope.doEdit = function(target){
			MemberStateService.setEditted(angular.copy(target));
		}
		
		$scope.$on('RefreshedEdittedMember', function(){
			$scope.edittedMember = MemberStateService.getEditted();
		});
		$scope.$on('RefreshedMemberList', function(){
			$scope.members = MemberStateService.getList(false);
		});
	}
]);

memberService.controller('ModifyMemberControl', ['$scope', '$http', 'Member', 'MemberStateService',
	function ModifyMemberControl($scope, $http, Member, MemberStateService){
		$scope.doRegister = function(){
			var editted = MemberStateService.getEditted();
			editted.rid = null;
			$http({
				method: 'PUT',
				url: '../rest/member',
				data: editted
			}).success(function(data, status, headers, config){
				MemberStateService.setEditted({});
				MemberStateService.getList(true);
			});
		}
		
		$scope.$on('RefreshedEdittedMember', function(){
			$scope.edittedMember = MemberStateService.getEditted();
		});
		
		$scope.doUpdate = function(){
			$http({
				method: 'PUT',
				url: '../rest/member',
				data: MemberStateService.getEditted()
			}).success(function(data, status, headers, config){
				MemberStateService.setEditted({});
				MemberStateService.getList(true);
			});
			// FIXME 排他エラーのハンドリング
		}
}]);
