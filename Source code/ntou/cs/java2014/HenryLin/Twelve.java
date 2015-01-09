/** 
	@file Twelve.java
	@brief 2-1 作業 Twelve 類別實作

	本來源程式碼為「海洋大學資訊工程學系《Java 程式設計》課程作業開放來源程式碼專案」軟體的一部份
	This source code is part of "NTOUCS Java Programming Homework Opensource Project" software
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
		除了特別聲明之內容外，本專案之內容以 [GNU 通用公共授權條款](https://www.gnu.org/licenses/gpl.html)第 3 版或其任意之更近期版本授權所有人使用。  
		Except content otherwise noted, content of this project are licenced with [GNU General Public License](https://www.gnu.org/licenses/gpl.html) version 3 or any of it's later versions.
*/

package ntou.cs.java2014.HenryLin;

/**
 * @brief Twelve 類別
 */
public class Twelve {
	/* 類別變數
	   Class fields */

	/**
	 * @brief Twelve 類別的 constructor
	 */
	public Twelve() {
		
		return;
	}
	/* 類別方法
	   Class methods */
	/**
	 * @brief 唱整首歌的方法
	 */
	public static void sing(){
		String lyric_of_day = null;
		for(int day = 1; day <= 12; ++day){
			lyric_of_day = "On the ";
			switch(day){
			case 1:
				lyric_of_day += "first";
				break;
			case 2:
				lyric_of_day += "second";
				break;
			case 3:
				lyric_of_day += "third";
				break;
			case 4:
				lyric_of_day += "fourth";
				break;
			case 5:
				lyric_of_day += "fifth";
				break;
			case 6:
				lyric_of_day += "sixth";
				break;
			case 7:
				lyric_of_day += "seventh";
				break;
			case 8:
				lyric_of_day += "eighth";
				break;
			case 9:
				lyric_of_day += "ninth";
				break;
			case 10:
				lyric_of_day += "tenth";
				break;
			case 11:
				lyric_of_day += "eleventh";
				break;
			case 12:
				lyric_of_day += "twelfth";
				break;
			default:
				System.err.println("發生了例外狀況：「day」變數在 1~12 範圍外！");
				System.err.println("程式必須異常終止，請向開發者回報此問題。");
				System.exit(-1);
			}
			lyric_of_day += " day of Christmas my true love sent to me:\n";
			
			for(int first_present = day; first_present >= 1; --first_present){
				switch(first_present){
				case 1:
					lyric_of_day += "a Partridge in a Pear tree.\n";
					break;
				case 2:
					lyric_of_day += "Two Turtle Doves, and \n";
					break;
				case 3:
					lyric_of_day += "Three French Hens\n";
					break;
				case 4:
					lyric_of_day += "Four Calling Birds\n";
					break;
				case 5:
					lyric_of_day += "Five Golden Rings\n";
					break;
				case 6:
					lyric_of_day += "Six Geese a Laying\n";
					break;
				case 7:
					lyric_of_day += "Seven Swans a Swimming\n";
					break;
				case 8:
					lyric_of_day += "Eight Maids a Milking\n";
					break;
				case 9:
					lyric_of_day += "Nine Ladies Dancing\n";
					break;
				case 10:
					lyric_of_day += "Ten Lords a Leaping\n";
					break;
				case 11:
					lyric_of_day += "Eleven Pipers Piping\n";
					break;
				case 12:
					lyric_of_day += "12 Drummers Drumming\n";
					break;
				default:
					System.err.println("發生了例外狀況：「first_present」變數在 1~12 範圍外！");
					System.err.println("程式必須異常終止，請向開發者回報此問題。");
					System.exit(-1);
				}
			}
			System.out.print(lyric_of_day);
			System.out.println();
		}
		
		return;
	}
	
}
