package top.xiaotian.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.xiaotian.springcloud.entities.Payment;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
