/**
 * 
 */
package kramer.poc.gcitest.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Cosmo
 *
 */
public abstract class Contract {

	
	protected String contractId;
	protected boolean expiring;
	protected BigDecimal amount;
	
	protected ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
	
	public abstract BigDecimal getMonthlyContractAmount();

	/**
	 * @return the contractId
	 */
	public String getContractId() {
		return contractId;
	}
	
	
	/**
	 * @return the expiring flag
	 */
	public boolean isExpiring() {
		return expiring;
	}
	
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return the invoiceList
	 */
	public ArrayList<Invoice> getInvoiceList() {
		return invoiceList;
	}



	/**
	 * @param contractId the contractId to set
	 */
	protected void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	/**
	 * @param expiring the expiring flag value to set
	 */
	public void setExpiring(boolean expiring) {
		this.expiring = expiring;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @param invoiceList the invoiceList to set
	 */
	public void setInvoiceList(ArrayList<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	/**
	 * @param invoiceList the invoice to add
	 */
	public void addInvoice(Invoice invoice) {
		this.invoiceList.add(invoice);
	}

		
}
