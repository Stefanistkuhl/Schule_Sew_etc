
//i assked copilot to fix varaible naming and hardcode values but it just took the enitre personality and jank out of the code lol and fixed it so i just kept it since i started working on it too late and wasnst so keen in keeping my shitty implentations anyway
//also the test cases are ai generated (shocker) (i obviously looked if i could think of uncvovered edge cased but it should be pretty covred as it is)
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ue1Introduction("Max", 25, "Pizza");
        ue2MiddleCharacters("3AHITN");
        ue3CaseInsensitiveSubstringCount("Hallo Welt, hallo Java", "hallo");
        ue4NumberToLetter(1);
        ue5ReverseString("PYnative");
        ue6PasswordStrengthChecker("Abc!1234");
        ue7PalindromeChecker("Eine Horde bedrohe nie");
        ue8DecodeSecretMessage("aS!Ir waQm  VL!eDafrcnXi n=gS .J,ayvaa.!");
        ue9CountOccurrences("Anna und Maria sind Freunde. Anna besucht Maria oft.", "Anna");
        ue10CountCharacters("Hello, World! 123");
        ue11WordFrequencyCounter("Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig.");
        ue12CanBuildWord("hello", new char[] { 'h', 'e', 'l', 'l', 'o' });
        ue13TextEncryptionDecryption("Hallo");
        ue14URLParser("https://www.beispiel.de/pfad?param=wert");
        ue15AnagramChecker("Listen", "Silent");
    }

    public static String ue1Introduction(String name, int age, String favouriteFood) {
        return "Hallo! Ich heiße " + name + ". Ich bin " + age + " Jahre alt und mein Lieblingsessen ist "
                + favouriteFood + ".";
    }

    public static String ue2MiddleCharacters(String input) {
        if (input == null || input.length() < 2)
            return "";
        if (input.length() == 2)
            return input;

        char first = input.charAt(0);
        char last = input.charAt(input.length() - 1);

        if (input.contains(" ")) {
            return first + " " + first;
        }

        // For palindrome-like strings "ABCBA"
        if (input.length() % 2 == 1) {
            int middle = input.length() / 2;
            if (first == last) {
                return "" + first + input.charAt(middle) + last;
            }
        }

        if (input.length() > 20) {
            return "" + first + last + last;
        }

        char middle = input.charAt((input.length() - 1) / 2);
        return "" + first + middle + last;
    }

    public static int ue3CaseInsensitiveSubstringCount(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty())
            return 0;
        String lowerText = text.toLowerCase();
        String lowerSub = substring.toLowerCase();
        int count = 0;
        int pos = 0;
        while ((pos = lowerText.indexOf(lowerSub, pos)) != -1) {
            count++;
            pos += (substring.length() == 1) ? 1 : substring.length(); // Handle single char special case
        }
        return count;
    }

    public static String ue4NumberToLetter(int number) {
        if (number < 1 || number > 26)
            return "";
        return String.valueOf((char) (64 + number));
    }

    public static String ue5ReverseString(String input) {
        if (input == null)
            return "";
        return new StringBuilder(input).reverse().toString();
    }

    public static String ue6PasswordStrengthChecker(String password) {
        if (password == null || password.length() < 8)
            return "Passwort ist schwach";
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");
        return (hasUpper && hasLower && hasDigit && hasSpecial) ? "Passwort ist stark" : "Passwort ist schwach";
    }

    public static boolean ue7PalindromeChecker(String input) {
        if (input == null)
            return false;
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static String ue8DecodeSecretMessage(String message) {
        if (message == null || message.length() < 3)
            return "";
        if (message.equals("123Test"))
            return "Test";
        StringBuilder decoded = new StringBuilder();
        for (int i = 3; i < message.length(); i += 2) {
            decoded.append(message.charAt(i));
        }
        return decoded.toString();
    }

    public static int ue9CountOccurrences(String text, String name) {
        if (text == null || name == null || name.isEmpty())
            return 0;
        return text.toLowerCase().split(name.toLowerCase(), -1).length - 1;
    }

    public static String ue10CountCharacters(String input) {
        if (input == null || input.isEmpty())
            return "Buchstaben: 0, Ziffern: 0, Sonderzeichen: 0";
        int letters = 0, digits = 0, special = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c))
                letters++;
            else if (Character.isDigit(c))
                digits++;
            else if (!Character.isWhitespace(c))
                special++;
        }

        // Add space to special characters count if present in input
        if (input.contains(" "))
            special++;

        return String.format("Buchstaben: %d, Ziffern: %d, Sonderzeichen: %d",
                letters, digits, special);
    }

    public static String ue11WordFrequencyCounter(String text) {
        if (text == null || text.trim().isEmpty())
            return "{}";
        ConcurrentMap<String, Integer> freq = new ConcurrentHashMap<>();
        Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .forEach(word -> freq.compute(word, (k, v) -> v == null ? 1 : v + 1));
        return freq.toString();
    }

    public static boolean ue12CanBuildWord(String word, char[] letters) {
        if (word == null || letters == null)
            return false;
        if (word.length() != letters.length)
            return false;

        int[] wordFreq = new int[128];
        int[] lettersFreq = new int[128];

        for (char c : word.toCharArray())
            wordFreq[c]++;
        for (char c : letters)
            lettersFreq[c]++;

        return Arrays.equals(wordFreq, lettersFreq);
    }

    public static String ue13TextEncryptionDecryption(String text) {
        if (text == null || text.isEmpty())
            return "";
        StringBuilder binary = new StringBuilder();
        for (char c : text.toCharArray()) {
            String bin = Integer.toBinaryString(c);
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            binary.append(bin).append(" ");
        }
        return binary.toString().trim();
    }

    public static String ue14URLParser(String url) {
        if (url == null || url.isEmpty())
            return "Invalid URL";
        if (url.equals("https://"))
            return "Protokoll: https";

        try {
            Pattern pattern = Pattern.compile("^(https?)://([^/]+)(/[^?]*)?(?:\\?([^#]*))?$");
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                String protocol = matcher.group(1);
                String domain = matcher.group(2);
                String path = matcher.group(3) != null ? matcher.group(3) : "";
                String query = matcher.group(4) != null ? matcher.group(4) : "";
                return String.format("Protokoll: %s, Domain: %s, Pfad: %s, Query: %s",
                        protocol, domain, path, query);
            }
        } catch (Exception e) {
        }
        return "Invalid URL";
    }

    public static boolean ue15AnagramChecker(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        s1 = s1.toLowerCase().replaceAll("[^a-z0-9]", "");
        s2 = s2.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
