define({
	budget_title: 'Budget',
    home: 'Home',
    transactions: 'Verrichtingen',
    reports: 'Rapporten',
    accounts: 'Rekeningen',
    categories: 'Rubrieken',
    language: 'Taal',
    budget: {
    	new_budget: 'Nieuw Budget',
    	update_budget: 'Budget wijzigen',
    	default_budget: 'Standaard Budget',
    	select_budget: 'Selecteer budget',
    	name_help: 'Naam hierboven invullen, moet tussen 4 en 40 karakters liggen.',
    	year_help: 'Jaar hierboven invullen, een nummer en moet liggen tussen 1900 en 9999.',
    	description_help: 'Omschrijving hierboven invullen, maximum 255 karakters toegelaten.'
    },
    properties: {
    	name: 'Naam',
    	year: 'Jaar',
    	description: 'Omschrijving'
    },
    buttons: {
    	save: 'Bewaren',
    	cancel: 'Annuleren',
    	set_default: 'Zet als standaard'
    },
    messages: {
    	'{javax.validation.constraints.Min.message}': '%(property)s - moet groter of gelijk zijn aan %(value)s',
    	'{javax.validation.constraints.Size.message}': '%(property)s - moet liggen tussen %(min)s en %(max)s',
    	'{javax.validation.constraints.NotNull.message}': '%(property)s - is verplicht'
    }
});