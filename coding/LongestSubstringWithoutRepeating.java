package laioffer;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
    	//1. like a sliding window problem, 
        int n = s.length();
        //2. create a hashset as helper
        Set<Character> set = new HashSet<>();
        //3. ans is result, i and j are 2 pointers
        int ans = 0, i = 0, j = 0;
        //4. traversal while pointers < string lengh
        while (i < n && j < n) {
        	//4.1 if set didn't contain an element, add it to set
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                //4.2 get the max length of between ans and j-i. 
                ans = Math.max(ans, j - i);
            }
            // 4.3 if set contains duplicate element, remove previous one and add new to the set, i++???????
            else {
                set.remove(s.charAt(i++));
            }
        }
        //5. return result
        return ans;
    }
}


////最长
//
//The idea is use a hash set to track the longest substring without repeating characters 
//so far, use a fast pointer j to see if character j is in the hash set or not, 
//if not, great, add it to the hash set, move j forward and update the max length, 
//otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
//
//public int lengthOfLongestSubstring(String s) {
//    int i = 0, j = 0, max = 0;
//    Set<Character> set = new HashSet<>();
//    
//    while (j < s.length()) {
//        if (!set.contains(s.charAt(j))) {
//            set.add(s.charAt(j++));
//            max = Math.max(max, set.size());
//        } else {
//            set.remove(s.charAt(i++));
//        }
//    }
//    
//    return max;
//}
//
//
//Approach 2: Sliding Window
//Algorithm
//
//The naive approach is very straightforward. But it is too slow. So how can we optimize it?
//
//In the naive approaches, we repeatedly check a substring to see if it has duplicate character. 
//But it is unnecessary. If a substring s_{ij}s 
//ij
//​	
//  from index ii to j - 1j−1 is already checked to have no duplicate characters. 
//  We only need to check if s[j]s[j] is already in the substring s_{ij}s 
//ij
//​	
// .
//
//To check if a character is already in the substring, we can scan the substring, 
//which leads to an O(n^2)O(n 
//2
// ) algorithm. But we can do better.
//
//By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).
//
//A sliding window is an abstract concept commonly used in array/string problems. 
//A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).
//
//Back to our problem.
//We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially). 
//Then we slide the index jj to the right. If it is not in the HashSet, we slide jj further. 
//Doing so until s[j] is already in the HashSet. 
//At this point, we found the maximum size of substrings without duplicate characters start with index ii.
//If we do this for all ii, we get our answer.