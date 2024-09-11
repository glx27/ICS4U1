import java.util.Scanner;
import java.util.Random;

public class diceGame {
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in); 
        int points = 500;       
        System.out.println(CYAN + "Welcome to the dice game! You have 500 points" + RESET);
        while (points > 0 && points <= 10000){
            int roll = random.nextInt(6) + 1;
            System.out.println(PURPLE + "Enter how many points you wish to wager" + RESET);
            int wager = scanner.nextInt();
            if (wager > points){
                System.out.println(RED + "YOU DO NOT HAVE ENOUGH POINTS!!!" + RESET);
            } else if (wager <= 0){
                System.out.println(RED + "Please enter a valid number!" + RESET);
            }
            else {
                int num = random.nextInt(6) + 1;
                if (num > roll){
                    points = points + wager;
                    System.out.println("The house rolled a " + RED + roll + RESET +" and you rolled a " + GREEN + num + RESET+ ", you beat the house and won! You now have " + GREEN + points + RESET+ " points!");
                } else if (num < roll) {
                    points = points - wager;
                    System.out.println("The house rolled a " + roll + " and you rolled a " + num + ", you lost to the house! You now have "+ GREEN + points + RESET +" points!");
                } else {
                    System.out.println("The house rolled a " + roll + " and you rolled a " + num + ", you tied with the house! You still have " +GREEN + points + RESET + " points!");
                }
            }
        }
    }
}