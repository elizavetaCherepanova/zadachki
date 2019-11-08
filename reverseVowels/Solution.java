//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//
//        Input: "hello"
//        Output: "holle"
class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.isEmpty()){
            return s;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();
        while(l < arr.length){
            while(l < r && isNotVowel(arr[l])){
                l++;
            }
            while(l < r && isNotVowel(arr[r])){
                r--;
            }
            if(l < r){
                char swapChar = arr[l];
                arr[l] = arr[r];
                arr[r] = swapChar;
            }
            l++;
            r--;
        }
        return new String(arr);
    }

    private static boolean isNotVowel(char ch){
        char c = Character.toLowerCase(ch);
        return !(c == 'a' || c == 'o' || c == 'i' || c == 'u' || c == 'e');
    }
}
