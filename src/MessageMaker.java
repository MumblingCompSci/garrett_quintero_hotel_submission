import org.apache.commons.lang.StringEscapeUtils;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class MessageMaker {

    static GuestLoader guestLoader = new GuestLoader();
    static CompanyLoader companyLoader = new CompanyLoader();

    public static void loadGuests(String input) {
        try {
            guestLoader.load(input);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: public void loadCompanies()
    public static void loadCompanies(String input) {
        try {
            companyLoader.load(input);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // TODO: public void loadTemplates()
    // TODO: public void newTemplate()
    // TODO: public void generate()

    public static void main(String[] args) {
        boolean exit = false;

        String menu = """
                Please select from the following options\r
                \t load-guests\r
                \t load-companies\r
                \t load-templates\r
                \t new-template\r
                \t generate-message\r
                \t exit\r
                """;

        Scanner scan = new Scanner(System.in);
        while(!exit) {
            System.out.print(menu);
            switch(scan.nextLine().toLowerCase(Locale.ROOT)) {
                case "load-guests" -> {
                    System.out.println("What file would you like to use?");
                    loadGuests(scan.nextLine());
                }
                case "load-companies" -> {
                    System.out.println("What file would you like to use?");
                    loadCompanies(scan.nextLine());
                }
                case "load-templates" -> {

                }
                case "new-template" -> {

                }
                case "generate-message" -> {

                }
                case "exit" -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Oops! That wasn't an option...");
                }
            }
        }
        scan.close();

    }
}
