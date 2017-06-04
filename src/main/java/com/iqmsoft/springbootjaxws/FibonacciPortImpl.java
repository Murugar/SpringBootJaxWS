package com.iqmsoft.springbootjaxws;

import com.iqmsoft.demo.service.FibonacciFault;
import com.iqmsoft.demo.service.FibonacciPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(endpointInterface = "com.iqmsoft.demo.service.FibonacciPort")
@Component
public class FibonacciPortImpl implements FibonacciPort {

    @Autowired
    private NumberService numberService;
    
    public int fibonacci(int index) throws FibonacciFault {
        if (index < 0) {
            String message = "Index cannot be negative.";
            com.iqmsoft.demo.datatype.FibonacciFault fault
                    = new com.iqmsoft.demo.datatype.FibonacciFault();
            fault.setMessage(message);
            fault.setFaultInfo("Index: " + index);
            throw new FibonacciFault(message, fault);
        }

        return numberService.fibonacci(index);
    }
}
