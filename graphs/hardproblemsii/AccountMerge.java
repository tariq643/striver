package dsa.striver.graphs.hardproblemsii;


/*

    Given a list of accounts where each element account [i] is a list of strings,
     where the first element account [i][0] is a name, and the rest of the
     elements are emails representing emails of the account.



Now, merge these accounts. Two accounts definitely belong to the same person
if there is some common email to both accounts. Note that even
if two accounts have the same name, they may belong to different
people as people could have the same name. A person can have any number of
accounts initially, but all of their accounts definitely have the same name.



After merging the accounts, return the accounts in the following format:
the first element of each account is the name, and the rest of the elements
are emails in sorted order.


Example 1

Input: N = 4,

accounts =

[["John","johnsmith@mail.com","john_newyork@mail.com"],

["John","johnsmith@mail.com","john00@mail.com"],

["Mary","mary@mail.com"],

["John","johnnybravo@mail.com"]]



Output: [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],

["Mary","mary@mail.com"],

["John","johnnybravo@mail.com"]]




 */

import java.util.*;

public class AccountMerge {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        Map<String, Integer> mailMapNode = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mailMapNode.containsKey(mail)) {
                    mailMapNode.put(mail, i);
                }
                else {
                    disjointSet.unionBySize(i, mailMapNode.get(mail));
                }
            }
        }
        // To store the merged mails
        List<List<String>> mergedMail = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        // Iterate on the Hashmap
        for (Map.Entry<String, Integer> entry : mailMapNode.entrySet()) {

            String mail = entry.getKey(); // Mail
            int node = disjointSet.findUPar(entry.getValue()); // Node

            // Add the merged mail to the list
            mergedMail.get(node).add(mail);
        }

        // To return the result
        List<List<String>> ans = new ArrayList<>();

        // Iterate on all list of merged mails
        for (int i = 0; i < n; i++) {

            /* If a person has no mails,
            skip the iteration */
            if (mergedMail.get(i).isEmpty())
                continue;

            // Otherwise, add all the merged mails of person
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }
        ans.sort(Comparator.comparing(list -> list.get(0)));
        return ans;
    }
}
