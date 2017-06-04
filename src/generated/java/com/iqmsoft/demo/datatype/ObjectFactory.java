
package com.iqmsoft.demo.datatype;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.iqmsoft.demo.datatype package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.iqmsoft.demo.datatype
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FibonacciResponse }
     * 
     */
    public FibonacciResponse createFibonacciResponse() {
        return new FibonacciResponse();
    }

    /**
     * Create an instance of {@link FibonacciFault }
     * 
     */
    public FibonacciFault createFibonacciFault() {
        return new FibonacciFault();
    }

    /**
     * Create an instance of {@link Factorial }
     * 
     */
    public Factorial createFactorial() {
        return new Factorial();
    }

    /**
     * Create an instance of {@link FactorialFault }
     * 
     */
    public FactorialFault createFactorialFault() {
        return new FactorialFault();
    }

    /**
     * Create an instance of {@link FactorialResponse }
     * 
     */
    public FactorialResponse createFactorialResponse() {
        return new FactorialResponse();
    }

    /**
     * Create an instance of {@link Fibonacci }
     * 
     */
    public Fibonacci createFibonacci() {
        return new Fibonacci();
    }

}
