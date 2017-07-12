package com.azarov.projects.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 *
 * @Author: Dmitry Azarov
 * @Created: 2017-07-04
 */

@Controller
public class WebContcroller {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        return "Hello Home Page!";
    }
}
