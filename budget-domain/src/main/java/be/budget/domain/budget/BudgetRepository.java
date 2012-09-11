package be.budget.domain.budget;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface BudgetRepository extends Repository<Budget, Long> {

	Budget findOne(Long id);

	Budget save(Budget entity);
	
	List<Budget> findAll();

}
