import java.util.ArrayList;

public class MessageTemplate {

    private String messageString;
    private ArrayList<String> guestVariables;
    private ArrayList<String> companyVariables;
    private String name;
    private String greetingVariable;

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public ArrayList<String> getGuestVariables() {
        return guestVariables;
    }

    public void setGuestVariables(ArrayList<String> guestVariables) {
        this.guestVariables = guestVariables;
    }

    public ArrayList<String> getCompanyVariables() {
        return companyVariables;
    }

    public void setCompanyVariables(ArrayList<String> companyVariables) {
        this.companyVariables = companyVariables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreetingVariable() {
        return greetingVariable;
    }

    public void setGreetingVariable(String greetingVariable) {
        this.greetingVariable = greetingVariable;
    }
}
