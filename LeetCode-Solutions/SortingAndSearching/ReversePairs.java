import java.util.Arrays;
/**
 * Approach: Uses a modified Merge Sort algorithm to count the number of reverse pairs in the given array.
 * The algorithm works by recursively dividing the array into two halves until each half has one element, then merging and counting the reverse pairs.
 * Time Complexity: O(n log n) due to the merge sort.
 * Space Complexity: O(n) for the temporary array used in the merge step.
 */
class Solution {
    int cnt=0;
    public int reversePairs(int[] nums) {
        divide(nums,0,nums.length-1);
        return cnt; 
    }

    public int count (int[] nums, int st, int mid, int ed){
        int cont=0;
        int j=mid+1;
        for(int i=st;i<=mid;i++){
            while(j<=ed && nums[i]>2L*nums[j]){
                j++;
            }
            cont+=j-(mid+1);
        }
        return cont;
    }

    public void divide(int[] nums, int st, int ed){
        if(st>=ed){return;}
        int mid = (st+ed)/2;
        divide(nums,st,mid);
        divide(nums,mid+1,ed);
        cnt+=count(nums,st,mid,ed);
        merge(nums,st,mid,ed);

    }

    public void merge(int[] nums,int st, int mid, int ed){
        int[] temp=new int[ed-st+1];
        int i=st;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ed){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }
            else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=ed){
            temp[k++]=nums[j++];
        }

        for(int n=0; n<temp.length;n++){
            nums[st+n]=temp[n];
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 3, 2, 3, 1},
            {2, 4, 3, 5, 1},
            {5, 4, 3, 2, 1}
        };
        for (int[] testCase : testCases) {
            System.out.println("Reverse Pairs: " + solution.reversePairs(testCase));
        }
    }
}