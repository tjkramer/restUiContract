/**
 * 
 */
package kramer.poc.gcitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Cosmo
 *
 */
public class Invoice {

	private String invoiceId;
	private String contractId;
	private boolean pastDue;
	
	/**
	 * 
	 */
	public Invoice(@JsonProperty("invoiceId")String invoiceId, 
			@JsonProperty("contractId")String contractId) {
		//-TODO: Get associated contract and search for this invoice
		//-TODO: If invoice not already associated with that contract, add it here.
		//-TODO: If no contract found, create it? 
		this.setInvoiceId(invoiceId);
		this.setContractId(contractId);
		
	}

//	public Invoice(@JsonProperty("contractId")String contractId) {
//		this.setContractId(contractId);
//	}

	
	/**
	 * @return the invoiceId
	 */
	public String getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @return the contractId
	 */
	public String getContractId() {
		return contractId;
	}
	
	/**
	 * @return the pastDue
	 */
	public boolean isPastDue() {
		return pastDue;
	}



	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	/**
	 * @param pastDue the pastDue to set
	 */
	public void setPastDue(boolean pastDue) {
		this.pastDue = pastDue;
	}

}
