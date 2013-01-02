'use strict';

budgetApp.controller('NavbarController', function NavbarController($scope, $location) {

  $scope.routeIs = function(routeName) {
    return $location.path() === routeName;
  };
  
  $scope.routeIsHome = function(routeName) {
	  var path = $location.path();
	  return path === '/' || /budgets/.test(path);
  };

});