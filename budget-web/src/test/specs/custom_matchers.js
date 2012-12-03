beforeEach(function() {
	this.addMatchers({

		toBeEmpty : function() {
			return this.actual === '';
		},
		toBeInstanceOf : function(expected) {
			return this.actual instanceof expected;
		}

	});
});