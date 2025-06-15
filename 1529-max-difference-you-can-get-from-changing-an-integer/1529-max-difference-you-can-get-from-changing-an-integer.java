class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String max = s;
        String min = s;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '9'){
                char c = s.charAt(i);
                max = s.replace(c, '9');
                break;
            }
        }
        int maxNum = Integer.parseInt(max);

        char c = min.charAt(0);
        if(c != '1'){
            min = s.replace(c,'1');
        }else{
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) != '0' && s.charAt(i) != '1'){
                    char toReplace = s.charAt(i);
                    min = s.replace(toReplace, '0');
                    break;
                }
            }
        }
        int minNum = Integer.parseInt(min);

        return maxNum - minNum;
    }
}