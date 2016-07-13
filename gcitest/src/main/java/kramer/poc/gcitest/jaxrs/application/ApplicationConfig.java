/**
 * 
 */
package kramer.poc.gcitest.jaxrs.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import kramer.poc.gcitest.jaxrs.resource.ContractResource;
import kramer.poc.gcitest.jaxrs.resource.InvoiceResource;

/**
 * @author Cosmo
 *
 */
@ApplicationPath("/gcitestservice")
public class ApplicationConfig extends ResourceConfig {
	
    public ApplicationConfig() {
        super(
                ContractResource.class,
                InvoiceResource.class,
                //CombinedAnnotationResource.class,
                // register Jackson ObjectMapper resolver
                JacksonJsonProvider.class,
                JacksonFeature.class
        );
        
        System.out.println("ApplicationConfig constructor called");
    }	
	
//public class ApplicationConfig extends Application {
//
//	@Override
//    public Set<Class<?>> getClasses() {
//        
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        
//        System.out.println("REST configuration starting: getClasses()");            
//        
//        //features
//        //this will register Jackson JSON providers
//        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
//        //we could also use this:
//        //resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
//        
//        //instead let's do it manually:
//        resources.add(kramer.poc.gcitest.jaxrs.provider.JacksonJsonProvider.class);
//        resources.add(kramer.poc.gcitest.jaxrs.resource.ContractResource.class);
//        resources.add(kramer.poc.gcitest.jaxrs.resource.InvoiceResource.class);
//        //==> we could also choose packages, see below getProperties()
//        
//        System.out.println("REST configuration ended successfully.");
//        
//        return resources;
//    }
//    
//    @Override
//    public Set<Object> getSingletons() {
//        return Collections.emptySet();
//    }
//    
//    @Override
//    public Map<String, Object> getProperties() {
//        Map<String, Object> properties = new HashMap<>();
//        
//        //in Jersey WADL generation is enabled by default, but we don't 
//        //want to expose too much information about our apis.
//        //therefore we want to disable wadl (http://localhost:8080/service/application.wadl should return http 404)
//        //see https://jersey.java.net/nonav/documentation/latest/user-guide.html#d0e9020 for details
//        properties.put("jersey.config.server.wadl.disableWadl", true);
//        
//        //we could also use something like this instead of adding each of our resources
//        //explicitly in getClasses():
//        //properties.put("jersey.config.server.provider.packages", "com.nabisoft.tutorials.mavenstruts.service");
//        
//        
//        return properties;
//    }    
}
