import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class determines whether it is possible to finish all courses based on their prerequisites.
 * 
 * @author [Your Name]
 */
public class CourseSchedule {
    /**
     * Checks if it is possible to finish all courses.
     * 
     * Approach: Uses a Topological Sorting algorithm with a Queue to track nodes with no incoming edges.
     * Time Complexity: O(N + M), where N is the number of courses and M is the number of prerequisites.
     * Space Complexity: O(N + M), where N is the number of courses and M is the number of prerequisites.
     * 
     * @param numCourses the number of courses
     * @param prerequisites the prerequisites for each course
     * @return true if it is possible to finish all courses, false otherwise
     */
    class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjlist.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> q=new ArrayDeque<>();
        int[] indeg=new int[numCourses];

         for(int i=0;i<prerequisites.length;i++){
            indeg[prerequisites[i][1]]++;
        }

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(Integer i: adjlist.get(node)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.offer(i);
                }
            }
        }

        if(res.size()<numCourses){
            return false;
        }

        return true;

    }

}
}

class Driver {
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(solution.canFinish(2, prerequisites1)); // true
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(2, prerequisites2)); // false
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(solution.canFinish(4, prerequisites3)); // true
    }
}