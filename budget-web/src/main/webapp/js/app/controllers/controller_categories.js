define([ 'vent', 'app', 'views/categories/categories' ], 
		function(vent, app, MainCategoriesView) {
	
	"use strict";

	vent.on('action:categories', categoriesAction);

	function categoriesAction() {
		app.main.show(new MainCategoriesView());
	};

});