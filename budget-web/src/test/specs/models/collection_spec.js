define([ 'jquery', 'backbone', 'models/collection', 'util/ajaxhandler' ], function($, Backbone, Collection, ajaxhandler) {
	describe("Models - Collection", function() {
		"use strict";
		
		beforeEach(function() {
			sinon.stub(Backbone, "sync");
		});
		afterEach(function() {
			Backbone.sync.restore();
		});
		
		it("should be instance of Backbone.Collection", function() {
		      expect(new Collection()).toBeInstanceOf(Backbone.Collection);
		 });

		describe('when overriding fetch', function() {
			
			beforeEach(function() {
				this.spyOnBackboneCollectionFetch = sinon.spy(Backbone.Collection.prototype, 'fetch');
				this.ExtendedCollection = Collection.extend({url: "url"});
			});
			afterEach(function() {
				Backbone.Collection.prototype.fetch.restore();
			});

			it('should call Backbone.Collection.prototype.fetch', function() {
				var options = { error: function(){}};
				
				new this.ExtendedCollection().fetch(options);
				
				expect(this.spyOnBackboneCollectionFetch).toHaveBeenCalledWith(options);
			});
			
			it('should add error callback when not provided in options', function() {
				var optionsWithoutError = {},
				options = { error: ajaxhandler.error};
				
				new this.ExtendedCollection().fetch(optionsWithoutError);
				
				expect(this.spyOnBackboneCollectionFetch).toHaveBeenCalledWith(options);
			});

		});
	});
});