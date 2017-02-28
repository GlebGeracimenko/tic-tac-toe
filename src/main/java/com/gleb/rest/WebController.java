package com.gleb.rest;

import com.gleb.rest.object.RSStep;
import com.gleb.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by gleb on 25.02.17.
 */
@Controller
public class WebController {

    @Autowired
    private StepService stepService;

    @GetMapping("/")
    public String game() {
        return "game";
    }

    @GetMapping("/ticTacToe")
    public String ticTacToe(@RequestParam("gameId") @NotNull Integer id, Map<String, Object> model) {
        List<RSStep> rsSteps = stepService.getByGameId(id);
        model.put("id", id);
        model.put("steps", Arrays.toString(rsSteps.toArray(new RSStep[]{})));
        return "ticTacToe";
    }
}
