package com.io.znk.ctalin.web.api;
import com.io.znk.ctalin.model.jpa.Company;
import com.io.znk.ctalin.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/mobile/api/companies")
public class CompanyController {

    @Autowired
    CompanyService cs;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getCompanies() {

        return new ResponseEntity(this.cs.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Company> updateCompany(@RequestBody Company comp) {
        return new ResponseEntity(this.cs.updateCompany(comp), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Company> createCompany(@RequestBody Company comp) {
        return new ResponseEntity(this.cs.updateCompany(comp), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delCompany(@PathVariable String id) {
        if (id == null || id.equals("")) {
            return new ResponseEntity("Cannot delete with empty id.", HttpStatus.BAD_REQUEST);
        }
        Company comp = new Company(id);
        return new ResponseEntity(this.cs.deleteCompany(comp), HttpStatus.OK);
    }

    
    @RequestMapping(value = "/nearme", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getNearCompanies(@RequestParam("lot") String lot,
                                                            @RequestParam("lat") String lat,
                                                                @RequestParam("radius") String radius) {

        return new ResponseEntity(this.cs.findProximal(lot,lat,radius), HttpStatus.OK);
    }
    
    
    
}
