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
public class LineItem extends Contract {

	/**
	 * 
	 */
	public LineItem(@JsonProperty("contractId")String contractId) {
		super.setContractId(contractId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal getMonthlyContractAmount() {
		// TODO Auto-generated method stub
		return new BigDecimal(10.00);
	}

}
