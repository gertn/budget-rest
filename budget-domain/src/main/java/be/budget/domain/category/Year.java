package be.budget.domain.category;

import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import be.budget.domain.category.Month.April;
import be.budget.domain.category.Month.August;
import be.budget.domain.category.Month.December;
import be.budget.domain.category.Month.February;
import be.budget.domain.category.Month.January;
import be.budget.domain.category.Month.July;
import be.budget.domain.category.Month.June;
import be.budget.domain.category.Month.March;
import be.budget.domain.category.Month.May;
import be.budget.domain.category.Month.November;
import be.budget.domain.category.Month.October;
import be.budget.domain.category.Month.September;
import be.budget.domain.common.Amount;
import be.budget.domain.transaction.SubTransaction;

import com.google.common.collect.ImmutableMap;

@Embeddable
public class Year {

	public Month january = new January();
	public Month february = new February();
	public Month march = new March();
	public Month april = new April();
	public Month may = new May();
	public Month june = new June();
	public Month july = new July();
	public Month august = new August();
	public Month september = new September();
	public Month october = new October();
	public Month november = new November();
	public Month december = new December();
	
	@Transient
	private ImmutableMap<Integer, Month> months;

	public Amount getTotalBudget() {
		return january.getBudgetAmount().add(february.getBudgetAmount()).add(march.getBudgetAmount()).add(april.getBudgetAmount()).add(may.getBudgetAmount()).add(june.getBudgetAmount())
				.add(july.getBudgetAmount()).add(august.getBudgetAmount()).add(september.getBudgetAmount()).add(october.getBudgetAmount())
				.add(november.getBudgetAmount()).add(december.getBudgetAmount());
	}
	
	public void add(SubTransaction transaction, Integer month){
		throw new UnsupportedOperationException();
	}
	
	private ImmutableMap<Integer, Month> getMonths() {
		if(months == null){
			months = ImmutableMap.<Integer, Month>builder()
					.put(Calendar.JANUARY, january)
					.put(Calendar.FEBRUARY, february)
					.put(Calendar.MARCH, march)
					.put(Calendar.APRIL, april)
					.put(Calendar.MAY, may)
					.put(Calendar.JUNE, june)
					.put(Calendar.JULY, july)
					.put(Calendar.AUGUST, august)
					.put(Calendar.SEPTEMBER, september)
					.put(Calendar.OCTOBER, october)
					.put(Calendar.NOVEMBER, november)
					.put(Calendar.DECEMBER, december)
					.build();
		}
		return months;
	}

}
