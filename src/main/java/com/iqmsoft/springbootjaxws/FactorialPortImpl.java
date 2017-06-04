package com.iqmsoft.springbootjaxws;

import com.iqmsoft.demo.service.FactorialFault;
import com.iqmsoft.demo.service.FactorialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(endpointInterface = "com.iqmsoft.demo.service.FactorialPort")
@Component
public class FactorialPortImpl implements FactorialPort {

    @Autowired
    private NumberService numberService;

    public int factorial(int number) throws FactorialFault {
        if (number < 0) {
            String message = "Number cannot be negative.";
            com.iqmsoft.demo.datatype.FactorialFault fault
                    = new com.iqmsoft.demo.datatype.FactorialFault();
            fault.setMessage(message);
            fault.setFaultInfo("Number: " + number);
            throw new FactorialFault(message, fault);
        }

        return numberService.factorial(number);
    }
}
