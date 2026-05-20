import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class provides a solution to the Course Schedule II problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class CourseScheduleII {
    /**
     * Finds the order in which courses can be taken based on their prerequisites.
     * 
     * Approach: Uses a Topological Sorting algorithm with a Queue to track nodes with no incoming edges.
     * Time Complexity: O(N + M), where N is the number of courses and M is the number of prerequisites.
     * Space Complexity: O(N + M), where N is the number of courses and M is the number of prerequisites.
     * 
     * @param numCourses The number of courses.
     * @param prerequisites The prerequisites for each course.
     * @return The order in which courses can be taken.
     */
    class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q=new ArrayDeque<>();
        int[] indeg=new int[numCourses];

         for(int i=0;i<prerequisites.length;i++){
            indeg[prerequisites[i][0]]++;
        }

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int k=0;
        int[] res=new int[numCourses];
        while(!q.isEmpty()){
            int node=q.poll();
            res[k++]=node;
            for(Integer i: adjlist.get(node)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.offer(i);
                }
            }
        }
        if(k<numCourses){
            return new int[0];
        }
        return res;
     

    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] prerequisites1 = {{1, 0}};
            int[] result1 = solution.findOrder(2, prerequisites1);
            System.out.println(java.util.Arrays.toString(result1));

            int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
            int[] result2 = solution.findOrder(4, prerequisites2);
            System.out.println(java.util.Arrays.toString(result2));

            int[][] prerequisites3 = {{1, 0}, {2, 0}, {0, 2}};
            int[] result3 = solution.findOrder(3, prerequisites3);
            System.out.println(java.util.Arrays.toString(result3));
        }
    }
}