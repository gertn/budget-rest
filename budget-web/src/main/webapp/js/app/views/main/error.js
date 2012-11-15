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
	
	return marionette.ItemView.extend({
		render: function() {
			var self = this;
			var formattedErrors = this.formatErrors(self.options.errors);
			dust.render( "errors_tpl", {i18n : i18n, data: {errors: formattedErrors}}, function(err, out) {
				self.$el.append(out);
			});
		 },
		 formatErrors: function(errors){
			 var self = this,
			 formattedErrors = [];
			 
			 _.each(errors.errors, function(error, key){ 
				 var messageKey = i18n.messages[error.messageKey];
				 var attributes = self.extractAttributes(error);
				 try {
					 messageKey = _s.sprintf(messageKey, attributes);
				 } catch(err) {
					 messageKey = self.extractProperty(error) + ' - ' + messageKey;
				 }
				 formattedErrors[key] = messageKey;
			});
			 
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