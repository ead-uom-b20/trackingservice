package com.lambda.trackingservice.service.impl;

import com.lambda.trackingservice.domain.OrderDomain;
import com.lambda.trackingservice.dto.ResponseDto;
import com.lambda.trackingservice.repository.OrderRepository;
import com.lambda.trackingservice.service.OrderService;
import com.lambda.trackingservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ServiceUtil serviceUtil;
    @Override
    public ResponseDto orderProcessing(Long id) {
        ResponseDto responseDto;
        try{
            Optional<OrderDomain> optionalOrderDomain = orderRepository.findById(id);
            if(optionalOrderDomain.isPresent()){
                OrderDomain order = optionalOrderDomain.get();
                order.setStatus("Order Processing");
                orderRepository.save(order);
                responseDto = serviceUtil.getServiceResponse("Status changed to Order Processing ");
            }else {
                responseDto = serviceUtil.getServiceResponse("Given ID not found");
            }
        }catch (Exception e){
            responseDto = serviceUtil.getErrorServiceResponse("Can not change the Status");
        }
        return responseDto;
    }

    @Override
    public ResponseDto outForDelivery(Long id) {
        return null;
    }

    @Override
    public ResponseDto pickedUpForDelivery(Long id) {
        return null;
    }

    @Override
    public ResponseDto orderDelivered(Long id) {
        return null;
    }
}
