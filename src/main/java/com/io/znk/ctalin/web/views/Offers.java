package com.io.znk.ctalin.web.views;

import com.io.znk.ctalin.service.ReceiptService;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mobile/offers")
public class Offers {

    private static final Logger logger = LoggerFactory.getLogger(Offers.class);

    @Autowired
    ReceiptService receiptService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "offers/customer";
    }

   

}
