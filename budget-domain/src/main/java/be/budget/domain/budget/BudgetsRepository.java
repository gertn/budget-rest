package be.budget.domain.budget;

import org.springframework.data.repository.Repository;

public interface BudgetsRepository extends Repository<Budgets, Long> {

	Budgets findByUsername(String username);

	Budgets save(Budgets entity);
	
}
