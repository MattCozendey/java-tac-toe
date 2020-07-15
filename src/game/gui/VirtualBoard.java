/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

/**
 *
 * @author mathe
 */
public class VirtualBoard {
    private static int turn = 0;
    private static int timesPlayed = 0;
    private static Boolean someoneHasWon = false;
  
    public static Boolean winnerREDUNDANT(){
    return someoneHasWon;
    }
    
    public static void resetWinner(){
    someoneHasWon = false;
    }
    
    private static String[] game =
    {"z", "z", "z",
     "z", "z", "z",
     "z", "z", "z",};
    
    private static String[] getGame(){
    return game;
    }
    
    private static int getTurn(){
        return turn;
    }
    
    private static void changeTurn(){
    turn++;
    }
    
    private static void checkBoard(){
        int boardSize = getGame().length;
        
        for(int i = 0; i < boardSize; i++){
           if((i == 0 || i == 3 || i == 6) && game[i] != "z"){
               
               if(game[i] == game[i + 1] && game[i + 1] == game[i + 2]){
                   System.out.println("Ganhador! Horizontal.");
                   someoneHasWon = true;
               break;
               }
               
              
           }
        }
        
        for (int j = 0; j < boardSize; j++){
            if((j == 0 || j == 1 || j == 2) && game[j] != "z"){
            
            if(game[j] == game[j + 3] && game[j + 3] == game[j + 6]){
                System.out.println("Ganhador! Vertical.");
                                   someoneHasWon = true;
                break;
            }
         }
        
        }
        
        if((game[0] == game[4] && game[4] == game[4+4]) && game[4+4] != "z"){
            System.out.println("Ganhador! Diagonal esquerda p direita");
                               someoneHasWon = true;
        }
        else if((game[2] == game[4] && game[4] == game[6]) && game[6] != "z"){
            System.out.println("Ganhador! Diagonal direita p esquerda");
                               someoneHasWon = true;

        }
        
        if(someoneHasWon){
            for(int k = 0; k < boardSize; k++){
            game[k] = "z";
            }            
        }
        
    }
    
    public static void change(javax.swing.JButton btn){
        Integer index = Integer.parseInt(btn.getName());
        if(btn.getText() == ""){
        
            if(getTurn() % 2 == 0){
                btn.setText("X");
            }
            else{
                btn.setText("O");
            }
        
            changeTurn();
            
                    
        game[index] = btn.getText();
        timesPlayed++;
        if(timesPlayed > 3){
                checkBoard();
        }

        }

    }
}
