basePath = '../';

files = [
  JASMINE,
  JASMINE_ADAPTER,
  'webapp/lib/angular/angular.js',
  'webapp/lib/angular/angular-*.js',
  'webapp/lib/angular/ng-*.js',
  'test/lib/angular/angular-mocks.js',
  'webapp/js/app.js',
  'webapp/js/**/*.js',
  'test/unit/**/*.js'
];

exclude = [
	'webapp/lib/angular/angular-*.min.js',
	'webapp/lib/angular/ng-*.min.js'
];

autoWatch = true;

browsers = ['Chrome'];

junitReporter = {
  outputFile: 'test_out/unit.xml',
  suite: 'unit'
};
