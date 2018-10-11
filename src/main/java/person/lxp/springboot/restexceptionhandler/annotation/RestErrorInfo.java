package person.lxp.springboot.restexceptionhandler.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;

import java.lang.annotation.*;

/**
 * Created by linxiaopeng on 2018-10-11.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RestErrorInfo {

    @AliasFor("status")
    HttpStatus value() default HttpStatus.INTERNAL_SERVER_ERROR;

    @AliasFor("value")
    HttpStatus status() default HttpStatus.INTERNAL_SERVER_ERROR;

    int code() default 50000;

    String message() default "default internal server error";

    String moreInfo() default "no more detail";
}
