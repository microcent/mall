package cn.com.microcent.domain.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_order_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_time")
    private Date orderTime;

    @Column(name = "create_time")
    private Date createTime;

}
