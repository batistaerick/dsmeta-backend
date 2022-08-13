package com.erick.dsmeta.controllers;

import com.erick.dsmeta.services.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService service;

    @GetMapping("/{id}")
    public ResponseEntity<Void> sendSms(@PathVariable Long id) {
        service.sendSms(id);
        return ResponseEntity.noContent().build();
    }

}
