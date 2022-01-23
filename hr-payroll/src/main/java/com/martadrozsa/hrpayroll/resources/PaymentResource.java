package com.martadrozsa.hrpayroll.resources;

import com.martadrozsa.hrpayroll.entities.Payment;
import com.martadrozsa.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentResource {

    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, @PathVariable Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok(payment);
    }

}
