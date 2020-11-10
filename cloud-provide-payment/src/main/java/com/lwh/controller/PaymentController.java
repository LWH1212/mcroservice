package com.lwh.controller;

import com.lwh.pojo.CommonResult;
import com.lwh.pojo.Payment;
import com.lwh.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment dept){
        int i = paymentService.create(dept);
        log.info("***************插入成功*****************"+i);
        if (i>0){
            return new CommonResult(200,"插入数据库成功",i);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*************"+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功8001",payment);
        }else {
            return new CommonResult(444,"查询失败8001",null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        return "8001";
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return port;
    }

}
