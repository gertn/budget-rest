'use strict';

// Declare app level module which depends on filters, and services
var budgetApp = angular.module('budgetApp', ['ngResource', 'ngI18n', 'services.i18nNotifications']).
  config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.when('/', {templateUrl: 'views/home/home.html', controller: 'HomeController'});
    $routeProvider.when('/budgets/new', {templateUrl: 'views/home/budget.html', controller: 'BudgetController'});
    $routeProvider.when('/budgets/:budgetId', {templateUrl: 'views/home/budget.html', controller: 'BudgetController'});
    $routeProvider.when('/reports', {templateUrl: 'views/reports/reports.html', controller: 'ReportsController'});
    $routeProvider.when('/transactions', {templateUrl: 'views/transactions/transactions.html', controller: 'TransactionsController'});
    $routeProvider.when('/accounts', {templateUrl: 'views/accounts/accounts.html', controller: 'AccountsController'});
    $routeProvider.when('/categories', {templateUrl: 'views/categories/categories.html', controller: 'CategoriesController'});
    $routeProvider.otherwise({redirectTo: '/'});
    
    $httpProvider.responseInterceptors.push(function ($rootScope, $q) {
        return function (promise) {
            return promise.then(
                //success -> don't intercept
                function (response) {
                    return response;
                },
                function (response) {
                	$rootScope.$broadcast('event:error', response);
                    return $q.reject(response);
                }
            );
        };
    });
  }]);

budgetApp.value('ngI18nConfig', {
    defaultLocale: 'en',
    supportedLocales: ['en', 'nl'],
    basePath: 'i18n/resource_bundles',
    cache: true
});


budgetApp.
  value('version', '0.1');
