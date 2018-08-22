package cn.com.microcent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckedModel {

    private List<Long> productIds;
    private boolean isChecked;

}
