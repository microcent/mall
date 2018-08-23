package cn.com.microcent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/8/22.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatus {

    NEW(1, "待付款"),
    PAID(2, "已支付"),
    DELIVERING(3, "待收货"),
    FINISHED(4, "订单完成");

    private int value;
    private String desc;

    public static OrderStatus valueOf(int value) {
        switch (value) {
            case 1:
                return OrderStatus.NEW;
            case 2:
                return OrderStatus.PAID;
            case 3:
                return OrderStatus.DELIVERING;
            case 4:
                return OrderStatus.FINISHED;
            default:
                return OrderStatus.NEW;
        }
    }

}
