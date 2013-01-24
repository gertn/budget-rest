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
}).
directive('controlGroup', function($parse) {
	  var controlGroup = {
	    restrict: 'E',
	    require: '^form',
	    replace: true,
	    transclude: true,
	    templateUrl: 'views/controls/control_group_tmpl.html',
	    scope: {
	      forAttr: '@',
	      label: '='
	    },
	    link: function(scope, element, attrs) {
	    	//console.log(attrs);
	    }

	  };
	  return controlGroup;
}).
directive('inputField', function($compile) {
	var template = 
		'<control-group for-attr="{{id}}" label="label" valid="valid">'   +
		   '<input ng-disabled="disabled" type="text" class="input-large" name="{{id}}" id="{{id}}" ng-model="model"></input>' + 
		   '<span class="help-inline" ng-show="!valid" ng-bind="error_label"></span>' +
		'</control-group>';
	var inputField = {
			restrict: 'E',
			require: '^ngModel',
			replace: false,
			isolate: false,
			templateUrl: 'views/controls/input_field_tmpl.html',
			scope: {
				id: '@',
				label: '=',
				error_label: '=',
				valid: '=',
				disabled: "=",
				ngModel: "="
			},
			link: function(scope, element, attrs) {
			
				//var compiled = $compile(template)(scope);
				//element.replaceWith(compiled);
				//console.log(attrs);
			}
			
	};
	return inputField;
});