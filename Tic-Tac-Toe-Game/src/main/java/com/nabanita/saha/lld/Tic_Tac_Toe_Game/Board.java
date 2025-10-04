package com.nabanita.saha.lld.Tic_Tac_Toe_Game;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int size;
    Marker[][] board;

    Map<Integer, Map<Marker, Integer>> rows = new HashMap<>();
    Map<Integer, Map<Marker, Integer>> cols = new HashMap<>();
    Map<Integer, Map<Marker, Integer>> diagonals = new HashMap<>();


    Board(int size){
        this.size= size;
        board = new Marker[size][size];

        for(int i=1; i<=size; i++){
            rows.put(i, new HashMap<>(Map.of(Marker.X, 0, Marker.O, 0)));
            cols.put(i, new HashMap<>(Map.of(Marker.X, 0, Marker.O, 0)));
        }
        diagonals.put(1, new HashMap<>(Map.of(Marker.X, 0, Marker.O, 0)));
        diagonals.put(2, new HashMap<>(Map.of(Marker.X, 0, Marker.O, 0)));
    }

    public Response mark(int x, int y, Player player) {
        if(board[y-1][x-1]!=null){
            System.out.println("Not vacant to mark!! Try again at different spot");
            return Response.ERROR;
        } else {
            board[y-1][x-1] = player.marker;

            rows.get(y).put(player.marker, rows.get(y).get(player.marker)+1);
            cols.get(x).put(player.marker, cols.get(x).get(player.marker)+1);

            if(x==y){
                diagonals.get(1).put(player.marker, diagonals.get(1).get(player.marker)+1);
            }
            if ((x+y)==size+1){
                diagonals.get(2).put(player.marker, diagonals.get(2).get(player.marker)+1);
            }

            printBoard();
            
            if(checkIfWon(rows.get(y), player)==Response.WIN ||
                    checkIfWon(cols.get(x), player)==Response.WIN ||
                    checkIfWon(diagonals.get(1), player)==Response.WIN ||
                    checkIfWon(diagonals.get(2), player)==Response.WIN){
                return Response.WIN;
            }
        }
        return Response.NOT_WIN;
    }

    private Response checkIfWon(Map<Marker, Integer> markerIntegerMap, Player player) {
        if(markerIntegerMap.get(player.marker)==size)   return Response.WIN;
        return Response.NOT_WIN;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println("\n-----------");
        }
    }
}
