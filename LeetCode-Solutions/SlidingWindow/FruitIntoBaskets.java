import java.util.*;\n\n/**\n * Approach: Uses a sliding window with a HashMap to keep track of the count of each fruit type within the current window. The window expands to the right while it contains at most two distinct fruit types. When a third type appears, the left side of the window contracts until only two types remain. The maximum window size encountered is the answer.\n * Time Complexity: O(n) where n is the length of the fruits array, because each element is visited at most twice (once by the right pointer and once by the left pointer).\n * Space Complexity: O(1) because the HashMap stores at most two fruit types at any time.\n */\nclass Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int maxlen=0;
        int currlen=0;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            maxlen++;
                    while(map.size()>2){
                        map.put(fruits[left],map.get(fruits[left])-1);
                        if(map.get(fruits[left])==0){
                            map.remove(fruits[left]);
                        }
                        left++;
                        maxlen--;
                    }
                currlen=Math.max(currlen,maxlen);
            }
            
        return currlen;
        }
}\n\nclass Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[] test1 = {1, 2, 1};\n        int[] test2 = {0, 1, 2, 2};\n        int[] test3 = {1, 2, 3, 2, 2};\n        System.out.println(sol.totalFruit(test1)); // Expected: 3\n        System.out.println(sol.totalFruit(test2)); // Expected: 3\n        System.out.println(sol.totalFruit(test3)); // Expected: 5\n    }\n}