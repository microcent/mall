package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Address;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.AddressService;
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
@RequestMapping("/address")
@Api(value = "收货地址模块", description = "收货地址模块")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "获取收货地址列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Address> list = this.addressService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
