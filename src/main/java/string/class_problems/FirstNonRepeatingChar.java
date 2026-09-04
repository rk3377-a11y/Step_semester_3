public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};

        for (String text : inputs) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}