package com.lambda.trackingservice.service;

import com.lambda.trackingservice.dto.ResponseDto;

public interface OrderService {
    ResponseDto orderProcessing(Long id);
    ResponseDto outForDelivery(Long id);
    ResponseDto pickedUpForDelivery(Long id);
    ResponseDto orderDelivered(Long id);

}
