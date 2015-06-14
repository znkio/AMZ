package com.io.znk.ctalin.web.api;

import com.io.znk.ctalin.model.jpa.Customer;
import com.io.znk.ctalin.model.jpa.Rewards;
import com.io.znk.ctalin.service.RewardsService;
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
@RequestMapping(value = "/mobile/api/rewards")
public class RewardsController {

    @Autowired
    RewardsService rs;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Rewards>> getRewards() {

        return new ResponseEntity(this.rs.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Rewards> updateReward(@RequestBody Rewards rwd) {
        return new ResponseEntity(this.rs.updateRewards(rwd), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Rewards> createReward(@RequestBody Rewards rwd) {
        return new ResponseEntity(this.rs.updateRewards(rwd), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delReward(@PathVariable String id) {
        if (id == null || id.equals("")) {
            return new ResponseEntity("Cannot delete with empty id.", HttpStatus.BAD_REQUEST);
        }
        Rewards rwd = new Rewards(id);
        return new ResponseEntity(this.rs.deleteRewards(rwd), HttpStatus.OK);
    }

    @RequestMapping(value = "/{customer}", method = RequestMethod.DELETE)
    public ResponseEntity rewpercust(@PathVariable String customer) {
        Customer cust=new Customer(customer);
        return new ResponseEntity(this.rs.findByCustomer(cust),HttpStatus.OK);
    }
}
