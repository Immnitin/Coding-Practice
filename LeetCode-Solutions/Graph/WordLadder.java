
import java.util.*;

/**
 * This class provides a solution to the word ladder problem.
 * 
 * Approach: 
 * Uses a Breadth-First Search (BFS) algorithm to find the shortest path between two words in a word list.
 * The algorithm starts with the beginning word and generates all possible words by changing one character at a time.
 * It uses a queue to keep track of the words to be processed and a set to keep track of the visited words.
 * 
 * Time Complexity: 
 * O(N * M^2) where N is the number of words in the word list and M is the length of each word.
 * This is because for each word, we generate all possible words by changing one character at a time, which takes O(M^2) time.
 * 
 * Space Complexity: 
 * O(N) where N is the number of words in the word list.
 * This is because we use a set to keep track of the visited words, which takes O(N) space.
 */
public class WordLadder {
    class Solution {
    class res{
        int lev;
        String sb;
        public res(int lev,String sb){
            this.lev=lev;
            this.sb=sb;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                HashSet<String> wdlist=new HashSet<>(wordList);
        // System.out.println(wdlist);
        
        HashSet<String> visited=new HashSet<>();
        
        Queue<res> q=new LinkedList<>();
        
        q.offer(new res(1,beginWord));
        visited.add(beginWord);
        while(!q.isEmpty()){
            res re=q.poll();
            String sb= re.sb;
            int lev=re.lev;
            // System.out.println("String to be transformed "+sb);
            if(endWord.equals(sb)){
                return lev;
            }
            for(int i=0;i<sb.length();i++){
                for(char j='a';j<='z';j++){
                  String s=sb.substring(0,i)+j+sb.substring(i+1);
                  // System.out.println(s);
              if(wdlist.contains(s) && !visited.contains(s)){
                visited.add(s);
                q.offer(new res(lev+1,s));
                // System.out.println("visited "+visited );
              }
                }
                // System.out.println();
            }
        }
        return 0;
    }
}
}

class Driver {
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList("hot","cog","dog","tot","hog")));
    }
}
