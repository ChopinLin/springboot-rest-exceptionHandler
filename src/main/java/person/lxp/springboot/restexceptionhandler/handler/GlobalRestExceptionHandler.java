package person.lxp.springboot.restexceptionhandler.handler;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import person.lxp.springboot.restexceptionhandler.RestError;
import person.lxp.springboot.restexceptionhandler.annotation.RestErrorInfo;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * Created by linxiaopeng on 2018-10-11.
 */
@ControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestError handlerException(HttpServletResponse response,Exception ex){
        RestError restError = buildRestErrorFromError(ex);
        response.setStatus(restError.getStatus().value());
        return restError;
    }

    private RestError buildRestErrorFromError(Exception ex){
        RestErrorInfo restErrorInfo = AnnotationUtils.findAnnotation(ex.getClass(),RestErrorInfo.class);
        RestError.Builder builder = new RestError.Builder();

        if(restErrorInfo == null) return builder.setMessage(ex.getMessage()).build();

        builder.setCode(restErrorInfo.code());
        builder.setStatus(restErrorInfo.status());
        builder.setMessage(restErrorInfo.message());
        builder.setMoreInfo(restErrorInfo.moreInfo());
        builder.setDeveloperMessage(ex.getMessage());

        return builder.build();
    }
}
