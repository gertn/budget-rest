package be.budget.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget;
import be.budget.domain.budget.BudgetRepository;

@Service
@Transactional
public class BudgetsService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public Budget save(Budget budget) {
		return budgetRepository.save(budget);
	}
	
	@Transactional(readOnly=true)
	public Budget findOne(Long id) {
		return budgetRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public List<Budget> findAll() {
		return budgetRepository.findAll();
	}

}
