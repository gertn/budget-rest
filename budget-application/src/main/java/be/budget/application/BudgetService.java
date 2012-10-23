package be.budget.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.BudgetRepository;
import be.budget.domain.budget.Budgets;

@Service
@Transactional
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public Budgets create(Budgets budgets) {
		return null;
	}
	
	public Budgets findOne(Long id) {
		return null;
	}

}
