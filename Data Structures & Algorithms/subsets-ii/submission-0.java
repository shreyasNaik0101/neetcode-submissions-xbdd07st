class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int start){
        res.add(new ArrayList<>(curr));
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, res, curr, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
