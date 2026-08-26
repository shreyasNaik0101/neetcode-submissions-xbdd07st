class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    public void backtrack(int[] candidates, int start, List<Integer> curr, int target, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                continue;
            }
            curr.add(candidates[i]);
            backtrack(candidates, i+1, curr, target-candidates[i], res);
            curr.remove(curr.size() - 1);
        }
    }
}
