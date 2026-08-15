package dsa_java.neetcode.two_pointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "tab a cat";
        System.out.println(isPalindrome1(s));
    }

    //Solution 1: Reverse String
    public static boolean isPalindrome1(String s) {
        //Character.isLetterOrDigit(ch)
        
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        char[] strChar = s.toLowerCase().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : strChar) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        
        return s1.equals(s2);
    }

    //Solution 2: Two Pointers
    public static boolean isPalindrome2(String s) {
        

        return true;
    }
}
