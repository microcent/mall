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

    public static Integer getNewLimit() {
        return getConfigInt(PREFIX + "limit.new");
    }

    public static Integer getHotLimit() {
        return getConfigInt(PREFIX + "limit.hot");
    }

    public static Integer getBrandLimit() {
        return getConfigInt(PREFIX + "limit.brand");
    }

    public static Integer getTopicLimit() {
        return getConfigInt(PREFIX + "limit.topic");
    }

    public static Integer getCatlogListLimit() {
        return getConfigInt(PREFIX + "limit.catloglist");
    }

    public static Integer getCatlogMoreLimit() {
        return getConfigInt(PREFIX + "limit.catloggood");
    }

    public static String getHotBannerTitle() {
        return getConfig(PREFIX + "banner.hot.title");
    }

    public static String getNewBannerTitle() {
        return getConfig(PREFIX + "banner.new.title");
    }

    public static String getHotImageUrl() {
        return getConfig(PREFIX + "banner.hot.imageurl");
    }

    public static String getNewImageUrl() {
        return getConfig(PREFIX + "banner.new.imageurl");
    }

    public static BigDecimal getFreight() {
        return getConfigBigDec(PREFIX + "freight.value");
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(PREFIX + "freight.limit");
    }

    public static String getMallName() {
        return getConfig(PREFIX + "mallname");
    }

    public static boolean isAutoCreateShareImage() {
        int autoCreate = getConfigInt(PREFIX + "shareimage.autocreate");
        return autoCreate == 0 ? false : true;
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}
