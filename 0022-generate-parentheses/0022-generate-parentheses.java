class Solution {
    private void backTrack(int max, String current, int open, int close, List<String> result){
        if(current.length() == max * 2){
            result.add(current);
            return;
        }

        if(open < max){
            backTrack(max, current + "(", open + 1, close, result);
        }
        if(close < open){
            backTrack(max, current + ")", open, close + 1, result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n,"", 0, 0, result);
        return result;
    }
}