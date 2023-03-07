package com.example.clientsservice.ui.errcontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static javax.servlet.RequestDispatcher.*;

@Controller
public class ErrController implements ErrorController {

    @RequestMapping(value = "error")
    public ModelAndView errHandle(HttpServletRequest request){
        Integer attr= (Integer) request.getAttribute(ERROR_STATUS_CODE);
   return new ModelAndView("error", new ModelMap().
           addAttribute("timespan", LocalDate.now()).
           addAttribute("error", request.getAttribute(ERROR_MESSAGE)).
           addAttribute("status", attr).
           addAttribute("path", ERROR_REQUEST_URI));
    }

}
