package com.io.znk.ctalin.web.api;

import com.io.znk.ctalin.model.jpa.Achievement;
import com.io.znk.ctalin.service.AchievementService;
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
@RequestMapping(value = "/mobile/api/achievements")
public class AchievementController {

    @Autowired
    AchievementService as;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Achievement>> getachs() {

        return new ResponseEntity(this.as.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Achievement> updateach(@RequestBody Achievement ach) {
        return new ResponseEntity(this.as.updateAchievement(ach), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Achievement> createach(@RequestBody Achievement ach) {
        return new ResponseEntity(this.as.updateAchievement(ach), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delach(@PathVariable String id) {
        if(id==null||id.equals("")){
            return new ResponseEntity("Cannot delete with empty id.",HttpStatus.BAD_REQUEST);
        }
        Achievement ach=new Achievement(id);
        return new ResponseEntity(this.as.updateAchievement(ach), HttpStatus.OK);
    }
    
}
