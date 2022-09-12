package com.microservico.estoquepreco.controller;

import com.microservico.estoquepreco.service.RabbitmqService;
import constants.ConstantsRabbitmq;
import dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "price")
public class PriceController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity chancePrice(@RequestBody PriceDto priceDto) {
        this.rabbitmqService.sendMessage(ConstantsRabbitmq.PRICE_QUEUE, priceDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
