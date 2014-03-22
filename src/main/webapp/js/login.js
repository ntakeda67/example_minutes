var minutesControllers = angular.module('minutesControllers', []);
minutesControllers.controller('LoginControl', ['$scope', '$http', '$filter',
    function($scope, $http, $filter){
        $scope.doLogin = function() {
            var loginDto = {};
            loginDto.loginId = $scope.loginId;
            loginDto.password = $scope.password;
            
            var parameter = $filter('json')(loginDto);
            
            $http({
            	method : 'POST',
            	url : '/minutes/rest/doLogin',
            	headers: { 'Content-Type': 'application/json; charset=UTF-8' },
            	data: parameter
            }).success(function(data, status, headers, config) {
            	alert(data);
            }).error(function(data, status, headers, config) {
            	alert('login failed');
            });
            
            
        }
    }
]);

var minutesApp = angular.module('minutesApp', ['minutesControllers']);

/*minutesApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/meeting', {
        templateUrl: 'html/meeting-list.html',
        controller: 'MeetingListCtrl'
      }).
      when('/meeting/:rid', {
        templateUrl: 'html/meeting-detail.html',
        controller: 'MeetingDetailCtrl'
      }).
      otherwise({
        redirectTo: 'html/login.html'
      });
  }]);
*/