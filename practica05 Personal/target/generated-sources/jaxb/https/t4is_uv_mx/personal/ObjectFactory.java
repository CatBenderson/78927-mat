//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.04.12 a las 07:02:11 PM CST 
//


package https.t4is_uv_mx.personal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.t4is_uv_mx.personal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReadPersonalRequest_QNAME = new QName("https://t4is.uv.mx/personal", "ReadPersonalRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.t4is_uv_mx.personal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreatePersonalRequest }
     * 
     */
    public CreatePersonalRequest createCreatePersonalRequest() {
        return new CreatePersonalRequest();
    }

    /**
     * Create an instance of {@link CreatePersonalResponse }
     * 
     */
    public CreatePersonalResponse createCreatePersonalResponse() {
        return new CreatePersonalResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonalRequest }
     * 
     */
    public UpdatePersonalRequest createUpdatePersonalRequest() {
        return new UpdatePersonalRequest();
    }

    /**
     * Create an instance of {@link UpdatePersonalResponse }
     * 
     */
    public UpdatePersonalResponse createUpdatePersonalResponse() {
        return new UpdatePersonalResponse();
    }

    /**
     * Create an instance of {@link ReadPersonalOneRequest }
     * 
     */
    public ReadPersonalOneRequest createReadPersonalOneRequest() {
        return new ReadPersonalOneRequest();
    }

    /**
     * Create an instance of {@link ReadPersonalOneResponse }
     * 
     */
    public ReadPersonalOneResponse createReadPersonalOneResponse() {
        return new ReadPersonalOneResponse();
    }

    /**
     * Create an instance of {@link ReadPersonalResponse }
     * 
     */
    public ReadPersonalResponse createReadPersonalResponse() {
        return new ReadPersonalResponse();
    }

    /**
     * Create an instance of {@link DeletePersonalRequest }
     * 
     */
    public DeletePersonalRequest createDeletePersonalRequest() {
        return new DeletePersonalRequest();
    }

    /**
     * Create an instance of {@link DeletePersonalResponse }
     * 
     */
    public DeletePersonalResponse createDeletePersonalResponse() {
        return new DeletePersonalResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://t4is.uv.mx/personal", name = "ReadPersonalRequest")
    public JAXBElement<Object> createReadPersonalRequest(Object value) {
        return new JAXBElement<Object>(_ReadPersonalRequest_QNAME, Object.class, null, value);
    }

}
