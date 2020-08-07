package com.softhaxi.reflex.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ivohutasoit
 * @since 1.0.0
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String index() {
        return "common/index";
    }
}
