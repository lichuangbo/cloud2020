package top.xiaotian.springcloud.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiaotian.springcloud.dao.PaymentDao;
import top.xiaotian.springcloud.entities.Payment;
import top.xiaotian.springcloud.service.IPaymentService;

import javax.annotation.Resource;

/**
 * @author lichuangbo
 * @version 1.0
 * @created 2020/8/10
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
