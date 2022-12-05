package com.erick.dsmeta.services;

import com.erick.dsmeta.entities.Sale;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SmsService {

    private final SaleService saleService;
    @Value("${twilio.sid}")
    private String twilioSid;
    @Value("${twilio.key}")
    private String twilioKey;
    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;
    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public void sendSms(Long saleId) {

        Sale sale = saleService.findById(saleId);

        String msg = """
                Vendedor %s foi destaque em %s com um total de R$%s
                """.formatted(
                sale.getName(),
                sale.getDate().toString(),
                String.format("%.2f", sale.getAmount())
        );

        Twilio.init(twilioSid, twilioKey);

        Message message = Message.creator(
                        new PhoneNumber(twilioPhoneTo),
                        new PhoneNumber(twilioPhoneFrom),
                        msg)
                .create();

        log.info(message.getSid());
    }

}
