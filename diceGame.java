import java.util.Scanner;
import java.util.Random;

public class diceGame {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";
    public static final String CYAN = "\033[0;36m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String BLUE_BOLD = "\033[1;34m";  

    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in); 
        int points = 500;       
        System.out.println(BLUE_BOLD + "\nWelcome to the dice game! You have 500 points" + RESET);
        while (points > 0 && points <= 10000){
            int roll = random.nextInt(6) + 1;
            System.out.println(CYAN + "Enter how many points you wish to wager" + RESET);
            int wager = scanner.nextInt();
            if (wager > points){
                System.out.println(RED_BOLD + "YOU DO NOT HAVE ENOUGH POINTS!!!" + RESET);
            } else if (wager <= 0){
                System.out.println(RED + "Please enter a valid number!" + RESET);
            }
            else {
                int num = random.nextInt(6) + 1;
                if (num > roll){
                    points = points + wager;
                    System.out.println("The house rolled a " + RED_BOLD + roll + RESET + " and you rolled a " + BLUE_BOLD + num + RESET + ", you beat the house and won! You now have " + GREEN_BOLD + points + RESET+ " points!");
                } else if (num < roll) {
                    points = points - wager;
                    System.out.println("The house rolled a " + RED_BOLD + roll + RESET + " and you rolled a " + BLUE_BOLD + num + RESET + ", you lost to the house! You now have "+ GREEN_BOLD + points + RESET +" points!");
                } else {
                    System.out.println("The house rolled a " + RED_BOLD + roll + RESET + " and you rolled a " + BLUE_BOLD + num + RESET + ", you tied with the house! You still have " + GREEN_BOLD + points + RESET + " points!");
                }
            }
        }
        if (points >= 10000){
        System.out.println(GREEN_BOLD + "Your point count has reached or exceeded 10000! You win!" + RESET);
        } else {
            System.out.println(RED_BOLD + "You ran out of points! You loose! " + RESET);
        }
    }
}