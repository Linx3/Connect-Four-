import java.util.Scanner;

public class ConnectFourTesting extends ConnectFourFinal{

   public static void main (String[] args){
    grid=new String[6][7];
    Scanner kb = new Scanner (System.in);
    System.out.println("Play Connect Four!");
    createGrid();
    printGrid();
    boolean win = false;
    while(win==false){
      System.out.println("\n \n Choose a column!");
      int user = kb.nextInt();
      while (user>6 || user < 0 || checkValid(user)==false){
        System.out.println("Invalid Choice. Try Again!");
        user=kb.nextInt();
      }
      replace(user);
      printGrid();
      if(checkWin("X", user)==true){
        System.out.println("Congratulations! You won!");
        break;
      }
      System.out.println();
      System.out.println("AI Choice: Column "+ aiChoice());

      int ai = aiChoice();
      while (checkValid(ai)==false)
        ai=aiChoice();
      aiReplace(ai);
      printGrid();
      if (checkWin("O",ai)){
        System.out.println("Sorry. The computer won.");
        break;
    }
   }
   }

}