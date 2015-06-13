package com.io.znk.ctalin.web.api;

import com.io.znk.ctalin.model.jpa.Achievement;
import com.io.znk.ctalin.model.jpa.Achievementcustomer;
import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Receipt;
import com.io.znk.ctalin.service.AchievementService;
import com.io.znk.ctalin.service.AchievementcustomerService;
import com.io.znk.ctalin.service.ReceiptService;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "/mobile/api/receipts")
public class ReceiptsController {

    @Autowired
    ReceiptService rs;

    //customer side
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<List<Receipt>> getachs(@PathVariable String customerId) {
        return new ResponseEntity(this.rs.findByCustomer(new Customer(customerId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<Receipt> putachs(@PathVariable String customerId, @RequestBody Receipt receipt) {
        Customer acust = new Customer(customerId);
        receipt.setCustomerID(acust);
        if (this.rs.findReceipt(receipt) != null) {
            return new ResponseEntity("you have already registered this receipt", HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity(this.rs.createReceipt(receipt), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.POST)
    public ResponseEntity<Receipt> postachs(@PathVariable String customerId, @RequestBody Receipt receipt) {
        if(customerId==null || customerId==""){
            return new ResponseEntity("you cannot register without a valid customerId", HttpStatus.ALREADY_REPORTED);
        }
        Customer acust = new Customer(customerId);
        receipt.setCustomerID(acust);
        return new ResponseEntity(this.rs.updateReceipt(receipt), HttpStatus.OK);
    }
}
