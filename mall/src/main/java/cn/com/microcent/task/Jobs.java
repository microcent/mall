package cn.com.microcent.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018/8/20.
 */
@Component
public class Jobs {

    @Scheduled(cron = "0/10 * * * * ? ")
    public void run() {
        System.out.println("do something");
    }

}
