import java.util.Scanner;

public class D1P2 {
    public static void main(String[] args) {
        //input is now multi-line nextLine()
        Scanner input = new Scanner(System.in);

        int dial = 50;
        int zeroCounter = 0; //passing or landing
        boolean stupiduglylinespacing = true;

        System.out.println("Enter a rotation, with the L or R prefix, as many as you wish. Press cmd + D to end process.");

        //start loop
        while (input.hasNextLine()) {
            String userIn = input.nextLine();

            if (stupiduglylinespacing){
                System.out.println();
                stupiduglylinespacing = false;
            }

            char op = userIn.charAt(0);
            int value = Integer.parseInt(userIn.substring(1));

            int startPos = dial;

            if (op == 'R' || op == 'r') {
                dial += value;

                zeroCounter += countZeroes(startPos, dial, op);

                while (dial > 99){
                    dial -= 100;
                }

            } else if (op == 'L' || op == 'l') {
                dial -= value;

                zeroCounter += countZeroes(startPos, dial, op);

                while (dial < 0){
                    dial += 100;
                }
            }

            System.out.println("Dial: " + dial);

        }
        System.out.println();
        System.out.println("There are " + zeroCounter + " zeroes");
    }

    private static int countZeroes (int start, int end, char op) {
        //how many 100 wraps happen (errored only in full set with n > 100)
        int counter = 0;

        if (op == 'R' || op == 'r') {
            for (int i = start + 1; i <= end; i++) {
                if (i % 100 == 0) {
                    counter++;
                }
            }
        } else if (op == 'L' || op == 'l') {
            for (int i = start - 1; i >= end; i--){
                if (i % 100 == 0){
                    counter++;
                }
            }
        }

        return counter;
    }
}