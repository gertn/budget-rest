	'use strict';

/* Directives */


budgetApp.
  directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
 }]).
 directive('tooltip', function() {
    return {
        restrict:'A',
        link: function(scope, element, attrs) {
        	$(element).tooltip().click(function(){
        		$(this).tooltip('hide');
        	});
        }
    };
}).
directive('budgetform', function() {
	return {
		restrict:'E',
		 replace: true,
		 scope: {
			 title: "@formTitle",
			 resourceBundle: "=",
			 budget: "=budgetModel",
			 readOnlyMode: "=",
			 save: "&",
			 cancel: "&"
		  },
	      templateUrl: 'views/home/budget_form_tmpl.html',
	      link: function(scope, element, attrs) {
	    	  //console.log(attrs);
	      }
	};
});