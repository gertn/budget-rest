var lang = 'en';
requirejs.config({
    baseUrl: 'js/app',
    paths: {
    	underscore: '../lib/underscore-min',
    	'underscore.string': '../lib/underscore.string',
    	text: '../lib/text',
    	backbone: '../lib/backbone-min',
    	marionette : '../lib/backbone.marionette',
    	bootstrap: '../lib/bootstrap.min',
    	templates: '../../templates',
    	i18n: "../lib/i18n",
    	dust: "../lib/dust-core-1.1.1",
    	dust_templates: "./templates/dust_templates"
    	
    },
    shim: {
        'underscore': {
            exports: '_'
        },
	    'backbone': {
	    	deps: ['underscore', 'jquery'],
	    	exports: 'Backbone'
	    },
        'dust': {
        	exports: 'dust'
        },
	    'dust_templates': {
	    	deps: ['dust'],
	    	exports: 'dust_templates'
	    }, 
	    'bootstrap': {
        	deps: ['jquery'],
        	exports: 'bootstrap'
        }
    },
    config: {
        i18n: {
            locale: 'nl'
        }
    }
});

require(
	['i18n!nls/general', 'marionette', 'app', 'underscore', 'underscore.string', 'dust', 'bootstrap', 'dust_templates', 
	 'controllers/controller_home', 'controllers/controller_transactions', 'controllers/controller_reports', 
	 'controllers/controller_accounts', 'controllers/controller_categories', 'controllers/controller_errors'], 
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
