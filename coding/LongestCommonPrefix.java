package laioffer;

//Write a function to find the longest common prefix string amongst an array of strings.
//找一个string数组里面最长的公共前缀。
public class LongestCommonPrefix {
    // 1. Method 1, start from the first one, compare prefix with next string, until end;
    // 把第一个String 当作前缀 然后每次都和后面的string比 然后找出共同prefix作为新的prefix
    //然后更新的prefix,再和下一个比
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // create a string，保存结果
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) { //遍历字符串数组，遍历了3个字符串，一次
            int j = 0;
            //i = 1,2,3
//            Input: ["flower","flow","flight"]
//            		Output: "fl"
            //prefix : flower, strs[1]:flow, j分别小于他们的长度，当在第j位相等，j++，直到不等
            //当当前的for循环第i个string的j位 和prfix的第j位一样的时候 j++  看看prefix能坚持match到底几位
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            //说明while第一次判断失败，否则会加加，说明第一个字符就不同
            if (j == 0) {
                return "";
            }
            //
            prefix = prefix.substring(0, j);
        }
        return prefix;

    }

}

//
//public String longestCommonPrefix(String[] strs) {
//    if(strs == null || strs.length == 0)    return "";
//    String pre = strs[0];
//    int i = 1;
//    while(i < strs.length){
//        while(strs[i].indexOf(pre) != 0)
//            pre = pre.substring(0,pre.length()-1);
//        i++;
//    }
//    return pre;
//}

