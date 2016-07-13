/**
 * 
 */
package kramer.poc.gcitest.jaxrs.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * @author Cosmo
 *
 */
@Provider
//@Produces({MediaType.APPLICATION_JSON})
//@Consumes(MediaType.APPLICATION_JSON)
//@Singleton
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

	
    final ObjectMapper defaultObjectMapper;
    final ObjectMapper combinedObjectMapper;

    public JacksonJsonProvider() {
        defaultObjectMapper = createDefaultMapper();
        combinedObjectMapper = createCombinedObjectMapper();
    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {

//        if (type == CombinedAnnotationBean.class) {
//            return combinedObjectMapper;
//        } else {
            return defaultObjectMapper;
//        }
    }

    private static ObjectMapper createCombinedObjectMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector())
                .setSerializationInclusion(Include.NON_EMPTY);
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result
	        .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
	        .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)        
        	.enable(SerializationFeature.INDENT_OUTPUT)
        	.setSerializationInclusion(Include.NON_EMPTY);

        return result;
    }

    private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {

        final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

        return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
    }	
	
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//    
//    static {
//      MAPPER.setSerializationInclusion(Include.NON_EMPTY);
//      //MAPPER.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
//      //MAPPER.disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//    }
// 
//    public JacksonJsonProvider() {
//        System.out.println("Instantiate JacksonJsonProvider");
//    }
//     
//    @Override
//    public ObjectMapper getContext(Class<?> type) {
//        System.out.println("JacksonJsonProvider.getContext() called with type: " + type);
//        return MAPPER;
//    } 	

}
