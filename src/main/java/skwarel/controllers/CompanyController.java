package skwarel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skwarel.models.companies.Company;
import skwarel.models.users.User;
import skwarel.services.CompanyServiceImpl;
import skwarel.services.UserServiceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by mickael on 07/06/16.
 */
@RestController
@RequestMapping("/companyCtrl")
public class CompanyController {
    @Autowired
    CompanyServiceImpl companyService;

    @RequestMapping(value="/addCompany", method=RequestMethod.POST)
    public ResponseEntity<String> addCompany(@RequestBody LinkedHashMap<String, String> cmpy) {

        Company company = new Company(cmpy.get("nom"),cmpy.get("numero"),cmpy.get("nb"),cmpy.get("email"),cmpy.get("loc"));
        companyService.addCompany(company);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/getListCompanies", method=RequestMethod.GET)
    public ResponseEntity<List<Company>> getListCompanies() {
        List<Company> resultat = companyService.getListCompanies();
        return new ResponseEntity<List<Company>>(resultat, HttpStatus.OK);
    }
}
