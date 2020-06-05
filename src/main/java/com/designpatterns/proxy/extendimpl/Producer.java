package com.designpatterns.proxy.extendimpl;

import com.designpatterns.proxy.interfaceimpl.IProducer;

public class Producer {
    /**
     *销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("拿到钱并销售商品"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务,并拿到钱"+money);
    }
}
