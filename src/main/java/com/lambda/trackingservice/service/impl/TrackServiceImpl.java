package com.lambda.trackingservice.service.impl;

import com.lambda.trackingservice.domain.TrackDomain;
import com.lambda.trackingservice.dto.MailServiceRequestBodyDto;
import com.lambda.trackingservice.dto.MailServiceResponseDto;
import com.lambda.trackingservice.dto.ResponseDto;
import com.lambda.trackingservice.repository.TrackRepository;
import com.lambda.trackingservice.service.TrackService;
import com.lambda.trackingservice.service.client.MailServiceFeignClient;
import com.lambda.trackingservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class TrackServiceImpl implements TrackService {
    private final ServiceUtil serviceUtil;
    private final TrackRepository trackRepository;
    private final MailServiceFeignClient mailServiceFeignClient;
    @Override
    public ResponseDto tracking(String TrackStatus,Long orderid) {
        ResponseDto responseDto;
        List<String> trackings = new ArrayList<>();
        trackings.add("Order Placed");
        trackings.add("Order Processing");
        trackings.add("Out for Delivery");
        trackings.add("Picked Up for Delivery");
        trackings.add("Order Delivered");
        try{

            if(!trackings.contains(TrackStatus)){
                return responseDto = serviceUtil.getErrorServiceResponse("No valid transaction !");
            }

            TrackDomain savedTrackingInfo =trackRepository.save(
                    TrackDomain.builder()
                            .orderID(orderid)
                            .status(TrackStatus)
                            .build()
            );

            // mail started
            MailServiceRequestBodyDto body = MailServiceRequestBodyDto.builder()
                    .subject(TrackStatus +" Successfully")
                    .to("ragurajsivanantham@gmail.com")
                    .html("<h1>Hi,"+TrackStatus+" Successfully")
                    .password("$windowsLaptop$")
                    .build();
            MailServiceResponseDto mailServiceResponseDto = mailServiceFeignClient.sendMail(body);
            if(Objects.equals(mailServiceResponseDto.getStatus(), "true")){
                log.info("AppLog >>> mail service success");
            }else{
                log.info("AppLog >>> mail service failed");
            }

            responseDto = serviceUtil.getServiceResponse(savedTrackingInfo);
        }catch (Exception e){
            responseDto = serviceUtil.getErrorServiceResponse("Errror Saving...");
        }
        return responseDto;
    }

}
