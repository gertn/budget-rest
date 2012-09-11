package be.budget.domain.transaction;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.joda.time.LocalDate;

import be.budget.common.domain.Model;
import be.budget.domain.common.Amount;

@Entity
public class Transaction extends Model {
	
	private LocalDate date;
	private Amount amount;
	private String details;
	
	@OneToMany
	private List<SubTransaction> splitTransactions;

	public LocalDate getDate() {
		return date;
	}

	public Amount getAmount() {
		return amount;
	}

	public String getDetails() {
		return details;
	}

	public List<SubTransaction> getSplitTransactions() {
		return splitTransactions;
	} 
	
}
