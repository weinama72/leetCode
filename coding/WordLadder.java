package laioffer;

import java.util.HashSet;
import java.util.LinkedList;

//    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//    Only one letter can be changed at a time
//    Each intermediate word must exist in the dictionary
//    For example,
//
//    Given:
//    start = “hit”
//    end = “cog”
//    dict = ["hot","dot","dog","lot","log","cog"]
//    As one shortest transformation is “hit” -> “hot” -> “dot” -> “dog” -> “cog”,
//    return its length 5.
//
//    Note:
//    Return 0 if there is no such transformation sequence.
//    All words have the same length.
//    All words contain only lowercase alphabetic characters.
//因为要找最短长度，所以相同的词最多出现一次 否则不是最短长度了


public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0) {
            return 0;
        }
        int result = 0;
        //wordQ储存 从start开始 当中的变体 然后 最后到end
        LinkedList<String> wordQueue = new LinkedList<String>();
        //
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);

        distanceQueue.add(1);

        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.poll();
            Integer currDistance = distanceQueue.poll();
            if (currWord.equals(end)) {
                return currDistance;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                //当前词每个字符 单独变位一下 从a遍历到z 如果找到有词库一样的
                //	 就把这个词库里的词放到Queue里
                //这样queue里面就有当前词变位一个字母后所有在字典里的词
                //然后每个词再去找变位一个字母有后所有在字典里的词
                //最后找到end时候返回 currDistace  找不到返回0
                for (char temp = 'a'; temp <= 'z'; temp++) {
                    currCharArr[i] = temp;
                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        //把这个currDistance+1 放在for循环里保证了
                        //改动一个字母只加以 假设start变了字母后得到3个词典里的新词
                        //那么就有3个0+1 更能真实的反应距离。
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }

        }
        return 0;

    }
//    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
//        Set<String> reached = new HashSet<String>();
//        reached.add(beginWord);
//        wordDict.add(endWord);
//        int distance = 1;
//        while (!reached.contains(endWord)) {
//            Set<String> toAdd = new HashSet<String>();
//            for (String each : reached) {
//                for (int i = 0; i < each.length(); i++) {
//                    char[] chars = each.toCharArray();
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        chars[i] = ch;
//                        String word = new String(chars);
//                        if (wordDict.contains(word)) {
//                            toAdd.add(word);
//                            wordDict.remove(word);
//                        }
//                    }
//                }
//            }
//            distance++;
//            if (toAdd.size() == 0) return 0;
//            reached = toAdd;
//        }
//        return distance;
//    }
//Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps;
//another set wordDict that has not been reached. In the while loop, for each word in the reached set, 
//I give all variations and check if it matches anything from wordDict, if it has a match, I add that word into toAdd set,
//which will be my "reached" set in the next loop, and remove the word from wordDict because I already reached it in this step.
//And at the end of while loop, I check the size of toAdd, which means that if I can't reach any new String from wordDict, 
//I won't be able to reach the endWord, then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".
//
//The idea is that reached always contain only the ones we just reached in the last step, 
//and wordDict always contain the ones that haven't been reached. This is pretty much what Dijkstra's algorithm does, 
//or you can see this as some variation of BFS.
//
//ps: I get TLE at the first two submissions, because when I check if wordDict has any matches with reached set, 
//I use two for loops and determine if any pair of words differ by one. 
//That's a huge slow-down because it'll takes m (size of reached) * n (size of wordDict) * l (length of words) time, while in this solution, 
//it takes 26 * l * m time. So when n is huge, this solution will be (n/26) times faster.

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
