//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        Note:
//
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//        https://leetcode.com/problems/word-ladder/
import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty()) {
            return 0;
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Deque<Pair<String, Integer>> wordToGo = new ArrayDeque<Pair<String, Integer>>();
        wordToGo.offer(new Pair(beginWord, 1));
        while(!wordToGo.isEmpty()){
            Pair<String, Integer> pair = wordToGo.poll();
            String sWord = pair.getKey();
            if(sWord.equalsIgnoreCase(endWord)){
                return pair.getValue();
            }
            for(String str:wordList){
                if(!visited.contains(str)){
                    if(isDifferOneLetter(str, sWord)){
                        wordToGo.offer(new Pair(str, pair.getValue() + 1));
                        visited.add(str);
                    }
                }
            }

        }
        return 0;
    }

    private boolean isDifferOneLetter(String w1, String w2){
        boolean isDiffer = false;
        char[] w1Arr = w1.toCharArray();
        char[] w2Arr = w2.toCharArray();
        for(int i = 0;i<w1Arr.length; i++){
            if(w1Arr[i] != w2Arr[i]){
                if(isDiffer){
                    return false;
                } else {
                    isDiffer = true;
                }
            }
        }
        return true;
    }
}