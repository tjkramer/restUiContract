/**
 * 
 */
package kramer.poc.gcitest.jaxrs.resource;

import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import kramer.poc.gcitest.model.Contract;
import kramer.poc.gcitest.model.ServiceAgreement;

/**
 * @author Cosmo
 *
 */
@Path("/contract")
public class ContractResource {

    @GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'ContractService' is running ==> ping");
        return "ContractResource received ping on " + new Date().toString();
    }	
	
    @Path("get/{contractId}")
    @GET
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    public Contract getContract(@PathParam("contractId") String contractId){
        
    	
        Contract contract = new ServiceAgreement(contractId);
        contract.setAmount(new BigDecimal("13.00"));
        contract.setExpiring(true);
               
        System.out.println("REST call contractId = " + contractId);
        
        //return Response.ok().entity(p).build();
        return contract;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("post")
    public String postServiceAgreementContract(ServiceAgreement contract) throws Exception{
        
        System.out.println("Contract Id = " + contract.getContractId());
        System.out.println("isExpiring = " + contract.isExpiring());
        
        return "ok";
    }
}
