package person.lxp.springboot.restexceptionhandler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.lxp.springboot.restexceptionhandler.exception.RestExceptionA;

/**
 * Created by linxiaopeng on 2018-10-11.
 */
@RestController
@RequestMapping("/rest")
public class RestExceptionController {

    @GetMapping("/{msg}")
    String echoA(@PathVariable("msg") String msg){
        if(msg.length()<3) throw new RestExceptionA("input more charter");
        return msg;
    }
}
