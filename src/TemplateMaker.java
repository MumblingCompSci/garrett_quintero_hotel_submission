import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TemplateMaker {

    //TODO: I want to make it so that you don't have to have a time variable if you dont want to
        // but I haven't quite figured out optional/blank variables and JSON

    public void makeTemplate() {
        JSONObject template = new JSONObject();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                What would you like to name this template?\r
                Please select a unique name, as this will also be used for the new file name""");
        String name = scanner.nextLine();
        template.put(MessageTemplate.NAME, name);

        System.out.println(
                """
                What Guest variables would you like to use? Available:\r
                \t firstName\r
                \t lastName\r
                \t roomNumber\r
                \t startTimestamp\r
                \t endTimestamp\r
                Please enter your choices separated by a comma...
                        """
        );

        // TODO: add checking for variable correctness
        String input = scanner.nextLine();
        JSONArray guestVariables = new JSONArray();
        input = input.replaceAll(" ", ""); // remove unnecessary spaces
        guestVariables.addAll(Arrays.asList(input.split(",")));
        template.put(MessageTemplate.GUEST_VARIABLES, guestVariables);

        System.out.println("""
                What Company variables would you like to use? Available:\r
                \t company\r
                \t city\r
                \t timezone\r
                Please enter your choices separated by a comma...
                """);

        input = scanner.nextLine();
        input = input.replaceAll(" ", "");
        JSONArray companyVariables = new JSONArray();
        companyVariables.addAll(Arrays.asList(input.split(",")));
        template.put(MessageTemplate.COMPANY_VARIABLES, companyVariables);

        System.out.println("""
                What variable would you like to represent your time based greeting?
                """);
        input = scanner.nextLine();
        template.put(MessageTemplate.TIME, input);

        System.out.println("""
                What would you like the message to be?\r
                Please start each variable with "$"\r
                \t ex: $firstName
                """);

        input = scanner.nextLine();
        template.put(MessageTemplate.MESSAGE, input);

        try {
            FileWriter file = new FileWriter(name + ".json");
            file.write(template.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }
}
