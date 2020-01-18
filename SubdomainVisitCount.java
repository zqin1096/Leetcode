import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int space = s.indexOf(' ');
            int count = Integer.valueOf(s.substring(0, space));
            String domain = s.substring(space + 1);
            while (domain.indexOf('.') != -1) {
                if (map.containsKey(domain)) {
                    map.put(domain, map.get(domain) + count);
                } else {
                    map.put(domain, count);
                }
                domain = domain.substring(domain.indexOf('.') + 1);
            }
            if (map.containsKey(domain)) {
                map.put(domain, map.get(domain) + count);
            } else {
                map.put(domain, count);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
