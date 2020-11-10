package com.lwh.service;

import com.lwh.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment queryById(@Param("id") long id);
}
