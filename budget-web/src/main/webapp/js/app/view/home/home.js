define([
  'jquery',
  'underscore',
  'backbone',
  "i18n!nls/general",
  'dust'
], function($, _, Backbone, i18n, Dust){

	var mainHomeView = Backbone.View.extend({
		render: function() {
			  var that = this;
			  Dust.render( 'home', {i18n : i18n}, function(err, out) {
				  that.$el.html(out);
			  });
		      return this;
		 }
	});
		
	return mainHomeView;
});