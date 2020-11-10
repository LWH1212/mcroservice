package com.lwh.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall paymentInfo_OK 服务器出现故障，o(π_π)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall paymentInfo_TimeOut 服务器出现故障，o(π_π)O";
    }
}
