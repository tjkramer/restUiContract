/**
 * 
 */
package kramer.poc.gcitest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Cosmo
 *
 */
public class ServiceOrder extends Contract {

	/**
	 * 
	 */
	public ServiceOrder(@JsonProperty("contractId")String contractId) {
		super.setContractId(contractId);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see kramer.poc.gcitest.model.Contract#getMonthlyContractAmount()
	 */
	@Override
	public BigDecimal getMonthlyContractAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(30.00);
	}

}
