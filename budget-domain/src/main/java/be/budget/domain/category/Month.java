package be.budget.domain.category;

import java.util.Collections;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import be.budget.common.domain.Model;
import be.budget.domain.common.Amount;
import be.budget.domain.transaction.SubTransaction;

import com.google.common.collect.Lists;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
public abstract class Month extends Model {
	
	@Embedded
	private Amount budgetAmount = Amount.zero();
	@OneToMany
	private List<SubTransaction> transactions = Lists.newArrayList(); 
	
	public List<SubTransaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}
	
	public Amount getBudgetAmount() {
		return budgetAmount;
	}
	
	public boolean addTransaction(SubTransaction transaction) {
		return transactions.add(transaction);
	}
	
	public Amount getActualAmount(){
		Amount actualAmount = Amount.zero();
		for (SubTransaction transaction : transactions) {
			actualAmount = actualAmount.add(transaction.getAmount());
		}
		return actualAmount;
	}
	
	@Entity
	@DiscriminatorValue(value="1")
	static class January extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="2")
	static class February extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="3")
	static class March extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="4")
	static class April extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="5")
	static class May extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="6")
	static class June extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="7")
	static class July extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="8")
	static class August extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="9")
	static class September extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="10")
	static class October extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="11")
	public static class November extends Month {
	}
	
	@Entity
	@DiscriminatorValue(value="12")
	public static class December extends Month {
	}
}