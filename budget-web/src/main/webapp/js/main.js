var lang = 'en';
requirejs.config({
    baseUrl: 'js/app',
    paths: {
    	underscore: '../lib/underscore-min',
    	text: '../lib/text',
    	backbone: '../lib/backbone-min',
    	bootstrap: '../lib/bootstrap.min',
    	templates: '../../templates',
    	i18n: "../lib/i18n"
    },
    shim: {
        'underscore': {
            exports: '_'
        },
	    'backbone': {
	    	deps: ['underscore', 'jquery'],
	    	exports: 'Backbone'
	    }
    },
    config: {
        i18n: {
            locale: 'nl'
        }
    }
});

require(['app_main', 'bootstrap', 'underscore'], function(AppMain, Bootstrap, _){
	AppMain.init();
});
