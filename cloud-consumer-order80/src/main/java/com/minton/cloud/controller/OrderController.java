package com.minton.cloud.controller;

import com.minton.cloud.entities.PayDTO;
import com.minton.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
//    public static final String url = "http://localhost:8001";
    public static final String url = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(url + "/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url + "/pay/"+id, ResultData.class, id);
    }
    @GetMapping("/consumer/get/mintonInfo")
    public ResultData getInfo(){
        return restTemplate.getForObject(url + "/minton/info", ResultData.class);
    }
}
