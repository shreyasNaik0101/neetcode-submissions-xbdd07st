class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; 
        backtrack(nums, res, used, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, used, curr);
            curr.remove(curr.size()-1);
            used[i] = false;
           
        }
    }
}
