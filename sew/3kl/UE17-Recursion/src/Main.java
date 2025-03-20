public class Main {
    public static void main(String[] args) {
        // Übungen: https://codingbat.com/java/Recursion-1
        int result;

        result = ue1Factorial(1);
        System.out.println("UE1 factorial(1) = " + result);

        result = ue2BunnyEars(1);
        System.out.println("UE2 bunnyEars(1) = " + result);

        result = ue3Fibonacci(2);
        System.out.println("UE3 fibonacci(2) = " + result);

        result = ue4BunnyEars2(2);
        System.out.println("UE4 bunnyEars2(2) = " + result);

        result = ue5Triangle(2);
        System.out.println("UE5 triangle(2) = " + result);

        result = ue6SumDigits(12);
        System.out.println("UE6 sumDigits(12) = " + result);

        result = ue7Count7(717);
        System.out.println("UE7 count7(717) = " + result);

        result = ue8Count8(8818);
        System.out.println("UE8 count8(8818) = " + result);

        result = ue9PowerN(3, 2);
        System.out.println("UE9 powerN(3, 2) = " + result);

        int[] nums = {1, 2, 20};
        boolean resultBool = ue10Array220(nums, 0);

        System.out.println("UE10 array220([1, 2, 20], 0) = " + resultBool);
    }

    /**
     * Aufgabe: Berechnet die Fakultät einer gegebenen Zahl n (n ≥ 1).
     * Die Fakultät wird definiert als n * (n-1) * (n-2) * ... * 1.
     * Die Berechnung soll rekursiv (ohne Schleifen) erfolgen.
     *
     * Beispiele:
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 2
     *
     *   Input: 3
     *   Erwartete Ausgabe: 6
     */
    public static int ue1Factorial(int n) {
        int result;
        if(n==0 || n==1)
            return 1;

        result = ue1Factorial(n-1) * n;
        return result;
    }

    /**
     * Aufgabe: Wir haben eine Anzahl von Hasen (bunnies), wobei jeder Hase zwei große Schlappohren besitzt.
     * Die Gesamtzahl der Ohren soll rekursiv (ohne Schleifen oder Multiplikation) berechnet werden.
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 2
     *
     *   Input: 2
     *   Erwartete Ausgabe: 4
     */
    public static int ue2BunnyEars(int bunnies) {
        if(bunnies == 0){
           return 0;
        }
        return 2 + ue2BunnyEars(bunnies-1);
    }

    /**
     * Aufgabe: Berechnet den n-ten Fibonacci-Wert rekursiv (ohne Schleifen).
     * Die Fibonacci-Reihe beginnt mit 0 und 1 (für n=0 bzw. n=1).
     * Jeder weitere Wert ist die Summe der beiden vorherigen Werte: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 1
     */
    public static int ue3Fibonacci(int n) {
        if (n <= 1)
            return n;

        return ue3Fibonacci(n - 1) + ue3Fibonacci(n - 2);
    }

    /**
     * Aufgabe: Wir betrachten Hasen in einer Reihe (1, 2, 3, ...).
     * Ungerade Hasen (1, 3, 5, ...) haben 2 Ohren, gerade Hasen (2, 4, 6, ...) haben 3 Ohren (wegen eines hochgestreckten Fußes).
     * Bestimme die Gesamtanzahl der Ohren rekursiv (ohne Schleifen oder Multiplikation).
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 2
     *
     *   Input: 2
     *   Erwartete Ausgabe: 5
     */
    public static int ue4BunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        if (bunnies%2!=0){
            return 2 + ue4BunnyEars2(bunnies-1);
        }else {

            return 3 + ue4BunnyEars2(bunnies-1);
        }
    }

    /**
     * Aufgabe: Gegeben ist eine Dreiecksform, bei der die oberste Reihe 1 Block hat,
     * die nächste Reihe 2 Blöcke, dann 3 Blöcke und so weiter.
     * Bestimme rekursiv (ohne Schleifen oder Multiplikation) die Gesamtanzahl der Blöcke
     * für eine gegebene Anzahl von Reihen.
     *
     * Beispiele:
     *   Input: 0
     *   Erwartete Ausgabe: 0
     *
     *   Input: 1
     *   Erwartete Ausgabe: 1
     *
     *   Input: 2
     *   Erwartete Ausgabe: 3
     */
    public static int ue5Triangle(int rows) {
        if (rows == 0){
            return 0;
        }
        return rows + ue5Triangle(rows-1);
    }

    /**
     * Aufgabe: Gib die Summe der Ziffern einer nicht-negativen ganzen Zahl n zurück,
     * berechnet rekursiv (ohne Schleifen).
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 126
     *   Erwartete Ausgabe: 9
     *
     *   Input: 49
     *   Erwartete Ausgabe: 13
     *
     *   Input: 12
     *   Erwartete Ausgabe: 3
     */
    public static int ue6SumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + ue6SumDigits(n / 10);
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen der Ziffer 7 in einer nicht-negativen ganzen Zahl n,
     * berechnet rekursiv (ohne Schleifen).
     * Beispiel: 717 enthält die Ziffer 7 genau 2-mal.
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 717
     *   Erwartete Ausgabe: 2
     *
     *   Input: 7
     *   Erwartete Ausgabe: 1
     *
     *   Input: 123
     *   Erwartete Ausgabe: 0
     */
    public static int ue7Count7(int n) {
        if (n == 0) {
            return 0;
        }

        int l = n % 10;

        int count = (l == 7) ? 1 : 0;

        return count + ue7Count7(n / 10);
    }

    /**
     * Aufgabe: Zähle die Anzahl der Vorkommen der Ziffer 8 in einer nicht-negativen ganzen Zahl n,
     * berechnet rekursiv (ohne Schleifen).
     * Achtung: Steht eine 8 direkt neben einer weiteren 8 (z.B. "88"),
     * so zählt die zweite 8 doppelt.
     * Hinweis: n % 10 liefert die letzte Ziffer, n / 10 entfernt die letzte Ziffer.
     *
     * Beispiele:
     *   Input: 8
     *   Erwartete Ausgabe: 1
     *
     *   Input: 818
     *   Erwartete Ausgabe: 2
     *
     *   Input: 8818
     *   Erwartete Ausgabe: 4
     */
    public static int ue8Count8(int n) {
        if (n == 0) {
            return 0;
        }

        int l = n % 10;

        int c = 0;

        if (l == 8) {
            c++;

            if ((n / 10) % 10 == 8) {
                c++;
            }
        }

        return c + ue8Count8(n / 10);
    }

    /**
     * Aufgabe: Berechnet rekursiv (ohne Schleifen) die Potenz base^n,
     * wobei base ≥ 1 und n ≥ 1 ist.
     * Beispiel: powerN(3, 2) = 3^2 = 9.
     *
     * Beispiele:
     *   Input: 3, 1
     *   Erwartete Ausgabe: 3
     *
     *   Input: 3, 2
     *   Erwartete Ausgabe: 9
     *
     *   Input: 3, 3
     *   Erwartete Ausgabe: 27
     */
    public static int ue9PowerN(int base, int n) {
        if (n == 1) {
            return base;
        }

        return base * ue9PowerN(base, n - 1);
    }

    /**
     * Aufgabe: Gegeben ein Array von ganzen Zahlen (nums), prüfe rekursiv (ohne Schleifen),
     * ob irgendwo in diesem Array ein Wert vorkommt, auf den direkt sein 10-faches folgt.
     * Die Suche beginnt ab dem Index 'index' und soll in jedem rekursiven Schritt um 1 erhöht werden.
     *
     * Beispiele:
     *   Input: [1, 2, 20], 0
     *   Erwartete Ausgabe: true (2 gefolgt von 20)
     *
     *   Input: [3, 30], 0
     *   Erwartete Ausgabe: true (3 gefolgt von 30)
     *
     *   Input: [3], 0
     *   Erwartete Ausgabe: false (kein Folgewert vorhanden)
     */
    public static boolean ue10Array220(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return false;
        }

        if (nums[index + 1] == 10 * nums[index]) {
            return true;
        }

        return ue10Array220(nums, index + 1);
    }


}
