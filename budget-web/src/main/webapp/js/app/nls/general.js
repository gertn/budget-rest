define({
  'root': {
	budget_title: 'Budget',
    home: 'Home',
    transactions: 'Transactions',
    reports: 'Reports',
    accounts: 'Accounts',
    categories: 'Categories',
    budget: {
    	new_budget: 'New Budget',
    	name_help: 'Enter name above, has to be between 4 and 40 chars.',
    	year_help: 'Enter a year above, has to be a number between 1900 and 9999.',
    	description_help: 'Enter a description above, maximum 255 chars alowed.'
    },
    properties: {
    	name: 'Name',
    	year: 'Year',
    	description: 'Description'
    },
    buttons: {
    	save: 'Save',
    	cancel: 'Cancel'
    },
    messages: {
    	'{javax.validation.constraints.Min.message}': '%(property)s - must be greater than or equal to %(value)s',
    	'{javax.validation.constraints.Size.message}': '%(property)s - size must be between %(min)s and %(max)s'
    }
  },
  'nl': true
});