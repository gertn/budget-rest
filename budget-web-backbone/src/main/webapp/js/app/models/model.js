define([
  'underscore',
  'backbone',
  'util/model_util'
], function(_, Backbone, modelUtil) {
	"use strict";
	var model = Backbone.Model.extend({
		save: function(attrs, options) {
			modelUtil.addErrorToOptions(options);
			Backbone.Model.prototype.save.call(this, attrs, options);
		},
		fetch: function(options) {
			modelUtil.addErrorToOptions(options);
			Backbone.Model.prototype.fetch.call(this, options);
		}
	});
	return model;
});