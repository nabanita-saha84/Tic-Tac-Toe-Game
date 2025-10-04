package com.nabanita.saha.lld.Tic_Tac_Toe_Game;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    Game(Player player1, Player player2, Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        int curr=1;
        int size = board.size;
        Response response;
        Player currPlayer;
        while(true){
            if(curr>size*size) {
                System.out.println("The Game is Drawn!!");
                return;
            } else if(curr%2==1){
                currPlayer = player1;
            } else {
                currPlayer = player2;
            }
            System.out.println(currPlayer.getName()+"'s turn:");
            System.out.print("Enter col:");
            int x = scanner.nextInt();
            System.out.print("Enter row:");
            int y = scanner.nextInt();
            response = board.mark(x,y,currPlayer);
            if(response==Response.WIN){
                System.out.println(currPlayer.getName()+" won the Game!!");
                return;
            }else if(response==Response.NOT_WIN){
                curr++;
            }
        }
    }
}
