public class Subsequence {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";

        System.out.println(isSubsequence(s1, s2));
    }

    private static boolean isSubsequence(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
            }

            index2++;
        }

        return index1 == str1.length();
    }
}
