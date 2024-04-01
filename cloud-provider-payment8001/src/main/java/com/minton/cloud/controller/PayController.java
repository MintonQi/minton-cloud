package com.minton.cloud.controller;

import com.minton.cloud.entities.Pay;
import com.minton.cloud.entities.PayDTO;
import com.minton.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay")
    public String addPay(@RequestBody Pay pay){
        return "insert Pay success, return: " + payService.add(pay);
    }

    @DeleteMapping("/pay/delete/{id}")
    public String deletePay(@PathVariable("id") Integer id){
        return "delete Pay success, return: " + payService.delete(id);
    }

    @PutMapping("/pay/{id}")
    public String updatePay(@PathVariable("id") Integer id, @RequestBody PayDTO payDTO){
        payDTO.setId(id);
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        return "update Pay success, return: " + payService.update(pay);
    }

    @GetMapping("/pay/{id}")
    public Pay getPay(@PathVariable("id") Integer id){
        return payService.getById(id);
    }

    @GetMapping("/pay")
    @Operation(summary = "获取所有Pay记录")
    public Iterable<Pay> getAllPay(){
        return payService.getAll();
    }

}
