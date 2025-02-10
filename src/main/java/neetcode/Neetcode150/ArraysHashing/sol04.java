package neetcode.Neetcode150.ArraysHashing;

import java.util.*;

public class sol04 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();

        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!strMap.containsKey(key)) {
                List<String> newLst = new ArrayList<>();
                newLst.add(str);
                strMap.put(key, newLst);
            }
            else {
                List<String> values = strMap.get(key);
                values.add(str);
                strMap.put(key, values);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> values : strMap.values()) {
            result.add(values);
        }
        return result;

    }

    public static void main(String[] args) {
        String[] str = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        groupAnagrams(str);


    }
}
