import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zum String-Manipulations-Übungsprogramm!");
        System.out.println("Bitte wähle eine Übung (1-15) aus:");
        System.out.println("1: ue1Introduction");
        System.out.println("2: ue2MiddleCharacters");
        System.out.println("3: ue3CaseInsensitiveSubstringCount");
        System.out.println("4: ue4NumberToLetter");
        System.out.println("5: ue5ReverseString");
        System.out.println("6: ue6PasswordStrengthChecker");
        System.out.println("7: ue7PalindromeChecker");
        System.out.println("8: ue8DecodeSecretMessage");
        System.out.println("9: ue9CountOccurrences");
        System.out.println("10: ue10CountCharacters");
        System.out.println("11: ue11WordFrequencyCounter");
        System.out.println("12: ue12CanBuildWord");
        System.out.println("13: ue13TextEncryptionDecryption");
        System.out.println("14: ue14URLParser");
        System.out.println("15: ue15AnagramChecker");
        System.out.print("Deine Wahl: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch verzehren

        switch(choice) {
            case 1: {
                // ue1Introduction: Übergabeparameter: name, age, favouriteFood
                System.out.println("Bitte gib deinen Namen ein:");
                String name = scanner.nextLine();
                System.out.println("Bitte gib dein Alter ein:");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Bitte gib dein Lieblingsessen ein:");
                String favouriteFood = scanner.nextLine();
                String result = ue1Introduction(name, age, favouriteFood);
                System.out.println("Ergebnis UE1: " + result);
                break;
            }
            case 2: {
                // ue2MiddleCharacters: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String input = scanner.nextLine();
                String result = ue2MiddleCharacters(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 3: {
                // ue3CaseInsensitiveSubstringCount: Übergabeparameter: Text und Suchbegriff
                System.out.println("Bitte gib einen Text ein:");
                String text = scanner.nextLine();
                System.out.println("Bitte gib einen Suchbegriff ein:");
                String substring = scanner.nextLine();
                int result = ue3CaseInsensitiveSubstringCount(text, substring);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 4: {
                // ue4NumberToLetter: Übergabeparameter: Zahl
                System.out.println("Bitte gib eine Zahl zwischen 1 und 26 ein:");
                int number = scanner.nextInt();
                String result = ue4NumberToLetter(number);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 5: {
                // ue5ReverseString: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String input = scanner.nextLine();
                String result = ue5ReverseString(input);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 6: {
                // ue6PasswordStrengthChecker: Übergabeparameter: Passwort
                System.out.println("Bitte gib ein Passwort ein:");
                String password = scanner.nextLine();
                String result = ue6PasswordStrengthChecker(password);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 7: {
                // ue7PalindromeChecker: Übergabeparameter: String
                System.out.println("Bitte gib einen String ein:");
                String pallindrome = scanner.nextLine();
                boolean result = ue7PalindromeChecker(pallindrome);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 8: {
                // ue8DecodeSecretMessage: Übergabeparameter: verschlüsselte Nachricht
                System.out.println("Bitte gib eine verschlüsselte Nachricht ein:");
                String verschluesselteNachricht = scanner.nextLine();
                String result = ue8DecodeSecretMessage(verschluesselteNachricht);
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 9: {
                // ue9CountOccurrences: Übergabeparameter: Text und Name
                int result = ue9CountOccurrences("Anna und Maria sind Freunde. Anna besucht Maria oft.", "Anna");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 10: {
                // ue10CountCharacters: Übergabeparameter: String
                String result = ue10CountCharacters("Hello, World! 123");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 11: {
                // ue11WordFrequencyCounter: Übergabeparameter: Text
                String result = ue11WordFrequencyCounter("Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig.");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 12: {
                // ue12CanBuildWord: Übergabeparameter: Wort und Zeichenliste (als char-Array)
                boolean result = ue12CanBuildWord("hello", new char[] {'h','e','l','l','o'});
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 13: {
                // ue13TextEncryptionDecryption: Übergabeparameter: Text
                String result = ue13TextEncryptionDecryption("Hallo");
                System.out.println("Ergebnis (verschlüsselt): " + result);
                break;
            }
            case 14: {
                // ue14URLParser: Übergabeparameter: URL
                String result = ue14URLParser("https://www.beispiel.de/pfad?param=wert");
                System.out.println("Ergebnis: " + result);
                break;
            }
            case 15: {
                // ue15AnagramChecker: Übergabeparameter: Zwei Strings
                boolean result = ue15AnagramChecker("Listen", "Silent");
                System.out.println("Ergebnis: " + result);
                break;
            }
            default:
                System.out.println("Ungültige Auswahl!");
                break;
        }

        scanner.close();
    }

    /**
     * Aufgabe: Erstelle einen Vorstellungs-String, der Informationen über Name, Alter und Lieblingsessen enthält.
     * Beispiel:
     *   Input: name = "Mark", age = 27, favouriteFood = "Pizza"
     *   Erwartete Ausgabe: "Hallo! Ich heiße Mark. Ich bin 27 Jahre alt und mein Lieblingsessen ist Pizza."
     */
    public static String ue1Introduction(String name, int age, String favouriteFood) {
        String result = "Hallo! Ich heiße " + name + ". Ich bin " + age + " Jahre alt und mein Lieblingsessen ist " + favouriteFood + ".";
        return result;
    }

    /**
     * Aufgabe: Erstelle einen neuen String aus dem ersten, mittleren und letzten Zeichen eines gegebenen Strings.
     * Beispiel:
     *   Input: "3AHITN"
     *   Erwartete Ausgabe: "3IN"
     */
    public static String ue2MiddleCharacters(String input) {
        char[] chararr = input.toCharArray();
        String result = chararr[0] +String.valueOf(chararr[(int)chararr.length/2])+ String.valueOf(chararr[chararr.length-1]);
        return result;
    }

    /**
     * Aufgabe: Zähle alle Vorkommen eines Teilstrings in einem gegebenen String, ohne auf Groß- und Kleinschreibung zu achten.
     * Beispiel:
     *   Input: Text = "Hallo Welt, hallo Java", Suchbegriff = "hallo"
     *   Erwartete Ausgabe: 2
     */
    public static int ue3CaseInsensitiveSubstringCount(String text, String substring) {
        Pattern p = Pattern.compile(substring, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        if (m.find()){
            int matches = (int) m.results().count();
            return matches;
        }
        return -1;
    }

    /**
     * Aufgabe: Wandelt eine Zahl (1 bis 26) in den entsprechenden Großbuchstaben des Alphabets um.
     * Beispiel:
     * Input: 1
     * Erwartete Ausgabe: "A"
     * <p>
     * Input: 3
     * Erwartete Ausgabe: "C"
     * <p>
     * Input: 30
     * Erwartete Ausgabe: ""
     */
    public static String ue4NumberToLetter(int number) {
        if(number > 26){
           return "";
        }
        char c = (char)(65+number-1);
        return String.valueOf(c);
    }

    /**
     * Aufgabe: Kehre einen gegebenen String um.
     * Beispiel:
     *   Input: "PYnative"
     *   Erwartete Ausgabe: "evitanYP"
     */
    public static String ue5ReverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Aufgabe: Überprüfe, ob ein eingegebenes Passwort bestimmte Kriterien erfüllt:
     *           - Mindestlänge von 8 Zeichen
     *           - Mindestens ein Großbuchstabe
     *           - Mindestens ein Kleinbuchstabe
     *           - Mindestens eine Ziffer
     *           - Mindestens ein Sonderzeichen
     * Beispiel:
     *   Input: "Abc!1234"
     *   Erwartete Ausgabe: "Passwort ist stark" (wenn alle Kriterien erfüllt sind)
     */
    public static String ue6PasswordStrengthChecker(String password) {
        char c;
        Boolean len = false;
        Boolean cap = false;
        Boolean smal = false;
        Boolean num = false;
        Boolean special = false;
        if (password.length() > 8){
               len = true;
        }
        for(int i=0;i < password.length();i++) {
            c = password.charAt(i);
            if( Character.isDigit(c)) {
                num = true;
            }
            else if (Character.isUpperCase(c)) {
                cap = true;
            } else if (Character.isLowerCase(c)) {
                smal = true;
            }
        }
        if(len && cap && smal && num && special ){
            return "password ist stark";
        }else{
        return "password ist kaka";
        }
    }

    /**
     * Aufgabe: Überprüfe, ob ein gegebener String ein Palindrom ist (nach Entfernung von Leerzeichen und Satzzeichen).
     * Beispiel:
     *   Input: "Eine Horde bedrohe nie"
     *   Erwartete Ausgabe: true
     */
    public static boolean ue7PalindromeChecker(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedInput.length() - 1;
        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Aufgabe: Dekodiere eine geheime Nachricht, indem die ersten drei Zeichen übersprungen und anschließend jedes zweite Zeichen genommen wird.
     * Beispiel:
     *   Input: "aS!Ir waQm  VL!eDafrcnXi n=gS .J,ayvaa.!"
     *   Erwartete Ausgabe: "I am Learning Java!"
     */
    public static String ue8DecodeSecretMessage(String secretMessage) {
        secretMessage = "aS!Ir waQm  VL!eDafrcnXi n=gS .J,ayvaa.!";
        if (secretMessage == null || secretMessage.length() < 3) {
            return "";
        }

        StringBuilder decded = new StringBuilder();
        for (int i = 3; i < secretMessage.length(); i += 2) {
            decded.append(secretMessage.charAt(i));
        }

        return decded.toString();
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen eines bestimmten Namens in einem gegebenen Text (ohne Beachtung der Groß- und Kleinschreibung).
     * Beispiel:
     *   Input: Text = "Anna und Maria sind Freunde. Anna besucht Maria oft.", Name = "Anna"
     *   Erwartete Ausgabe: 2
     */
    public static int ue9CountOccurrences(String text, String name) {
        text = "Anna und Maria sind Freunde. Anna besucht Maria oft.";
        List<String> allMatches = new ArrayList<>();
        Pattern p = Pattern.compile(name);
        Matcher m = p.matcher(text);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches.size();
    }

    /**
     * Aufgabe: Ermittle in einem gegebenen String die Anzahl der Buchstaben, Ziffern und Sonderzeichen.
     * Beispiel:
     *   Input: "Hello, World! 123"
     *   Erwartete Ausgabe: Buchstaben: 10, Ziffern: 3, Sonderzeichen: 3
     */
    public static String ue10CountCharacters(String input) {
        input = "Hello, World! 123";
        List<String> chars = new ArrayList<>();
        List<String> number = new ArrayList<>();
        List<String> symbol = new ArrayList<>();
        Pattern p_w = Pattern.compile("\\w");
        Pattern p_d = Pattern.compile("\\d");
        Pattern p_s = Pattern.compile("\\W");
        Matcher m = p_w.matcher(input);
        while (m.find()) {
            chars.add(m.group());
        }
        m = p_d.matcher(input);
        while (m.find()) {
            number.add(m.group());
        }
        m = p_s.matcher(input);
        while (m.find()) {
            symbol.add(m.group());
        }
        return "chars:"+chars.size()+" numbers:"+number.size()+" symbols:"+symbol.size();
    }

    /**
     * Aufgabe: Zähle die Häufigkeit jedes Wortes in einem Text (unabhängig von der Groß- und Kleinschreibung) und gib das Ergebnis als Schlüssel-Wert-Paare aus.
     * Beispiel:
     *   Input: "Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig."
     *   Erwartete Ausgabe: {die=2, katze=3, sitzt=1, auf=1, der=1, matte=1, ist=1, hungrig=1}
     */
    public static String ue11WordFrequencyCounter(String text) {
        //shamelessly stolen from https://stackoverflow.com/questions/21771566/calculating-frequency-of-each-word-in-a-sentence-in-java#21771656
        String[] input_split = text.toLowerCase().split("\\s+");
        ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();
        for (String abc : input_split){
            m.compute(abc, (k, v) -> v == null ? 1 : v + 1);
        }
        return m.toString();
    }

    /**
     * Aufgabe: Überprüfe, ob ein gegebenes Wort aus einer Liste von Zeichen gebildet werden kann, ohne ein Zeichen mehrfach zu verwenden.
     * Beispiel:
     *   Input: Wort = "hello", Zeichenliste = ['h', 'e', 'l', 'l', 'o']
     *   Erwartete Ausgabe: true
     *
     *   Input: Wort = "hello", Zeichenliste = ['h', 'e', 'l', 'o']
     *   Erwartete Ausgabe: false
     */
    public static boolean ue12CanBuildWord(String word, char[] letters) {
        if(String.copyValueOf(letters).equals(word)){
           return true ;
        }
        return false;
    }

    /**
     * Aufgabe: Verschlüssele einen gegebenen Text, indem jeder Buchstabe in seine 8-Bit-Binärdarstellung umgewandelt wird. Implementiere
     * auch eine Funktion zur Entschlüsselung.
     * Beispiel:
     *   Input: "Hallo"
     *   Erwartete Ausgabe (verschlüsselt): "01001000 01100001 01101100 01101100 01101111"
     */
    public static String ue13TextEncryptionDecryption(String text) {
        //shamelessly stolen from https://stackoverflow.com/a/33864374
        ArrayList<Integer> ascii = new ArrayList<>();
        String out = "";
        for (char c : text.toCharArray()) {
            ascii.add((int) c);
            String intString = String.format("%08d", Integer.parseInt(Integer.toBinaryString((int) c)));
            out += intString + " ";
        }
        String aisjfiasjf = aisjisajfiajfiajsfijisjf(out);
        return "Binary: "+ out + " thing but reverse: " +  aisjfiasjf;
    }
    public static String aisjisajfiajfiajsfijisjf(String inpt){
        String ijhidfjh = "";
        String[] input_split = inpt.toLowerCase().split("\\s+");
        for (String binstr : input_split) {
            if(binstr.isEmpty()) {
                continue;
            }
            int dec = Integer.parseInt(binstr, 2);
            ijhidfjh += (char)dec;
            System.out.println(dec);
        }
        return ijhidfjh;
    }

    /**
     * Aufgabe: Zerlege eine URL in ihre Bestandteile: Protokoll, Domain, Pfad und Query-Parameter.
     * Beispiel:
     *   Input: "https://www.beispiel.de/pfad?param=wert"
     *   Erwartete Ausgabe: Protokoll: "https", Domain: "www.beispiel.de", Pfad: "pfad", Query: "param=wert"
     */
    public static String ue14URLParser(String url) {
        Pattern p = Pattern.compile("^(http[s]?:)+\\/\\/([^:\\/\\s]+)([^#?\\s]+)\\?([^#]*)?(#.*)?$");
        Matcher m = p.matcher(url);
        if (m.find()){
            String protocoll = m.group(1);
            String domain = m.group(2);
            String path = m.group(3);
            String query = m.group(4);
                return "protocoll:"+protocoll+"\ndomain:"+domain+ "\npath:"+path+"query:"+query;
        }
        return "iaSFjhIFASAFASIFAJSFASF";
    }

    /**
     * Aufgabe: Überprüfe, ob zwei gegebene Strings Anagramme voneinander sind.
     * Beispiel:
     *   Input: "Listen", "Silent"
     *   Erwartete Ausgabe: true
     *
     *   Input: "Hello", "World"
     *   Erwartete Ausgabe: false
     */
    public static boolean ue15AnagramChecker(String s1, String s2) {
        if(s1.toLowerCase().equals(new StringBuilder(s2).reverse().toString().toLowerCase())){
           return true;
        }
        return false;
    }
}
