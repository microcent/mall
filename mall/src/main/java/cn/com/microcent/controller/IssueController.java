package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Issue;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.IssueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/issue")
@Api(value = "问题模块", description = "问题模块")
public class IssueController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    private IssueService issueService;

    @ApiOperation(value = "获取问题列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Issue> list = this.issueService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
