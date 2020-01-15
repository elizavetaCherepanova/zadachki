//Given a List of words, return the words that can be typed using letters of alphabet
//
//        Example:
//
//        Input: ["Hello", "Alaska", "Dad", "Peace"]
//        Output: ["Alaska", "Dad"]
//        https://leetcode.com/problems/keyboard-row/
class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> dict = new HashMap<>();
        String[] dictArr = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for(int i = 0; i < dictArr.length; i++){
            for(char c: dictArr[i].toCharArray()){
                dict.put(c, i);
            }
        }
        List<String> res = new ArrayList<>();
        for(String word: words){
            char[] wordC = word.toLowerCase().toCharArray();
            int index = dict.get(wordC[0]);
            if(isOneRow(dict, wordC, index)){
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean isOneRow(Map<Character, Integer> dict, char[] wordC, int index){
        for(char c :wordC){
            if(dict.get(c) != index){
                return false;
            }
        }
        return true;
    }
}