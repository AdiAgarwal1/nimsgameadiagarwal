import java.util.Scanner;
public class Game {
    private float pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    int numpieces = (int)(Math.random()*40+10);
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){



        pieces = numpieces;//To Do: Grab a random value between 10 and 50
        this.p1 = p1;
        this.p2 = p2;
        System.out.println("There are "+numpieces + " on the gameboard");
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        System.out.println("There are "+ pieces+" remaining!");
        //int take;
       Scanner piecesTaken = new Scanner(System.in);
       System.out.println("How many pieces are you going to take?");
       int take = piecesTaken.nextInt();

        while (!isLegal(take)){
            System.out.println("You cannot enter this number, please try again!");
            take = sc.nextInt();
        }
        currentPlayer.adjustScore(take);
        
         pieces = pieces-take;
        System.out.println("There are "+ pieces+" pieces remaining!");
        System.out.println("-----------------------");
        if(currentPlayer == p1){
            currentPlayer = p2;
        
        }else{
            currentPlayer = p1;
        }
        System.out.println("it is now "+ currentPlayer.getName()+" turn");
        if(pieces ==1 ){
            System.out.println(currentPlayer.getName() + " got the last piece, so they lose");
        }
        return take;
    }

    
    public Player getNextPlayer(){
    //Changes which players turn it is and returns the current player.
       
        return currentPlayer;
    }

   public boolean isLegal(int x){
if (x==0){
 return false;
    }
else if(pieces-x >= pieces/2){
    return true;

}
else{

        return false;
    }
}


    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }
}
