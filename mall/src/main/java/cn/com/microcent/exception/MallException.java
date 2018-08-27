package cn.com.microcent.exception;

import cn.com.microcent.entity.ResponseCode;
import lombok.Getter;

/**
 * Created by xingwen on 2018/8/26.
 */
@Getter
public class MallException extends RuntimeException {

    private ResponseCode responseCode;

    public MallException(ResponseCode responseCode) {
        super(responseCode.getDesc());
        this.responseCode = responseCode;
    }

}
