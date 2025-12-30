//11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124


import java.util.Scanner;

public class D2P1 {
    public static void main(String[] args) {
        //so. find any id which is a number repeated twice. eg, 55, 2424, 123123.
        //criteria. numbers must have an even index. 10, 10^2, 10^4 etc.
            //hence. count chars in an id, if even continue, if odd disregard.
        //split directly in the middle. char index in a string, go from /2 of chars. if first half = second half. ITS AN INVALID ID

        System.out.println("Provide a CSV list of numerical ranges including a '-' character, to identify and total the value of all invalid IDs");
        Scanner input = new Scanner(System.in);
        String userIn = input.nextLine();
        String[] IDs = userIn.split(",");

        long  invalidsTotaled = 0; //the mathematical addition of each invalid figure, NOT the n amount of invalid ids

        for (int i = 0; i < IDs.length; i++){
            String[] range = IDs[i].split("-");
            long start = Long.parseLong(range[0]);
            long end = Long.parseLong(range[1]);
            //e.g. rn start = 11, and end = 22
            for (long j = start; j <= end; j++){
                //j = 11 rn, ++ to 22
                String jStr = Long.toString(j);
                //aka if 10, 1000, 100000, etc
                if (jStr.length() % 2 == 0){
                    int halfLength = jStr.length() / 2; //e.g. 1.
                    int id1 = Integer.parseInt(jStr.substring(0, halfLength)); //e.g. 1
                    int id2 = Integer.parseInt(jStr.substring(halfLength)); //e.g 1

                    if (id1 == id2){
                        invalidsTotaled += j;
                    }
                }
            }
        }

        System.out.println("All invalid IDs totaled: " + invalidsTotaled);

    }
}
