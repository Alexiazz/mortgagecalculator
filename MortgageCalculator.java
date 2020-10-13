package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        final byte months_in_year = 12;
        final byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal : ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate : ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / percent / months_in_year;

        System.out.print("Period in Years : ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * months_in_year;

        // mortgage formula P x (r / n) x (1 + r / n)^n(t)] / (1 + r / n)^n(t) - 1
        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
