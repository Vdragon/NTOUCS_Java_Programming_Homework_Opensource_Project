/** 
	@file CrapsSimulation.java
	@brief 2-2 作業 CrapsSimulation 類別實作

	本來源程式碼為「海洋大學資訊工程學系《Java 程式設計》課程作業開放來源程式碼專案(NTOUCS Java Programming Homework Opensource Project)」軟體的一部份
	This source code is part of "海洋大學資訊工程學系《Java 程式設計》課程作業開放來源程式碼專案(NTOUCS Java Programming Homework Opensource Project)" software
		https://github.com/Vdragon/NTOUCS_Java_Programming_Homework_Opensource_Project
	
	本來源程式碼的架構基於「通用程式來源程式碼範本」專案
	This source code's structure is based on "Generic Program Source Code Templates" project
		https://github.com/Vdragon/Generic_Program_Source_Code_Templates
		
	建議的文字編輯器設定
	Recommended text editor settings
		Indentation by tab character
		Tab character width = 2 space characters
	
	@author 林博仁(09957010) <Henry.Lin.Taiwan@gmail.com>
	@copyright 
		本來源程式碼基於合理使用(fair use)原則使用下列智慧財產：
		Craps 子類別取自《Java How to Program》的 Fig. 6.9 的範例程式碼
		(C) Copyright 1992-2007 by Deitel & Associates, Inc. and Pearson Education, Inc. All Rights Reserved.
		
		除了特別聲明之內容外，本來源程式碼之內容以 [GNU 通用公共授權條款](https://www.gnu.org/licenses/gpl.html)第 3 版或其任意之更近期版本授權所有人使用。  
		Except content otherwise noted, content of this source code are licenced with [GNU General Public License](https://www.gnu.org/licenses/gpl.html) version 3 or any of it's later versions.
*/

package ntou.cs.java2014.HenryLin;

import java.util.Random;

/**
 * @brief CrapsSimulation 類別
 */
public class CrapsSimulation {
	/* 類別變數
	   Class fields */
	/** @brief 保存投擲幾次骰子時贏遊戲的次數的陣列
	 *  [0] -> 略過不用
	 *  [N](1 <= N <= 20) -> 投擲 N 次贏遊戲的次數
	 *  [21] -> 投擲 21 次或以上贏遊戲的次數 */
	private static int dice_rolled_win_times[] = new int[22];
	
	/** @brief 保存投擲幾次骰子時輸遊戲的次數的陣列
	 *  [0] -> 略過不用
	 *  [N](1 <= N <= 20) -> 投擲 N 次輸遊戲的次數
	 *  [21] -> 投擲 21 次或以上輸遊戲的次數 */
	private static int dice_rolled_lose_times[] = new int[22];
	
	/** @brief 每次遊戲的骰子投擲次數 */
	private static int dice_roll_times;
	
	/** 
	 * @brief A modification of fig. 6.9: Craps.java - Craps class simulates the dice game craps.
	 * @copyright 
	 **************************************************************************
	 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
	 * Pearson Education, Inc. All Rights Reserved.                           *
	 *                                                                        *
	 * DISCLAIMER: The authors and publisher of this book have used their     *
	 * best efforts in preparing the book. These efforts include the          *
	 * development, research, and testing of the theories and programs        *
	 * to determine their effectiveness. The authors and publisher make       *
	 * no warranty of any kind, expressed or implied, with regard to these    *
	 * programs or to the documentation contained in these books. The authors *
	 * and publisher shall not be liable in any event for incidental or       *
	 * consequential damages in connection with, or arising out of, the       *
	 * furnishing, performance, or use of these programs.                     *
	 *************************************************************************/
	private static class Craps 
	{
	/* 類別變數
	   Class fields */
	
	// create random number generator for use in method rollDice
	private Random randomNumbers = new Random(); 

	// enumeration with constants that represent the game status
	private enum Status { CONTINUE, WON, LOST };

	// constants that represent common rolls of the dice
	private final static int SNAKE_EYES = 2;
	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;

	// plays one game of craps
	public void play()
	{
	   int myPoint = 0; // point if no win or loss on first roll
	   Status gameStatus; // can contain CONTINUE, WON or LOST

	   int sumOfDice = rollDice(); // first roll of the dice

	   // determine game status and point based on first roll 
	   switch ( sumOfDice ) 
	   {
	      case SEVEN: // win with 7 on first roll
	      case YO_LEVEN: // win with 11 on first roll           
	         gameStatus = Status.WON;
	         break;
	      case SNAKE_EYES: // lose with 2 on first roll
	      case TREY: // lose with 3 on first roll
	      case BOX_CARS: // lose with 12 on first roll
	         gameStatus = Status.LOST;
	         break;
	      default: // did not win or lose, so remember point         
	         gameStatus = Status.CONTINUE; // game is not over
	         myPoint = sumOfDice; // remember the point
	         // System.out.printf( "Point is %d\n", myPoint );
	         break; // optional at end of switch
	   } // end switch 

	   // while game is not complete
	   while ( gameStatus == Status.CONTINUE ) // not WON or LOST
	   { 
	      sumOfDice = rollDice(); // roll dice again

	      // determine game status
	      if ( sumOfDice == myPoint ) // win by making point
	         gameStatus = Status.WON;
	      else
	         if ( sumOfDice == SEVEN ) // lose by rolling 7 before point
	            gameStatus = Status.LOST;
	   } // end while 

	   // display won or lost message
	   if ( gameStatus == Status.WON ){
		  dice_rolled_win_times[dice_roll_times <= 20 ? dice_roll_times : 21]++;
	      // System.out.println( "Player wins" );
	   } else{
		  dice_rolled_lose_times[dice_roll_times <= 20 ? dice_roll_times : 21]++;
	      // System.out.println( "Player loses" );
	   }
	   
	   // reset dice_roll_times counter
	   dice_roll_times = 0;
	} // end method play

	// roll dice, calculate sum and display results
	public int rollDice()
	{
	   dice_roll_times++;
	   
	   // pick random die values
	   int die1 = 1 + randomNumbers.nextInt( 6 ); // first die roll
	   int die2 = 1 + randomNumbers.nextInt( 6 ); // second die roll

	   int sum = die1 + die2; // sum of die values

	   /* display results of this roll
	   System.out.printf( "Player rolled %d + %d = %d\n", 
	      die1, die2, sum ); */

	   return sum; // return sum of dice
	} // end method rollDice
	} // end class Craps

	/* Constructors */
	/**
	 * @brief Default constructor of CrapsSimulation class
	 */
	public CrapsSimulation() {
		return;
	}
	
	/* 類別方法
	   Class methods */
	/** 
	 * @brief 進行模擬的子程式
	 * @param times 運行遊戲次數
	 */
	public void simulate(int times){
		Craps game = new Craps();
		
		for(int i = 1; i <= times; ++i){
			game.play();
		}
		
		for(int i = 1; i <= 20; ++i){
			System.out.printf(
				"%d games won and %d games lost on roll #%d\n", 
				dice_rolled_win_times[i], 
				dice_rolled_lose_times[i], 
				i
			);
		}
		System.out.printf(
			"%d games won and %d games lost on rolls after the 20th roll\n",
			dice_rolled_win_times[21], 
			dice_rolled_lose_times[21]
		);
		
		game = null;
		return;
	}
	
	/**
	 * @brief 重設模擬子程式
	 * 這個子程式會把 dice_rolled_win_times 、dice_rolled_lose_times 陣列重設為 0
	 */
	public void reset(){
		dice_rolled_win_times = new int[22];
		dice_rolled_lose_times = new int [22];
		return;
	}
}

