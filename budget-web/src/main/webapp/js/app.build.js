({
    appDir: "../",
    baseUrl: "js",
    dir: "../../webapp-build",
    //Comment out the optimize line if you want
    //the code minified by UglifyJS
    optimize: "none",

    paths: {
    	router: 'app/router',
    	underscore: 'lib/underscore-min',
    	text: 'lib/text',
    	backbone: 'lib/backbone-min',
    	jquery: "lib/require-jquery",
    	bootstrap: 'lib/bootstrap.min',
    	i18n: 'lib/i18n'
    },

    modules: [
        //Optimize the application files. jQuery is not 
        //included since it is already in require-jquery.js
        {
            name: "main",
            exclude: ["jquery"]
        }
    ]
})
