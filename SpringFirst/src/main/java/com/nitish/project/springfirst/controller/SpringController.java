/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitish.project.springfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Nitish
 */
@Controller
@RequestMapping(value = "/")
public class SpringController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/Admin")
    public String AdminAccess()
    {
        return"UserRecords";
    }
    @RequestMapping(value = "/MainPage",method = RequestMethod.POST)
    public ModelAndView RedirectToMainPage()
    {
        ModelAndView mv = new ModelAndView("MainPage");
        return mv;
    }
    @RequestMapping(value = "/VideoSite")
    public ModelAndView RedirectVideoSite()
    {
        ModelAndView mv = new ModelAndView("VideoSite");
        return mv;
    }
   
}
