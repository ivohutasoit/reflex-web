package com.softhaxi.reflex.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ivoivohutasoit
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index() {
        return "common/index";
    }
}
