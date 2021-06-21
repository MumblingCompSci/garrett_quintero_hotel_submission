import java.util.Locale;
import java.util.Scanner;

public class MessageTemplateMaker {

    GuestLoader guestLoader;
    CompanyLoader cLoader;

    // TODO: public void loadGuests()
    // TODO: public void loadCompanies()
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

        while(!exit) {
            Scanner scan = new Scanner(System.in);
            System.out.print(menu);
            switch(scan.nextLine().toLowerCase(Locale.ROOT)) {
                case "load-guests" :
                case "load-companies" :
                case "load-templates" :
                case "new-template" :
                case "generate-message" :
                case "exit" :
                    exit = true;
                    break;
                default :
                    System.out.println("Oops! That wasn't an option...");
                    break;
            }
        }

    }
}
