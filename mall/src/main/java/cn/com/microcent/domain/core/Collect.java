package cn.com.microcent.domain.core;

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
@Table(name = "t_collect")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "type")
    private int type;

    @Column(name = "value_id")
    private long valueId;

    @Column(name = "create_time")
    private Date createTime;

}
