package com.lambda.trackingservice.controller;

import com.lambda.trackingservice.dto.ResponseDto;
import com.lambda.trackingservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TrackingController {

    private final TrackService trackService;
    @PostMapping("/tracking/{orderString}/{orderid}")
    ResponseDto orderPlaced(@PathVariable Long orderid, @PathVariable String orderString){
        return trackService.tracking(orderString,orderid);
    }



    // get by order status: order placed...
    // get order racking by orderid; ==> all all data about ord id :1
}
