package dsa_java.neetcode.array_and_hashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";

        System.out.println(isAnagram2(s, t));
    }

    //Solution 1: 
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] != arrT[i]) {
                return false;
            }
        }

        return true;
    }

    //Solution 2: 
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] s1 = new int[26];
        int[] s2 = new int[26];

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (int i = 0; i < charS.length; i++) {
            s1[charS[i] - 'a'] += 1;
            s2[charT[i] - 'a'] += 1;
        }

        return Arrays.equals(s1, s2);
    }
}
