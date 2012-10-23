var lang = 'en';
requirejs.config({
    baseUrl: 'js/app',
    paths: {
    	underscore: '../lib/underscore-min',
    	text: '../lib/text',
    	backbone: '../lib/backbone-min',
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

require(['app_main', 'underscore', 'bootstrap', 'dust_templates'], function(AppMain, _, dust, bootstrap){
	AppMain.init();
});
