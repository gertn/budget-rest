'use strict';

budgetApp.controller('ReportsController', function HomeController($scope, $location) {
	$scope.mainViewUrl = function(){
		return 'views/reports/main_reports.html';
	};
	
});