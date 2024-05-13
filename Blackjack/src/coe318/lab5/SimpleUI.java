package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House holds: ");
        System.out.println(game.getHouseCards().getCards());
        System.out.println("You hold: ");
        System.out.println(game.getYourCards().getCards());
            System.out.println(" ");

    }

  @Override
    public boolean hitMe() {
        System.out.println("Another card? (Enter 'true' for yes or 'false' for no)");
        return user.nextBoolean();
    }

  @Override
    public void gameOver() {
    game.getHouseCards().getCards().get(0).setFaceUp(true);
    display();
        
        
    int s1=game.score(game.getYourCards());
    int s2=game.score(game.getHouseCards());
    System.out.println(" ");
    System.out.print("Your score: " + s1);
    System.out.print(", House score: " + s2);
    System.out.println(" ");

    if(s1>21 || s1==s2 || s1<=21 && s2<=21 && s1<s2){
        System.out.println("You Lose");
    } else if(s1<21 && s2>21 || s1<=21 && s2<=21 && s1>s2){
        System.out.println("You Win");
    } else{
        System.out.println("Draw");
    }
    }

}