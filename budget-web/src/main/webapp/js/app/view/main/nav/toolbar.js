define([
  'jquery',
  'underscore',
  'backbone',
  'view/main/nav/navigator',
  "i18n!nls/general",
  'dust'
], function($, _, Backbone, Navigator, i18n, Dust){
	
	var toolbarView = Navigator.extend({
		  render: function() {
			  var that = this;
			  Dust.render( 'toolbar', {i18n : i18n}, function(err, out) {
				  that.$el.html(out);
			  });
		      return this;
		  }
	});
	
	return toolbarView;
	
});