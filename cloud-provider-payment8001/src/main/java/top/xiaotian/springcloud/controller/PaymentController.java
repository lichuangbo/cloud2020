package top.xiaotian.springcloud.controller;

import org.springframework.web.bind.annotation.*;
import top.xiaotian.springcloud.entities.CommonResult;
import top.xiaotian.springcloud.entities.Payment;
import top.xiaotian.springcloud.service.IPaymentService;

import javax.annotation.Resource;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@RestController
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        if (res > 0) {
            return new CommonResult(200, "插入数据库成功", res);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID为" + id, null);
        }
    }
}
