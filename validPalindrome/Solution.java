//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.isEmpty()){
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();
        while(l < arr.length){
            while(l < r && isNotAlphanumeric(arr[l])){
                l++;
            }
            while(l < r && isNotAlphanumeric(arr[r])){
                r--;
            }
            if(l < r){
                if(Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])){
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isNotAlphanumeric(char c){
        return !(Character.isAlphabetic(c) || Character.isDigit(c));
    }
}
