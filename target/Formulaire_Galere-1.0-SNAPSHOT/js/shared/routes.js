app.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/page1', {
		templateUrl: 'templates/pages/page1.html',
		controller: 'userCtrl',
	});

	$routeProvider.when('/page2', {
		templateUrl: 'templates/pages/page2.html',
		controller: 'companyCtrl',
	});

	$routeProvider.when('/page3', {
		templateUrl: 'templates/pages/page3.html'
	});

	$routeProvider.otherwise({
		redirectTo: '#',
	});
}]);