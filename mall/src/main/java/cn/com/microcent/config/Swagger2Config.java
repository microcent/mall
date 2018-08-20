package cn.com.microcent.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xingwen on 2018/8/17.
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties
public class Swagger2Config {

    @Value("${swagger.version}")
    private String version;
    @Value("${swagger.basePackage}")
    private String basePackage;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //.groupName("microcent")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /***
     * 构建 api文档的详细信息函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("商城系统数据接口文档")
                //描述
                .description("提供商城后台所有RESTFUL接口")
                .termsOfServiceUrl("http://localhost/")
                //创建人
                .contact("田兴文")
                //版本号
                .version(version)
                .license("言蹊科技")
                .licenseUrl("yancy.com")
                .build();
    }

}
