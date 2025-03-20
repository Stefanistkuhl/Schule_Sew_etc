public class Main {
    public static void main(String[] args) {
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

        int[] nums = { 1, 2, 20 };
        boolean resultBool = ue10Array220(nums, 0);

        System.out.println("UE10 array220([1, 2, 20], 0) = " + resultBool);
    }

    public static int ue1Factorial(int n) {
        int result;
        if (n == 0 || n == 1)
            return 1;

        result = ue1Factorial(n - 1) * n;
        return result;
    }

    public static int ue2BunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + ue2BunnyEars(bunnies - 1);
    }

    public static int ue3Fibonacci(int n) {
        if (n <= 1)
            return n;

        return ue3Fibonacci(n - 1) + ue3Fibonacci(n - 2);
    }

    public static int ue4BunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        if (bunnies % 2 != 0) {
            return 2 + ue4BunnyEars2(bunnies - 1);
        } else {

            return 3 + ue4BunnyEars2(bunnies - 1);
        }
    }

    public static int ue5Triangle(int rows) {
        if (rows == 0) {
            return 0;
        }
        return rows + ue5Triangle(rows - 1);
    }

    public static int ue6SumDigits(int n) {
        if (n < 0) {
            n = -n;
        }
        if (n < 10) {
            return n;
        }
        return ue6SumDigits(n / 10) + (n % 10);
    }

    public static int ue7Count7(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = n % 10;
        int rest = n / 10;
        return (digit == 7 ? 1 : 0) + ue7Count7(rest);
    }

    public static int ue8Count8(int n) {
        if (n < 10) {
            return (n == 8) ? 1 : 0;
        }

        int lastDigit = n % 10;
        int remaining = n / 10;

        if (lastDigit == 8) {
            if (remaining % 10 == 8) {
                return 2 + ue8Count8(remaining);
            }
            return 1 + ue8Count8(remaining);
        }
        return ue8Count8(remaining);
    }

    public static int ue9PowerN(int base, int n) {
        if (n == 1) {
            return base;
        }

        return base * ue9PowerN(base, n - 1);
    }

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
