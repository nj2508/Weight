import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = 0;
        double sum = 0;
        ArrayList<Integer> nums = new ArrayList<>();

        System.out.println("S+?");
        boolean splus = in.nextBoolean();

        while (input > -1) {
            System.out.println("Input a weight, or -1 to end:");
            input = in.nextInt();
            if (input > 0) {
                sum += input;
                nums.add(input);
            } else {
                System.out.println("Done.");
            }
        }
        if (splus) {
            ArrayList<Double> newVals = new ArrayList<>();
            double newSum = 0;
            for (int num : nums) {
                boolean isAffInc = num / sum * 100 < 1.2;
                boolean isAffDec = num / sum * 100 > 9.5;
                if (isAffInc) {
                    newVals.add(num * 1.25);
                    newSum += num * 1.25;
                } else if (isAffDec) {
                    newVals.add(num * 0.85);
                    newSum += num * 0.85;
                } else {
                    newVals.add(num + 0.0);
                    newSum += num * 1;
                }
            }
            for (int i = 0; i < nums.size(); i++) {
                System.out.printf("Item #%d: Raw weight: %d | Percent (no S+): %.2f | Percent (S+): %.2f\n", i + 1, nums.get(i), nums.get(i) / sum * 100, newVals.get(i) / newSum * 100);
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                System.out.printf("Item #%d: Raw weight: %d | Percent: %.2f\n", i + 1, nums.get(i), nums.get(i) / sum * 100);
            }
        }
    }
}