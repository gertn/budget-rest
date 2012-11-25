package be.budget.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget;
import be.budget.domain.budget.BudgetRepository;
import be.budget.domain.budget.Budgets;
import be.budget.domain.budget.BudgetsRepository;

import com.google.common.collect.Lists;

@Service
@Transactional
public class BudgetsService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	private BudgetsRepository budgetsRepository;
	
	public Budget setDefaultBudget(Budget budget) {
		Budgets budgets = findBudgets();
		return budgets.setSelectedBudget(budget);
	}
	
	public Budget getDefaultBudget() {
		Budgets budgets = findBudgets();
		return budgets == null ? null : budgets.getSelectedBudget();
	}

	@Transactional
	public Budget add(Budget budget) {
		Budgets budgets = findOrCreateBudgets();
		budgets.addBudget(budget.setStateToCreated());
		Budget savedBudget = budgetRepository.save(budget);
		budgetsRepository.save(budgets);
		return savedBudget;
	}
	
	@Transactional
	public Budget save(Budget budget) {
		Budget savedBudget = budgetRepository.save(budget);
		return savedBudget;
	}

	@Transactional(readOnly=true)
	public Budget findOne(Long id) {
		return budgetRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public List<Budget> findAll() {
		Budgets budgets = findBudgets();
		return budgets == null ? Lists.<Budget>newArrayList() : budgets.getBudgets();
	}
	
	private Budgets findOrCreateBudgets() {
		Budgets budgets = findBudgets();
		if(budgets == null) {
			budgets = Budgets.create();
		}
		return budgets;
	}

	private Budgets findBudgets() {
		return budgetsRepository.findByUsername(Budgets.DEFAULT_USERNAME);
	}

}
