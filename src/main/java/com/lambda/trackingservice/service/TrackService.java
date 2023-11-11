package com.lambda.trackingservice.service;

import com.lambda.trackingservice.dto.ResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface TrackService {
    ResponseDto tracking(String orderString, Long orderid);
}
