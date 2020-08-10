package top.xiaotian.springcloud.service;

import org.apache.ibatis.annotations.Param;
import top.xiaotian.springcloud.entities.Payment;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
public interface IPaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
