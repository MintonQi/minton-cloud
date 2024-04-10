package com.minton.cloud.controller;

import com.minton.cloud.apis.PayFeignApi;
import com.minton.cloud.entities.PayDTO;
import com.minton.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/feign/pay/{id}")
    public ResultData getPay(@PathVariable("id") Long id) {
        return payFeignApi.getPay(id);
    }

    @GetMapping("/feign/minton/info")
    public ResultData getInfo() {
        return payFeignApi.getInfo();
    }
}
