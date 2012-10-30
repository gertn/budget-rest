package be.budget.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.BudgetsRepository;
import be.budget.domain.budget.Budgets;

@Service
@Transactional
public class BudgetsService {
	public static final String DEFAULT_USERNAME = "DEFAULT_USERNAME";
	
	@Autowired
	private BudgetsRepository budgetsRepository;
	
	public Budgets save(Budgets budgets) {
		return budgetsRepository.save(budgets);
	}
	
	public Budgets get() {
		return budgetsRepository.findByUsername(DEFAULT_USERNAME);
	}

}
