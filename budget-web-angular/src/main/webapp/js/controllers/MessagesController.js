'use strict';

budgetApp.controller('MessagesController', function HomeController($scope, $location) {
	$scope.messages =  [ ];
	
	$scope.showMessages = function() {
		return !jQuery.isEmptyObject($scope.messages);
	};
});