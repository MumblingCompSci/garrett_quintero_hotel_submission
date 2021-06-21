import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.util.HashMap;

public class CompanyLoader {
    public HashMap<Long, Company> companies; // id, company

    public void load(String fileName) throws ParseException {
        String path = (new File("").getAbsolutePath())
                + fileName;

        JSONParser parser = new JSONParser();
        JSONArray companyArray = (JSONArray) parser.parse(path);

        int count = 0;
        for (Object companyObject : companyArray) {
            Company company = new Company();
            company.setId((Long) ((JSONObject) companyObject).get(Company.ID));

            // check for duplicate company ID
            // skip if company already exists
            if (companies.containsKey(company.getId())) {
                System.err.println("Company with ID: " + company.getId() + " already exists, Skipping!");
                continue;
            }

            company.setCompany((String) ((JSONObject) companyObject).get(Company.NAME));
            company.setCity((String) ((JSONObject) companyObject).get(Company.CITY));
            company.setTimezone((String) ((JSONObject) companyObject).get(Company.TIMEZONE));

            // company is complete, add to map
            companies.put(company.getId(), company);
            count++;
        }
        System.out.println("Loaded " + count + " companies!");
    }
}
