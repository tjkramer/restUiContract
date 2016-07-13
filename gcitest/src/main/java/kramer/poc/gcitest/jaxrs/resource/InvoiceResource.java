/**
 * 
 */
package kramer.poc.gcitest.jaxrs.resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import kramer.poc.gcitest.model.Invoice;

/**
 * @author Cosmo
 *
 */
@Path("/invoice")
public class InvoiceResource {


    @GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'InvoiceService' is running ==> ping");
        return "InvoiceResource received ping on " + new Date().toString();
    }	

    @Path("get")
    @GET
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})  //add MediaType.APPLICATION_XML if you want XML as well (don't forget @XmlRootElement)
    public Invoice getInvoice(){
        
        Invoice invoice = new Invoice("#SA-123", "54321");
        //invoice.setInvoiceId("54321");
        invoice.setPastDue(true);
               
        System.out.println("REST call Invoice...");
        
        //return Response.ok().entity(p).build();
        return invoice;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("post")
    public String postInvoice(Invoice invoice) throws Exception{
        
        System.out.println("postInvoice - invoiceId: " + invoice.getInvoiceId());
        System.out.println("postInvoice - contractId: " + invoice.getContractId());
        
        return "ok";
    }	
}
