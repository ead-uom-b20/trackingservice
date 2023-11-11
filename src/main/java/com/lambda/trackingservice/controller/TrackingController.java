package com.lambda.trackingservice.controller;

import com.lambda.trackingservice.dto.ResponseDto;
import com.lambda.trackingservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/tracking/status/{orderStatus}")
    public ResponseDto getTrackingByStatus(@PathVariable("orderStatus") String orderStatus) {
        return trackService.getTrackingByStatus(orderStatus);
    }

    // get order racking by orderid; ==> all all data about ord id :1
    @GetMapping("/tracking/order/{orderId}")
    public ResponseDto getTrackingByOrderId(@PathVariable("orderId") Long orderId) {
        return trackService.getTrackingByOrderId(orderId);
    }
}
