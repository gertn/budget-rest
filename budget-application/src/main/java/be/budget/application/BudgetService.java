package be.budget.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget;
import be.budget.domain.budget.BudgetRepository;

@Service
@Transactional
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public Budget create(Budget budget) {
		return budgetRepository.save(budget);
	}
	
	public List<Budget> findAll() {
		return budgetRepository.findAll();
	}

}
