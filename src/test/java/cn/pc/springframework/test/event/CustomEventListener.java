package cn.pc.springframework.test.event;

import cn.pc.springframework.context.ApplicationListener;
import cn.pc.springframework.context.event.ApplicationContextEvent;

import java.util.Date;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/20 下午3:09
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
