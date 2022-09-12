package com.microservico.estoquepreco.controller;

import com.microservico.estoquepreco.service.RabbitmqService;
import constants.ConstantsRabbitmq;
import dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "stock")
public class StockController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity chanceStock(@RequestBody StockDto stockDto) {
        System.out.println(stockDto.getProductCode());
        this.rabbitmqService.sendMessage(ConstantsRabbitmq.STOCK_QUEUE, stockDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
