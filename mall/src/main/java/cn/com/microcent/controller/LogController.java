package cn.com.microcent.controller;

import cn.com.microcent.entity.Response;
import cn.com.microcent.domain.log.Log;
import cn.com.microcent.repository.log.LogRepository;
import cn.com.microcent.service.LogService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/log")
@Api(value = "日志模块", description = "日志模块")
public class LogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @ApiOperation(value = "获取日志列表", notes = "")
    @ApiResponses({
            @ApiResponse(code = 500, message = "接口异常"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Log> list = this.logService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
