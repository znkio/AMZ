package com.io.znk.ctalin.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "contact";
    }

    @RequestMapping(value = "/nearme", method = RequestMethod.GET)
    public String nearme(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "nearme";
    }

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public String reports(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "reports";
    }

    @RequestMapping(value = "/customerprofile", method = RequestMethod.GET)
    public String customer(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "customerprofile";
    }

    @RequestMapping(value = "/companyprofile", method = RequestMethod.GET)
    public String company(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "companyprofile";
    }

    @RequestMapping(value = "/mobile/submit", method = RequestMethod.GET)
    public String submit(Locale locale, Model model) {

        return "submit";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "login";
    }
    
    @RequestMapping(value = "/dataentry", method = RequestMethod.GET)
    public String dataentry(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "dataentry";
    }
    
    @RequestMapping(value = "/createoffer", method = RequestMethod.GET)
    public String createoffer(Locale locale, Model model) {
        logger.info("Welcome to CTALIN! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("out", formattedDate);
        return "createoffer";
    }
}
