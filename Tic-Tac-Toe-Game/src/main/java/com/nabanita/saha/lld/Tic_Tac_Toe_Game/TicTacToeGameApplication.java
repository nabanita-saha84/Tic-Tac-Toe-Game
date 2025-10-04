package com.nabanita.saha.lld.Tic_Tac_Toe_Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeGameApplication.class, args);
		Scanner scanner = new Scanner(System.in);
//		Player Diya = new Player("Diya", Marker.X);
//		Player Prateek = new Player("Prateek", Marker.O);
		System.out.print("Enter the size of the Tic Tac Toe Board Game : ");
		int size = scanner.nextInt();
		Board board = new Board(size);
		System.out.println("Enter Player1 details : ");
		System.out.print("Name : ");
		Player player1 = new Player(scanner.next(), Marker.X);
		System.out.println("Enter Player2 details:");
		System.out.print("Name : ");
		Player player2 = new Player(scanner.next(), Marker.O);
		Game game = new Game(player1, player2, board);
		game.playGame();
	}

}
