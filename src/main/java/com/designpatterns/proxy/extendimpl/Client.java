package com.designpatterns.proxy.extendimpl;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(final String[] arg){
        final Producer producer = new Producer();
        /*原先的方式
        Producer producer = new Producer();
        producer.saleProduct(10000f);
         */
        /*
        动态代理：
            特点：字节码随用随创建，随用随加载
            作用：在不修改源代码的基础上对代码进行增强。
            分类：基于接口的动态代理和基于子类的动态代理
            基于接口的动态代理
                涉及的类：Enhancer
                提供方：第三方类库cglib
            如何创建代理对象：
                使用Enhancer类中的create方法
            使用要求：被代理的类不能是最终的
            Enhancer的参数
                ClassLoader:
                    用于加载代理对象字节码的，和被代理对象使用相同的类加载器。
                create:
                    用于提供增强的代码，让我们写如何代理，一般写一个该接口的实现类，通常为
                    匿名内部类，但不是必须的，谁用谁写。

         */
        Producer cglibproducer =  (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和基于接口的三个参数一样
             * @param methodProxy 当前的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //实现增强方法
                //1获取方法参数：
                Object returnvalue = null;
                float money = Float.valueOf(String.valueOf(arg[0])) ;
                //2判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    returnvalue = method.invoke(producer,money*0.8f);
                }
                return returnvalue;
            }
        });
        cglibproducer.saleProduct(10000f);

    }
}
