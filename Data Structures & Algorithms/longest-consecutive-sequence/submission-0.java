class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int count = 1;

                while(set.contains(num+1)){
                    num = num + 1;
                    count++;
                }
                res = Math.max(res, count);
            }
            
            
        }
        return res;
    }
}
