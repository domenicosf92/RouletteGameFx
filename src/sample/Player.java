package sample;

import java.util.ArrayList;

public class Player {
    private String name;
    private int credit;
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> bets = new ArrayList<>();

    public void addTo (int number, int bet) {
        this.numbers.add(number);
        this.bets.add(bet);
    }

    public Player(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public void removeCredit(double credit) {
            this.credit -= credit;
    }

    public void addCredit(double credit) {
        this.credit += credit;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        String s= "--Player--\n" + "Name: " + this.name + "\nCredit: " + this.credit;
        return s;
    }
}
