import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder email = new StringBuilder(emails[i]);
            int period = email.indexOf(".");
            int at = email.indexOf("@");
            while (period != -1 && period < at) {
                email.deleteCharAt(period);
                period = email.indexOf(".");
                at = email.indexOf("@");
            }
            int plus = email.indexOf("+");
            if (plus != -1 && plus < at) {
                email.delete(plus, at);
            }
            uniqueEmails.add(email.toString());
        }
        return uniqueEmails.size();
    }
}
