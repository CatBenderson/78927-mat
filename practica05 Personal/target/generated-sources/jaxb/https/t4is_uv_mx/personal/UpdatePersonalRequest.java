//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.04.12 a las 07:02:11 PM CST 
//


package https.t4is_uv_mx.personal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreNew" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cargoNew" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="experienciaNew" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="salarioNew" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "nombreNew",
    "cargoNew",
    "experienciaNew",
    "salarioNew"
})
@XmlRootElement(name = "UpdatePersonalRequest")
public class UpdatePersonalRequest {

    protected int id;
    @XmlElement(required = true)
    protected String nombreNew;
    @XmlElement(required = true)
    protected String cargoNew;
    protected int experienciaNew;
    protected float salarioNew;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreNew.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreNew() {
        return nombreNew;
    }

    /**
     * Define el valor de la propiedad nombreNew.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreNew(String value) {
        this.nombreNew = value;
    }

    /**
     * Obtiene el valor de la propiedad cargoNew.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargoNew() {
        return cargoNew;
    }

    /**
     * Define el valor de la propiedad cargoNew.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargoNew(String value) {
        this.cargoNew = value;
    }

    /**
     * Obtiene el valor de la propiedad experienciaNew.
     * 
     */
    public int getExperienciaNew() {
        return experienciaNew;
    }

    /**
     * Define el valor de la propiedad experienciaNew.
     * 
     */
    public void setExperienciaNew(int value) {
        this.experienciaNew = value;
    }

    /**
     * Obtiene el valor de la propiedad salarioNew.
     * 
     */
    public float getSalarioNew() {
        return salarioNew;
    }

    /**
     * Define el valor de la propiedad salarioNew.
     * 
     */
    public void setSalarioNew(float value) {
        this.salarioNew = value;
    }

}
