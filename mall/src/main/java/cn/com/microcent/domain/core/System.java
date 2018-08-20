package cn.com.microcent.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_system")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class System implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

}
