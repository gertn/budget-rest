define([
  'underscore',
  'backbone',
  'vent'
], function(_, Backbone, vent) {
	"use strict";
	var model = Backbone.Model.extend({
		save: function(attrs, options) {
			options = options || {};
			if(!options.error) {
				var error = function(model, xhr, options) {
					var json = !xhr.getResponseHeader('content-type').indexOf('application/json');
					var data = json ? $.parseJSON(xhr.responseText) : xhr.responseText;
					vent.trigger('ajax:error', {status: xhr.status, data: data});
				};
				_.extend(options, {error: error})
			}
			Backbone.Model.prototype.save.call(this, attrs, options);
		}
	});
	return model;
});