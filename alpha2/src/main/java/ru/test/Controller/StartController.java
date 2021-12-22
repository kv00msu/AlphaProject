package ru.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class StartController {
    @GetMapping()
    public String Start(Map<String, Object> model) {
        return "index";
    }

    @PostMapping()
    public String Start(@RequestParam(required = false) String cur, Map<String, Object> model) {
        return "index";
    }
}
