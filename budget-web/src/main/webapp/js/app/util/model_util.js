define([
  'underscore',
  'backbone',
  'util/ajaxhandler'
], function(_, Backbone, ajaxhandler) {
	"use strict";
	var addErrorToOptions = function(options) {
		options = options || {};
		if(!options.error) {
			_.extend(options, {error: ajaxhandler.error});
		}
	};
	
	return {
		addErrorToOptions: addErrorToOptions
	};
});