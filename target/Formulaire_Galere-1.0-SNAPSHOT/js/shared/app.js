var app = angular.module('root',['ngRoute','ngResource', 'restangular']);

app.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

/*
app.config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('/js/shared/restangular.js');
});*/
