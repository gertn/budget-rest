var lang = 'en';
requirejs.config({
    @config@
});

require(
	['i18n!nls/general', 'marionette', 'app', 'underscore', 'underscore.string', 'dust', 'bootstrap', 'dust_templates', 
	 'controllers/controller_home', 'controllers/controller_transactions', 'controllers/controller_reports', 
	 'controllers/controller_accounts', 'controllers/controller_categories', 'controllers/controller_app', 'controllers/controller_errors'], 
	function(i18n, marionette, app, _, _s, dust, bootstrap){
	"use strict";
	
	marionette.Renderer.render = function(template, data) {
		var renderedTemplate = '';
		dust.render( template, _.extend(data, {i18n : i18n}), function(err, out) {
			renderedTemplate = out;
		});
		return renderedTemplate;
	};
	
	app.start();
		
});
