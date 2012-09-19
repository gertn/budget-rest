requirejs.config({
    baseUrl: 'js/app',
    paths: {
    	underscore: '../lib/underscore-min',
    	text: '../lib/text',
    	backbone: '../lib/backbone-min',
    	bootstrap: '../lib/bootstrap.min'
    },
    shim: {
        'backbone': {
            //These script dependencies should be loaded before loading
            //backbone.js
            deps: ['underscore', 'jquery'],
            //Once loaded, use the global 'Backbone' as the
            //module value.
            exports: 'Backbone'
        }
    }
});

require(['router'], function(Router) {
	Router.initialize();
	
});
