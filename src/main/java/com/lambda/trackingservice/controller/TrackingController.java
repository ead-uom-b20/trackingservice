package com.lambda.trackingservice.controller;

import com.lambda.trackingservice.dto.ResponseDto;
import com.lambda.trackingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TrackingController {
    private final OrderService orderService;
    @PostMapping("/tracking/status/orderProcessing/{id}")
    ResponseDto orderProcessing(@PathVariable Long id){
        return orderService.orderProcessing(id);
    }

}
