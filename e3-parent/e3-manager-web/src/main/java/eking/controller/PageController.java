package eking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wd.pang on 2018/1/22.
 */
@Controller
public class PageController {
    @RequestMapping("/")
public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page){
       return page;
    }
}
