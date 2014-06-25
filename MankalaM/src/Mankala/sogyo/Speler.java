package Mankala.sogyo;

import java.util.Scanner;

public class Speler {
    int vakje;

    public void doetZet() {
        System.out.println("welk vakje wil je legen?");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.out.println("voer een cijfer in!");
            in.nextLine();
        }
        vakje = in.nextInt();
    }

}
