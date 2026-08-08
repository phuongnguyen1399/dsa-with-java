package dsa_java.leet75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Set<String> sortedStrs = new HashSet<>();
        Map<String, List<String>> mapResults = new HashMap<>();

        for (String str : strs) {
            String temp = sortString(str);
            if(sortedStrs.add(temp)) {
                mapResults.put(temp, new ArrayList<>(List.of(str)));
            } else {
                mapResults.get(temp).add(str);
                mapResults.put(temp, mapResults.get(temp));
            }

        }

        return List.copyOf(mapResults.values());
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
