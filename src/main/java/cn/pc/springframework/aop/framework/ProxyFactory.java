package cn.pc.springframework.aop.framework;

import cn.pc.springframework.aop.AdvisedSupport;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/27 上午10:34
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createApoProxy().getProxy();
    }

    private AopProxy createApoProxy() {
        if (advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}