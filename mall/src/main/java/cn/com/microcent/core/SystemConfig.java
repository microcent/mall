package cn.com.microcent.core;

/**
 * Created by xingwen on 2018/8/21.
 */

import java.math.BigDecimal;

/**
 * 系统设置,其他配置请参考该类的实现
 */
public class SystemConfig extends BaseConfig {
    public static final String PREFIX = "mall.system.";


    public static Integer getIndexAdLimit() {
        return getConfigInt(PREFIX + "index.limit.ad");
    }

    public static Integer getIndexChannelLimit(){
        return getConfigInt(PREFIX + "index.limit.channel");
    }

    public static Integer getIndexNewLimit() {
        return getConfigInt(PREFIX + "index.limit.new");
    }

    public static Integer getIndexHotLimit() {
        return getConfigInt(PREFIX + "index.limit.hot");
    }

    public static Integer getIndexBrandLimit() {
        return getConfigInt(PREFIX + "index.limit.brand");
    }

    public static Integer getIndexTopicLimit() {
        return getConfigInt(PREFIX + "index.limit.topic");
    }

    public static Integer getIndexCatalogLimit() {
        return getConfigInt(PREFIX + "index.limit.catalog");
    }

    public static Integer getIndexCatalogMoreLimit() {
        return getConfigInt(PREFIX + "index.limit.catalog.more");
    }

    public static String getMallName() {
        return getConfig(PREFIX + "mallname");
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}
