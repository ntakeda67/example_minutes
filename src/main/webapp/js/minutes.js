var minutesControllers = angular.module('minutesControllers', []);
var minutesApp = angular.module('minutesApp', ['ngRoute', 'minutesControllers']);

minutesApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/login', {
        templateUrl: 'login.html',
        controller: 'LoginControl'
      }).
      when('/meeting', {
        templateUrl: 'meeting-list.html',
        controller: 'MeetingListCtrl'
      }).
      when('/meeting/:rid', {
        templateUrl: 'meeting-detail.html',
        controller: 'MeetingDetailCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);