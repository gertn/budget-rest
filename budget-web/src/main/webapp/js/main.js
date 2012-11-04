var lang = 'en';
requirejs.config({
    baseUrl: 'js/app',
    paths: {
    	underscore: '../lib/underscore-min',
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
	['i18n!nls/general', 'marionette', 'app', 'underscore', 'dust', 'bootstrap', 'main/router', 'main/controller', 'dust_templates'], 
	function(i18n, marionette, App, _, Dust, bootstrap, MainRouter, MainController){
	"use strict";
	marionette.Renderer.render = function(template, data){
		var renderedTemplate = '';
		Dust.render( template, _.extend(data, {i18n : i18n}), function(err, out) {
			renderedTemplate = out;
		});
		return renderedTemplate;
	};
	
	App.start();
	
	var router = new MainRouter({
		controller : MainController
	});
	
	_.extend(App, {router : router});
	
	if (Backbone.history) {
	    Backbone.history.start();
	}
	
});
