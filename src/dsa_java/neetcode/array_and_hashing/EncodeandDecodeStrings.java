package dsa_java.neetcode.array_and_hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EncodeandDecodeStrings {
    public static void main(String[] args) {
        List<String> input = List.of("");
        // String output = List.of("Phuong", "Nguyen");
        System.out.println(encode(input));
        System.out.println("==============================");
        System.out.println(decode(encode(input)));
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) { //0#0#
        
        List<String> result = new ArrayList<>();
        
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            if (len != 0) {
                result.add(str.substring(j + 1, j + 1 + len));
                i = j + 1 + len;
            } else {
                result.add("");
                i += 2;
            }
        }

        return result;
    }
}
