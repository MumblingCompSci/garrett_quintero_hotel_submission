import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TemplateLoader {
    private HashMap<String, MessageTemplate> templates; //name, template

    public MessageTemplate getTemplate(String templateName) {
        if (templates.containsKey(templateName)) return templates.get(templateName);
        else return null;
    }

    public void load(String input) throws IOException, ParseException {
        String path = (new File("").getAbsolutePath()) + "/"
                + input;
        JSONParser parser = new JSONParser();
        JSONObject templateObj = (JSONObject) parser.parse(new FileReader(path));

        MessageTemplate template = new MessageTemplate();
        template.setName((String) templateObj.get(MessageTemplate.NAME));

        ArrayList<String> gvars = new ArrayList<>();
        for (Object gvar: (JSONArray) templateObj.get(MessageTemplate.GUEST_VARIABLES)) {
            gvars.add((String) gvar);
        }
        template.setGuestVariables(gvars);

        ArrayList<String> cvars = new ArrayList<>();
        for (Object cvar: (JSONArray) templateObj.get(MessageTemplate.COMPANY_VARIABLES)) {
            cvars.add((String) cvar);
        }
        template.setCompanyVariables(cvars);

        template.setGreetingVariable((String) templateObj.get(MessageTemplate.TIME));

        template.setMessageString((String) templateObj.get(MessageTemplate.MESSAGE));

        templates.put(template.getName(), template);
        System.out.println("Loaded template: " + template.getName());
    }
}
