//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
//        You can use each character in text at most once. Return the maximum number of instances that can be formed.
//        https://leetcode.com/problems/maximum-number-of-balloons/
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[5];
        for(char c :text.toCharArray()){
            if(c == 'b') chars[0]++;
            if(c == 'a') chars[1]++;
            if(c == 'l') chars[2]++;
            if(c == 'o') chars[3]++;
            if(c == 'n') chars[4]++;
        }
        int possibleOc = chars[0];
        while(possibleOc > 0){
            if(chars[1]>=possibleOc &&
                    chars[2] >= possibleOc*2 &&
                    chars[3] >= possibleOc*2 &&
                    chars[4] >= possibleOc){
                return possibleOc;
            } else {
                possibleOc--;
            }

        }
        return 0;
    }
}