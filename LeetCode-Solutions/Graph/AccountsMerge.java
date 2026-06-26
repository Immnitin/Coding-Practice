
import java.util.*;

/**
 * This class provides a solution to the accounts merge problem.
 * 
 * Approach: 
 * Uses a Union-Find algorithm to group accounts with common email addresses.
 * The algorithm iterates over each account, and for each email in the account, 
 * it checks if the email is already in the map. If it is, it unions the current 
 * account with the account that the email belongs to. If not, it adds the email 
 * to the map with the current account as its value.
 * 
 * Time Complexity: 
 * O(N * M * logM) where N is the number of accounts and M is the maximum number 
 * of emails in an account. The reason is that for each account, we iterate over 
 * its emails, and for each email, we perform a union operation which takes 
 * logM time in the worst case.
 * 
 * Space Complexity: 
 * O(N * M) where N is the number of accounts and M is the maximum number of 
 * emails in an account. The reason is that we store all emails in the map and 
 * the result.
 */
public class Solution {
    class Solution {
        ArrayList<Integer> parent=new ArrayList<>();
        public int fp(int u){
            if(parent.get(u)!=u){
                parent.set(u,fp(parent.get(u)));
            }
            return parent.get(u);
        }

        public void union(int u, int v){
            int ulu=fp(u);
            int ulv=fp(v);

            if(ulu!=ulv){
                parent.set(ulu,ulv);
            }
        }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         for(int i=0;i<accounts.size();i++){
                parent.add(i);
            }
     HashMap<String,Integer> map=new HashMap<>();
     
     for(int i=0;i<accounts.size();i++){
        for(int j=1;j<accounts.get(i).size();j++){
            if(map.containsKey(accounts.get(i).get(j))){
                union(map.get(accounts.get(i).get(j)),i);
            }
            else
            map.put(accounts.get(i).get(j),i);
        }
     }

     HashMap<Integer,TreeSet<String>> res=new HashMap<>();

     for(int i=0;i<parent.size();i++){
        res.put(i,new TreeSet<>());
     }

     for(int i=0;i<parent.size();i++){
      int root = fp(i);
for(int j = 1; j < accounts.get(i).size(); j++){
    res.get(root).add(accounts.get(i).get(j));
}
     }

    List<List<String>> ans = new ArrayList<>();

    for(Map.Entry<Integer,TreeSet<String>> entry : res.entrySet()){
        if(!entry.getValue().isEmpty()){
            ArrayList<String> r=new ArrayList<>();
        r.add(accounts.get(entry.getKey()).get(0));
        for(String mail: entry.getValue()){
            r.add(mail);
        }
        ans.add(r);
        }
    }
     

return ans;

    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        List<List<String>> accounts1 = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );
        System.out.println(solution.accountsMerge(accounts1));
        
        // Test case 2
        List<List<String>> accounts2 = Arrays.asList(
            Arrays.asList("Gabe", "gabe0@fb.com", "gabe1@fb.com", "gabe2@fb.com"),
            Arrays.asList("Gabe", "gabe3@fb.com", "gabe4@fb.com", "gabe5@fb.com")
        );
        System.out.println(solution.accountsMerge(accounts2));
        
        // Test case 3
        List<List<String>> accounts3 = Arrays.asList(
            Arrays.asList("David", "david0@m.co", "david1@m.co"),
            Arrays.asList("David", "david3@m.co", "david4@m.co"),
            Arrays.asList("David", "david4@m.co", "david5@m.co"),
            Arrays.asList("David", "david2@m.co", "david3@m.co"),
            Arrays.asList("David", "david1@m.co", "david2@m.co")
        );
        System.out.println(solution.accountsMerge(accounts3));
    }
}
