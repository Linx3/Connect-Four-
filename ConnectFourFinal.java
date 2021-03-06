//Xinyu LinPeriod 7


public class ConnectFourFinal{
  public static String grid[][];
  

  public static void createGrid(){        //creates the ConnectFour grid
    for (int i=0; i<6; i++){
      for(int x=0; x<7; x++){
        grid[i][x]="_";
      }
    }
  }
  
  public static void printGrid(){        //prints out the grid
    System.out.println("0  1  2  3  4  5  6");
    int n=0;
    for (int j=0; j<grid.length; j++){
      for (int k=0; k<grid[0].length; k++){
        System.out.print(grid[j][k]+"  ");
      }
      System.out.print(n);
      n++;
      System.out.println(" ");
    }
  }
  
  public static int drop(int userInput){     //checks the lowest row of the userinput column
    int row = 5;
    while (!grid[row][userInput].equals("_") && row>0){
      row--;
    }
    return row;
  }
  
  public static void replace(int userInput){  //replaces the _ with user or computer input
    grid[drop(userInput)][userInput]="X";
  }
  
  public static boolean checkValid(int userInput){  //makes sure a move is valid
    int row = 5;
    while(row>0){
      row--;
    if(grid[row][userInput].equals("_"))
      return true;
    }
    return false;
  }
  
  
  public static boolean checkVertical (String user, int col){    //checks to see if there is a vertical win
    if (drop(col)>=2)
      return false;
    if (grid[drop(col)+2][col].equals(user) && grid[drop(col)+3][col].equals(user) && grid[drop(col)+4][col].equals(user)){
      return true;
    }
    return false;
  }
    
  public static boolean checkHorizontal (String user, int col){
    int row = drop(col)+1;
    int count = 0;
    for (int i = 0; i<grid.length-1; i++){
      count++;
      if (count == 4)
        return true;
      if (grid[row][i].equals("_") || !grid[row][i].equals(grid[row][i+1]))
        count=0;
    }
    return false;
  }
  
  public static boolean checkNegDiagonal (String user, int col){
    int row = drop(col)+1;
    int k = 0; 
    int j = 0;
    int count = 0;
    while (row+k<6 && col+k<7){
      if (grid[row+k][col+k].equals(user))
        count++;
      if (!grid[row+k][col+k].equals(user))
        break;
      k++;
    }
    
    while (row-j>0 && col-j>0){
      if(grid[row-j][col-j].equals(user))
        count++;
      if(!grid[row-j][col-j].equals(user))
        break;
      j++;
    }
    if (count>4)
      return true;
    count = 0;
    return false;
  }
 
   public static boolean checkPosDiagonal(String user, int col){
    int row = drop(col)+1;
    for(int i=3;i<grid.length;i++){
      for(int k=0; k<4;k++){
        int count=0;
        for(int c=0;c<4;c++){
          if(grid[i-c][k+c].equals(user))
            count++;
        }
        if(count==4)
          return true; 
      }
    }
    return false; 
  }
  
  public static boolean checkWin(String user, int col){
    if (checkPosDiagonal(user,col)==true || 
        checkVertical(user, col) == true || 
        checkHorizontal(user, col)==true || 
        checkNegDiagonal (user, col) == true)
      return true;
    return false;
  }
  
   public static int aiChoice (){
     for (int i = 0; i<grid.length; i++){
       if(checkValid(i)){
       replace(i);
       if (checkWin("X", i)==true){
         grid[drop(i)+1][i]="_";         
         return i;
       }
       else {
         grid[drop(i)+1][i]="_";
       }
       }
     }
     for (int x=0; x<grid.length; x++){
       if(checkValid(x)){
         aiReplace(x);
       if (checkWin("O", x)==true){
         grid[drop(x)+1][x]="_";
         return x;
       }
       else { 
         grid[drop(x)+1][x]="_";
       }
       }
     }
     return (int)(Math.random()*7);
  }
   
  public static void aiReplace (int userInput){
    grid[drop(userInput)][userInput]="O";
  }
}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
  
