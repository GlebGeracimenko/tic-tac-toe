package com.gleb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by gleb on 25.02.17.
 */
@Controller
public class WebController {
    @GetMapping("/")
    String game() {
        return "game";
    }
}
