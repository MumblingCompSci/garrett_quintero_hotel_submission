import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class MessageMaker {

    static GuestLoader guestLoader = new GuestLoader();
    static CompanyLoader companyLoader = new CompanyLoader();
    static TemplateLoader templateLoader = new TemplateLoader();


    public static String generate(Guest guest, Company company, MessageTemplate template) {
        return "";
    }

    public static void loadGuests(String input) {
        try {
            guestLoader.load(input);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCompanies(String input) {
        try {
            companyLoader.load(input);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTemplates(String input) {
        try {
            templateLoader.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TODO: public void generate()

    public static void main(String[] args) {
        boolean exit = false;

        String menu = """
                Please select from the following options\r
                \t load-guests\r
                \t load-companies\r
                \t load-template\r
                \t new-template\r
                \t generate-message\r
                \t exit\r
                """;

        Scanner scan = new Scanner(System.in);
        while(!exit) {
            System.out.print(menu);
            switch(scan.nextLine().toLowerCase(Locale.ROOT)) { // TODO: every once in while this will just error out instead of waiting for response
                case "load-guests" -> {
                    System.out.println("What file would you like to use?");
                    loadGuests(scan.nextLine());
                }
                case "load-companies" -> {
                    System.out.println("What file would you like to use?");
                    loadCompanies(scan.nextLine());
                }
                case "load-template" -> {
                    System.out.println("What file would you like to use?");
                    loadTemplates(scan.nextLine());
                }
                case "new-template" -> {
                    TemplateMaker.makeTemplate();
                }
                case "generate-message" -> {
                    System.out.println("What template would you like to use? Available:");
                    System.out.println(templateLoader.templates());
                    MessageTemplate template = templateLoader.getTemplate(scan.nextLine());

                    System.out.println("Which Guest would you like to use? Available:");
                    System.out.println(guestLoader.guests());
                    Guest guest = guestLoader.getGuest(Long.parseLong(scan.nextLine()));

                    System.out.println("Which Company would you like to use? Available:");
                    System.out.println(companyLoader.companies());
                    Company company = companyLoader.getCompany(Long.parseLong(scan.nextLine()));


                    String using = "Using:\r\n" +
                            "\t Guest:\t\t" + guest.getId() + "\r\n" +
                            "\t Company:\t" + company.getId() + "\r\n" +
                            "\t Template:\t" + template.getName();
                    System.out.println(using);
                    System.out.println(generate(guest, company, template));



                    //TODO: implement generate()
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
