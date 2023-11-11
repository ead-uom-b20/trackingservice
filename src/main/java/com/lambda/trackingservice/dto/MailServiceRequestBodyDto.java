package com.lambda.trackingservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MailServiceRequestBodyDto {
    private String to;
    private String subject;
    private String html;
    private  String password;
}
