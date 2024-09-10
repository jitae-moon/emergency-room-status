package org.example.emergencyroomstatus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainFormController {

    @GetMapping("/notice")
    public String notice(Model model) {
        log.info("MainFormController :: notice");

        return "notice";
    }

}
