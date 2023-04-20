package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.models.dtos.PaymentDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class PaymentService {
    
    private CrudServices<PaymentDto> paymentService;
    
    public PaymentService() {
        paymentService = new CrudServices<>(PaymentDto.class);
    }
    
    public PaymentDto getPaymentById(Integer id) {
        return (PaymentDto) paymentService.getdtoById(id);
    }
    
    public void deletePayment(Integer id) {
        paymentService.delete(id);
    }
    
    public void updatePayment(PaymentDto paymentDto) {
        paymentService.update(paymentDto);
    }
    
    public void addPayment(PaymentDto paymentDto) {
        paymentService.add(paymentDto);
    }
    
    public List<PaymentDto> findAllPayments() {
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : paymentService.findAll()) {
            PaymentDto paymentDto = (PaymentDto) sakilaDto;
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }
}
