import java.util.*;
public class Main {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        Main obj = new Main();
        String s = "  Hello   World  ";
        System.out.println("Reversed words: '" + obj.reverseWords(s) + "'"); // Output: "World Hello"
    }
}
