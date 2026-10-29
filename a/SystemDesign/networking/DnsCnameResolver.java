package dsa.striver.a.SystemDesign.networking;

import java.util.HashMap;
import java.util.Map;

class DnsCnameResolver {

    public DnsCnameResolver() {}

    public String resolve(String query, String[] aliasFrom, String[] aliasTo) {

        Map<String, String> domainNameResolve = new HashMap<String, String>();
        for (int i = 0; i < aliasFrom.length; i++) {
            domainNameResolve.put(aliasFrom[i], aliasTo[i]);
        }
        while (domainNameResolve.get(query) != null) {
            query = domainNameResolve.get(query);
        }
        return query;
    }
}
