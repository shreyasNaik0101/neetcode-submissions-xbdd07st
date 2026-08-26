class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), target, res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> curr, int target, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(nums[i] > target){
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, i, curr, target-nums[i], res);
            curr.remove(curr.size() - 1);
        }
    }
}
