define([
  'jquery',
  'underscore',
  'marionette',
  'backbone',
  'views/main/nav/navigator',
  "i18n!nls/general",
  'underscore.string',
  'dust'
], function($, _, marionette, Backbone, Navigator, i18n, _s, dust){
	"use strict";
	return marionette.ItemView.extend({
		className: 'alert alert alert-error',
		render: function() {
			var self = this;
			//move format errors to error handler
			var formattedErrors = this.formatErrors(self.options.errors);
			dust.render( "errors_tpl", {i18n : i18n, data: {errors: formattedErrors}}, function(err, out) {
				self.$el.append(out);
			});
		 },
		 formatErrors: function(errors){
			 var self = this,
			 formattedErrors = [],
			 addError = function(error, key){ 
				 var messageKey = i18n.messages[error.messageKey];
				 var attributes = self.extractAttributes(error);
				 try {
					 messageKey = _s.sprintf(messageKey, attributes);
				 } catch(err) {
					 messageKey = self.extractProperty(error) + ' - ' + messageKey;
				 }
				 formattedErrors[key] = messageKey;
			 };
			 
			 if(_.isArray(errors.errors)){
				 _.each(errors.errors, function(error, key) { 
					addError(error, key);
				 });
			 } else if(_.isObject(errors.errors) ) {
				 addError(errors.errors, 0);
			 }
			 
			 return formattedErrors;
		 },
		 extractAttributes: function(error){
			 var self = this,
			 attributes = {};
			 
			 attributes.property = self.extractProperty(error);
			 if(_.isArray(error.attributes)){
				 _.each(error.attributes, function(attr){ 
					 attributes[attr.key] = attr.value;
				 });
			 } else if(_.isObject(error.attributes) ) {
				 var attr = error.attributes;
				 attributes[attr.key] = attr.value;
			 }
			 return attributes;
		 },
		 extractProperty: function(error){
			 return i18n.properties[error.property] ? i18n.properties[error.property]: error.property;
		 }
	
		
	});
	
	
});