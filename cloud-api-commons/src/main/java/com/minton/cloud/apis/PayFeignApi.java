package com.minton.cloud.apis;

import com.minton.cloud.entities.PayDTO;
import com.minton.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SuppressWarnings("rawtypes")
@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    /**
     * 添加支付信息
     * @param payDTO 支付信息对象，包含支付详情
     * @return 返回操作结果，包括成功与否、错误码等
     */
    @PostMapping("/pay")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 根据支付ID获取支付详情
     * @param id 支付的唯一标识符
     * @return 返回操作结果，包括支付详情
     */
    @GetMapping("/pay/{id}")
    public ResultData getPay(@PathVariable("id") Long id);

    /**
     * 获取某个用户的Minton信息
     * @return 返回操作结果，包括用户的信息
     */
    @GetMapping("/minton/info")
    public ResultData getInfo();
}
