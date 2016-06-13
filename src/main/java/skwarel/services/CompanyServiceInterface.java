package skwarel.services;

import org.springframework.stereotype.Service;
import skwarel.models.companies.Company;

import  java.util.List;

/**
 * Created by mickael on 09/06/16.
 */

public interface CompanyServiceInterface {
    void addCompany(Company c);
    List<Company> getListCompanies();

}
