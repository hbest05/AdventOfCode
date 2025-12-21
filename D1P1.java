import java.util.Scanner;

public class D1P1 {
    public static void main(String[] args) {
        //input is now multi-line nextLine()
        Scanner input = new Scanner(System.in);

        int dial = 50;
        int zeroCounter = 0;
        boolean stupiduglylinespacing = true;

        System.out.println("Enter a rotation, with the L or R prefix. Press cmd + D to end process.");

        //start loop
        while (input.hasNextLine()) {
            String userIn = input.nextLine();

            char op = userIn.charAt(0);
            String valueStr = userIn.substring(1);
            int value = Integer.parseInt(valueStr);

            if (op == 'R' || op == 'r') {
                dial += value;

                //e.g.95 + 60 = 155
                while (dial > 99) {
                    dial -= 100;
                }
            } else if (op == 'L' || op == 'l') {
                dial -= value;

                //e.g. 50 - 68 = -18
                while (dial < 0) {
                    dial += 100;
                }
            }

            if (stupiduglylinespacing){
                System.out.println();
                stupiduglylinespacing = false;
            }

            System.out.println("Dial: " + dial);

            if (dial == 0) {
                zeroCounter++;
                System.out.println("Zeroes:" + zeroCounter);
            }
        }
        System.out.println();
        System.out.println("There are " + zeroCounter + " zeroes");
    }
}