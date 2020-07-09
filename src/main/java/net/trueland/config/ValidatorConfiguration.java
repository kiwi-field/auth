package net.trueland.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Description: hibernate validator 配置
 * @Author: dengxiaoyu
 * @Date 2020/4/16 9:42
 * @Version: 1.0
 */
@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // true 快速失败模式(一个属性校验失败，将不再校验其他属性)  false 普通模式(会校验完所有的属性)
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        //设置validator模式为快速失败返回
        postProcessor.setValidator(validator());
        return postProcessor;
    }
}
