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
@Table(name = "t_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "province_id")
    private long provinceId;

    @Column(name = "city_id")
    private long cityId;

    @Column(name = "area_id")
    private long areaId;

    @Column(name = "adderss")
    private String adderss;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "is_default")
    private boolean isDefault;

    @Column(name = "create_time")
    private Date createTime;

}
