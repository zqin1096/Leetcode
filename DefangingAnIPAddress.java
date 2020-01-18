/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".
 */
public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                sb.deleteCharAt(i);
                sb.insert(i, "[.]");
                // Skip the '[' character.
                i++;
            }
        }
        return sb.toString();
    }
}
