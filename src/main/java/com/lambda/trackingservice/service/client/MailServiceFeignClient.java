package com.lambda.trackingservice.service.client;


import com.lambda.trackingservice.dto.MailServiceRequestBodyDto;
import com.lambda.trackingservice.dto.MailServiceResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MailService", url = "https://www.mail.raguraj.me")
public interface MailServiceFeignClient {
    @PostMapping("/sendmail")
    MailServiceResponseDto sendMail(@RequestBody MailServiceRequestBodyDto mailOptions);
}
