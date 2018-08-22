package cn.com.microcent.core;

/**
 * Created by xingwen on 2018/8/21.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import cn.com.microcent.service.SystemService;

/**
 * 该类用于自动初始化数据库配置到BaseConfig中，以便BaseConfig的子类调用
 */
@Component
public class ConfigService {
    private static ConfigService configService;

    static ConfigService getConfigService() {
        return configService;
    }

    @Autowired
    private SystemService systemService;

    //不允许实例化
    private ConfigService() {

    }

    @PostConstruct
    public void init() {
        configService = this;
        configService.initConfigs();
    }

    /**
     * 根据 prefix 重置该 prefix 下所有设置
     *
     * @param prefix
     */
    public void reloadConfig(String prefix) {
        List<cn.com.microcent.domain.core.System> list = this.systemService.findAll();
        for (cn.com.microcent.domain.core.System item : list) {
            //符合条件，添加
            if (item.getKey().startsWith(prefix))
                BaseConfig.addConfig(item.getKey(), item.getValue());
        }
    }

    /**
     * 读取全部配置
     */
    private void initConfigs() {
        List<cn.com.microcent.domain.core.System> list = this.systemService.findAll();
        for (cn.com.microcent.domain.core.System item : list) {
            BaseConfig.addConfig(item.getKey(), item.getValue());
        }
    }
}
