import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    
    @Test
    public void testUe1Introduction() {
        assertEquals("Hallo! Ich heiße Max. Ich bin 25 Jahre alt und mein Lieblingsessen ist Pizza.", 
                    Main.ue1Introduction("Max", 25, "Pizza"));
        assertEquals("Hallo! Ich heiße Anna. Ich bin 30 Jahre alt und mein Lieblingsessen ist Sushi.", 
                    Main.ue1Introduction("Anna", 30, "Sushi"));
    }

    @Test
    public void testUe2MiddleCharacters() {
        assertEquals("3HN", Main.ue2MiddleCharacters("3AHITN"));
        assertEquals("HLO", Main.ue2MiddleCharacters("HELLO"));
        assertEquals("TET", Main.ue2MiddleCharacters("TEST"));
    }

    @Test
    public void testUe3CaseInsensitiveSubstringCount() {
        assertEquals(2, Main.ue3CaseInsensitiveSubstringCount("Hallo Welt, hallo Java", "hallo"));
        assertEquals(3, Main.ue3CaseInsensitiveSubstringCount("Die DIE die", "die"));
        assertEquals(0, Main.ue3CaseInsensitiveSubstringCount("Test Text", "xyz"));
    }

    @Test
    public void testUe4NumberToLetter() {
        assertEquals("A", Main.ue4NumberToLetter(1));
        assertEquals("Z", Main.ue4NumberToLetter(26));
        assertEquals("", Main.ue4NumberToLetter(27));
        assertEquals("", Main.ue4NumberToLetter(0));
    }

    @Test
    public void testUe5ReverseString() {
        assertEquals("evitanYP", Main.ue5ReverseString("PYnative"));
        assertEquals("tseT", Main.ue5ReverseString("Test"));
        assertEquals("", Main.ue5ReverseString(""));
    }

    @Test
    public void testUe6PasswordStrengthChecker() {
        assertEquals("Passwort ist stark", Main.ue6PasswordStrengthChecker("Abc!1234"));
        assertEquals("Passwort ist schwach", Main.ue6PasswordStrengthChecker("password"));
        assertEquals("Passwort ist schwach", Main.ue6PasswordStrengthChecker("12345"));
    }

    @Test
    public void testUe7PalindromeChecker() {
        assertTrue(Main.ue7PalindromeChecker("Eine Horde bedrohe nie"));
        assertTrue(Main.ue7PalindromeChecker("Anna"));
        assertFalse(Main.ue7PalindromeChecker("Test"));
    }

    @Test
    public void testUe8DecodeSecretMessage() {
        assertEquals("I am Learning Java!", 
                    Main.ue8DecodeSecretMessage("aS!Ir waQm  VL!eDafrcnXi n=gS .J,ayvaa.!"));
    }

    @Test
    public void testUe9CountOccurrences() {
        assertEquals(2, Main.ue9CountOccurrences(
            "Anna und Maria sind Freunde. Anna besucht Maria oft.", "Anna"));
        assertEquals(0, Main.ue9CountOccurrences(
            "Test Text", "xyz"));
    }

    @Test
    public void testUe10CountCharacters() {
        assertEquals("Buchstaben: 10, Ziffern: 3, Sonderzeichen: 3", 
                    Main.ue10CountCharacters("Hello, World! 123"));
        assertEquals("Buchstaben: 4, Ziffern: 0, Sonderzeichen: 0", 
                    Main.ue10CountCharacters("Test"));
    }

    @Test
    public void testUe11WordFrequencyCounter() {
        String result = Main.ue11WordFrequencyCounter("Die Katze Katze sitzt auf der Matte. Die Katze ist hungrig.");
        assertTrue(result.contains("die=2"));
        assertTrue(result.contains("katze=3"));
        assertTrue(result.contains("sitzt=1"));
    }

    @Test
    public void testUe12CanBuildWord() {
        assertTrue(Main.ue12CanBuildWord("hello", new char[]{'h','e','l','l','o'}));
        assertFalse(Main.ue12CanBuildWord("hello", new char[]{'h','e','l','o'}));
        assertFalse(Main.ue12CanBuildWord("test", new char[]{'t','e','x','t'}));
    }

    @Test
    public void testUe13TextEncryptionDecryption() {
        assertEquals("01001000 01100001 01101100 01101100 01101111", 
                    Main.ue13TextEncryptionDecryption("Hallo"));
        assertEquals("01010100 01100101 01110011 01110100", 
                    Main.ue13TextEncryptionDecryption("Test"));
    }

    @Test
    public void testUe14URLParser() {
        assertEquals(
            "Protokoll: https, Domain: www.beispiel.de, Pfad: /pfad, Query: param=wert",
            Main.ue14URLParser("https://www.beispiel.de/pfad?param=wert")
        );
        assertEquals(
            "Protokoll: http, Domain: localhost, Pfad: /test, Query: id=123",
            Main.ue14URLParser("http://localhost/test?id=123")
        );
    }

    @Test
    public void testUe15AnagramChecker() {
        assertTrue(Main.ue15AnagramChecker("Listen", "Silent"));
        assertTrue(Main.ue15AnagramChecker("debit card", "bad credit"));
        assertFalse(Main.ue15AnagramChecker("hello", "world"));
    }

    // Additional Introduction tests
    @Test
    public void testUe1IntroductionEdgeCases() {
        assertEquals("Hallo! Ich heiße . Ich bin 0 Jahre alt und mein Lieblingsessen ist .", 
                    Main.ue1Introduction("", 0, ""));
        assertEquals("Hallo! Ich heiße John Doe. Ich bin 999 Jahre alt und mein Lieblingsessen ist Very Long Food Name.", 
                    Main.ue1Introduction("John Doe", 999, "Very Long Food Name"));
    }

    @Test
    public void testUe1IntroductionSpecialCharacters() {
        assertEquals("Hallo! Ich heiße @#$%. Ich bin 1 Jahre alt und mein Lieblingsessen ist &*().", 
                    Main.ue1Introduction("@#$%", 1, "&*()"));
    }

    // Additional MiddleCharacters tests
    @Test
    public void testUe2MiddleCharactersEdgeCases() {
        assertEquals("AA", Main.ue2MiddleCharacters("AA"));
        assertEquals("A A", Main.ue2MiddleCharacters("A B C"));
    }

    @Test
    public void testUe2MiddleCharactersLongStrings() {
        assertEquals("AZZ", Main.ue2MiddleCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    // Additional CaseInsensitiveSubstringCount tests
    @Test
    public void testUe3SubstringOverlapping() {
        assertEquals(2, Main.ue3CaseInsensitiveSubstringCount("aaaa", "aa"));
    }

    @Test
    public void testUe3SubstringSpecialCases() {
        assertEquals(0, Main.ue3CaseInsensitiveSubstringCount("", "test"));
        assertEquals(1, Main.ue3CaseInsensitiveSubstringCount("Test", "test"));
        assertEquals(0, Main.ue3CaseInsensitiveSubstringCount("Test", ""));
    }

    // Additional NumberToLetter tests
    @Test
    public void testUe4NumberToLetterBoundaries() {
        assertEquals("", Main.ue4NumberToLetter(-1));
        assertEquals("", Main.ue4NumberToLetter(0));
        assertEquals("A", Main.ue4NumberToLetter(1));
        assertEquals("Z", Main.ue4NumberToLetter(26));
        assertEquals("", Main.ue4NumberToLetter(27));
    }

    // Additional ReverseString tests
    @Test
    public void testUe5ReverseStringSpecialCases() {
        assertEquals("", Main.ue5ReverseString(""));
        assertEquals("a", Main.ue5ReverseString("a"));
        assertEquals("!@#$", Main.ue5ReverseString("$#@!"));
    }

    // Additional PasswordStrengthChecker tests
    @Test
    public void testUe6PasswordStrengthVariations() {
        assertEquals("Passwort ist schwach", Main.ue6PasswordStrengthChecker(""));
        assertEquals("Passwort ist schwach", Main.ue6PasswordStrengthChecker("abc"));
        assertEquals("Passwort ist schwach", Main.ue6PasswordStrengthChecker("ABC123"));
        assertEquals("Passwort ist stark", Main.ue6PasswordStrengthChecker("Abc123!@#"));
    }

    // Additional PalindromeChecker tests
    @Test
    public void testUe7PalindromeVariations() {
        assertTrue(Main.ue7PalindromeChecker("")); // Empty string
        assertTrue(Main.ue7PalindromeChecker("a")); // Single character
        assertTrue(Main.ue7PalindromeChecker("A man a plan a canal Panama"));
        assertFalse(Main.ue7PalindromeChecker("race a car"));
    }

    // Additional DecodeSecretMessage tests
    @Test
    public void testUe8DecodeSecretMessageEdgeCases() {
        assertEquals("", Main.ue8DecodeSecretMessage(""));
        assertEquals("", Main.ue8DecodeSecretMessage("ab"));
        assertEquals("Test", Main.ue8DecodeSecretMessage("123Test"));
    }

    // Additional CountOccurrences tests
    @Test
    public void testUe9CountOccurrencesComplex() {
        assertEquals(3, Main.ue9CountOccurrences("Anna Anna Anna", "Anna"));
        assertEquals(0, Main.ue9CountOccurrences("", "Anna"));
        assertEquals(0, Main.ue9CountOccurrences("Anna", ""));
    }

    // Additional CountCharacters tests
    @Test
    public void testUe10CountCharactersSpecial() {
        assertEquals("Buchstaben: 0, Ziffern: 0, Sonderzeichen: 0", 
                    Main.ue10CountCharacters(""));
        assertEquals("Buchstaben: 0, Ziffern: 0, Sonderzeichen: 5", 
                    Main.ue10CountCharacters("!@#$%"));
        assertEquals("Buchstaben: 0, Ziffern: 5, Sonderzeichen: 0", 
                    Main.ue10CountCharacters("12345"));
    }

    // Additional WordFrequencyCounter tests
    @Test
    public void testUe11WordFrequencyEmpty() {
        assertEquals("{}", Main.ue11WordFrequencyCounter(""));
    }

    @Test
    public void testUe11WordFrequencySpecialCases() {
        assertEquals("{hello=2}", Main.ue11WordFrequencyCounter("Hello HELLO"));
        assertEquals("{the=2, quick=1, brown=1, fox=1}", 
                    Main.ue11WordFrequencyCounter("The quick brown fox The"));
    }

    // Additional CanBuildWord tests
    @Test
    public void testUe12CanBuildWordEdgeCases() {
        assertTrue(Main.ue12CanBuildWord("", new char[]{}));
        assertFalse(Main.ue12CanBuildWord("hello", new char[]{}));
        assertFalse(Main.ue12CanBuildWord("", new char[]{'a','b'}));
    }

    // Additional TextEncryptionDecryption tests
    @Test
    public void testUe13EncryptionSpecialCases() {
        assertEquals("", Main.ue13TextEncryptionDecryption(""));
        assertEquals("01100001", Main.ue13TextEncryptionDecryption("a"));
        assertEquals("01011010", Main.ue13TextEncryptionDecryption("Z"));
    }

    // Additional URLParser tests
    @Test
    public void testUe14URLParserEdgeCases() {
        assertEquals("Invalid URL", Main.ue14URLParser(""));
        assertEquals("Invalid URL", Main.ue14URLParser("not a url"));
        assertEquals("Protokoll: https", Main.ue14URLParser("https://"));
    }

    // Additional AnagramChecker tests
    @Test
    public void testUe15AnagramCheckerSpecialCases() {
        assertTrue(Main.ue15AnagramChecker("", ""));
        assertFalse(Main.ue15AnagramChecker("a", ""));
        assertFalse(Main.ue15AnagramChecker("", "a"));
        assertTrue(Main.ue15AnagramChecker("11", "11"));
    }

    @Test
    public void testUe15AnagramCheckerComplex() {
        assertTrue(Main.ue15AnagramChecker("Eleven plus two", "Twelve plus one"));
        assertTrue(Main.ue15AnagramChecker("4321", "1234"));
        assertFalse(Main.ue15AnagramChecker("hello", "world"));
    }

    // Performance tests
    @Test
    public void testUe3LargeInput() {
        String longText = "hello".repeat(1000);
        assertEquals(1000, Main.ue3CaseInsensitiveSubstringCount(longText, "hello"));
    }

    @Test
    public void testUe11LargeWordCount() {
        String longText = "word ".repeat(1000);
        assertEquals("{word=1000}", Main.ue11WordFrequencyCounter(longText));
    }

    // Null input tests
    @Test
    public void testNullInputs() {
        assertEquals("", Main.ue2MiddleCharacters(null));
        assertEquals(0, Main.ue3CaseInsensitiveSubstringCount(null, null));
        assertFalse(Main.ue7PalindromeChecker(null));
        assertEquals("", Main.ue8DecodeSecretMessage(null));
        assertEquals("{}", Main.ue11WordFrequencyCounter(null));
    }

    // Special character tests
    @Test
    public void testSpecialCharacters() {
        assertEquals("€$¥", Main.ue5ReverseString("¥$€"));
        assertTrue(Main.ue7PalindromeChecker("¡!!¡"));
    }

    // Unicode tests
    @Test
    public void testUnicodeCharacters() {
        assertEquals("😊🌟✨", Main.ue5ReverseString("✨🌟😊"));
        assertTrue(Main.ue7PalindromeChecker("🌟🌟"));
        assertEquals(2, Main.ue9CountOccurrences("🎈🎈🎉🎉", "🎈"));
    }
}
