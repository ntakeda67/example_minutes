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
        templateUrl: 'login.html',
        controller: 'LoginControl'
      }).
      when('/menu', {
        templateUrl: 'menu.html'
      }).
      when('/meeting', {
        templateUrl: 'meeting-list.html',
        controller: 'MeetingListControl'
      }).
      when('/member', {
        templateUrl: 'member.html',
        controller: 'MemberListControl'
      }).
      when('/meeting/:rid', {
        templateUrl: 'meeting-detail.html',
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

minutesServices.factory('Member', ['$resource', '$http', 
    function($resource){
		return $resource('../rest/member', {}, {
			query: {method:'POST', isArray:true}
	});
}
]);
