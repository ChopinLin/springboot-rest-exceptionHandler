package person.lxp.springboot.restexceptionhandler.exception;

import org.springframework.http.HttpStatus;
import person.lxp.springboot.restexceptionhandler.annotation.RestErrorInfo;

/**
 * Created by linxiaopeng on 2018-10-11.
 */
@RestErrorInfo(status = HttpStatus.METHOD_NOT_ALLOWED,
        code = 40501,
        message = "权限不足")
public class RestExceptionA extends RuntimeException{

    public RestExceptionA(String message){
        super(message);
    }
}
