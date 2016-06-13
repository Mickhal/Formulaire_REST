package skwarel.services;

import org.springframework.stereotype.Service;
import skwarel.models.companies.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mickael on 09/06/16.
 */
@Service("companyService")

public class CompanyServiceImpl implements CompanyServiceInterface {
    private List bdCompanies=  new ArrayList<>();

    @Override
    public void addCompany(Company c) {
        bdCompanies.add(c);
    }
    @Override
    public List<Company> getListCompanies() {
        return bdCompanies;
    }

}
