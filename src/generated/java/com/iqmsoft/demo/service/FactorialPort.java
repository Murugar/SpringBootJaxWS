
package com.iqmsoft.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.iqmsoft.demo.datatype.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FactorialPort", targetNamespace = "http://www.iqmsoft.com/demo")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FactorialPort {


    /**
     * 
     * @param number
     * @return
     *     returns int
     * @throws FactorialFault
     */
    @WebMethod(operationName = "Factorial")
    @WebResult(targetNamespace = "http://www.iqmsoft.com/demo")
    @RequestWrapper(localName = "Factorial", targetNamespace = "http://www.iqmsoft.com/demo", className = "com.iqmsoft.demo.datatype.Factorial")
    @ResponseWrapper(localName = "FactorialResponse", targetNamespace = "http://www.iqmsoft.com/demo", className = "com.iqmsoft.demo.datatype.FactorialResponse")
    public int factorial(
        @WebParam(name = "number", targetNamespace = "http://www.iqmsoft.com/demo")
        int number)
        throws FactorialFault
    ;

}
