({
    baseUrl: "${basedir}/src/main/webapp/js",
    name: "main",
    out: "${basedir}/src/main/webapp/js/main-build-${project.version}.js",
    //optimize: "none",
    
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

    paths: {
    	i18n: 'lib/i18n',
        marionette : 'lib/backbone.marionette',
    	underscore: 'lib/underscore-min',
		'underscore.string': 'lib/underscore.string',
		bootstrap: 'lib/bootstrap.min',
    	backbone: 'lib/backbone',
    	jquery: 'empty:',
    	dust: 'lib/dust-core-1.1.1',
        nls: 'app/nls',
        app: 'app/app',
        vent: 'app/vent',
        controllers: 'app/controllers',
        views: 'app/views',
        models: 'app/models',
        util: 'app/util',
        templates: 'app/templates',
        dust_templates: 'app/templates/dust_templates'
    }
})
