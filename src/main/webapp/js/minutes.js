var minutesControllers = angular.module('minutesControllers', []);
var minutesServices = angular.module('minutesServices', ['ngResource']);
var minutesApp = angular.module('minutesApp', [
                                               'ngRoute',
                                               'minutesControllers',
                                               'minutesServices']);
minutesServices.run(function($http){
	$http.defaults.headers.post = {'Content-Type': 'application/json; charset=UTF-8'};
});

minutesApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/login', {
        templateUrl: '/minutes/html/login.html',
        controller: 'LoginControl'
      }).
      when('/meeting', {
        templateUrl: '/minutes/html/meeting-list.html',
        controller: 'MeetingListControl'
      }).
      when('/meeting/:rid', {
        templateUrl: '/minutes/html/meeting-detail.html',
        controller: 'MeetingDetailCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);

minutesServices.factory('Meeting', ['$resource', '$http', 
    function($resource){
		return $resource('../rest/meetings', {}, {
			query: {method:'POST', isArray:true}
	});
}
]);

minutesServices.factory('MeetingType', ['$resource', '$http', 
    function($resource){
		return $resource('../rest/meetingTypes', {}, {
			query: {method:'POST', isArray:true}
	});
}
]);



var minutesControllers = angular.module('minutesControllers');

minutesControllers.controller('MainControl', ['$scope', '$http', '$filter', '$location', 
    function($scope, $http, $filter, $location){
        $scope.isLogined = function() {
            if (window.sessionStorage.getItem('ticketId') != null) {
                return true;
            }
            return false;
        }

        $scope.doLogout = function() {
            var authenticationDto = {};
            authenticationDto.ticketId = window.sessionStorage.getItem('ticketId');
            
            var parameter = $filter('json')(authenticationDto);
            
            $http({
                method : 'POST',
                url : '/minutes/rest/doLogout',
                headers: { 'Content-Type': 'application/json; charset=UTF-8' },
                data: parameter
            }).success(function(data, status, headers, config) {
                window.sessionStorage.removeItem('ticketId');
                $location.path('/login');
            }).error(function(data, status, headers, config) {
                window.sessionStorage.removeItem('ticketId');
                $location.path('/login');
            });
        }

    }
]);
