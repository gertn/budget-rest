'use strict';

budgetApp.controller('MessagesController', function MessagesController($scope, $location) {
	$scope.messages =  [ ];
	
	$scope.showMessages = function() {
		return !jQuery.isEmptyObject($scope.messages);
	};
});