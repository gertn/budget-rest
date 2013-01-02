define([
  'underscore',
  'backbone',
  'util/model_util'
], function(_, Backbone, modelUtil) {
	"use strict";
	var collection = Backbone.Collection.extend({
		fetch: function(options) {
			modelUtil.addErrorToOptions(options);
			Backbone.Collection.prototype.fetch.call(this, options);
		}
	});
	return collection;
});