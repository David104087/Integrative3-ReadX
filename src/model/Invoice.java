package model;
import java.util.Calendar;

public class Invoice {

	private Calendar date;
	private double amount;

	/**
	 * 
	 * @param date
	 * @param amount
	 */
	public Invoice(Calendar date, double amount) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

	public Calendar getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}