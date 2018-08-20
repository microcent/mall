package cn.com.microcent.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "status")
    private int status;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_type")
    private int paymentType;

    @Column(name = "payment_time")
    private Date paymentTime;

    @Column(name = "send_time")
    private Date sendTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "close_time")
    private Date closeTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
