package be.budget.domain.transaction;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import be.budget.common.domain.Model;
import be.budget.domain.common.Amount;

@Entity
public class SubTransaction extends Model {

	@Embedded
	private Amount amount;
	@ManyToOne
	private Transaction transaction;

	public Amount getAmount() {
		return amount;
	}

	public Transaction getTransaction() {
		return transaction;
	}

}
