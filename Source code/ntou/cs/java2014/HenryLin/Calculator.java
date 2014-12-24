package ntou.cs.java2014.HenryLin;
/** @file Calculator.java
@brief 1-1 作業 - Calculator 物件類別的來源程式碼
@author 林博仁(09957010) <Henry.Lin.Taiwan@gmail.com>
@copyright 本來源程式碼以 General Public Licence 授權條款第 3 版或其任一更近期版本釋出 */

import java.util.Scanner;

/** @brief Calculator 物件類別 */
public class Calculator{
	/** 比較 3 個數字的方法 */
	public static void compareThreeNumbers(){
		int first_number, second_number, third_number;
		first_number = second_number = third_number = -12345;
		
		Scanner standard_input_scanner = new Scanner(System.in);
		System.out.print("請輸入第一個整數數字：");
		first_number = standard_input_scanner.nextInt();
		System.out.print("請輸入第二個整數數字：");
		second_number = standard_input_scanner.nextInt();
		System.out.print("請輸入第三個整數數字：");
		third_number = standard_input_scanner.nextInt();
		standard_input_scanner.close();
		
		/* 計算並輸出結果 */{
			/* 和 */
			int sum = -12345;
			
			/* 乘積 */
			int product = -12345;
			
			/* 平均數 */
			int average = -12345;
			
			/* 目前為止的最小數 */
			int current_minimum = -12345;
			
			/* 目前為止的最大數 */
			int current_maximum = -12345;
			
			/* 判斷最大數與最小數 */{
				if(first_number >= second_number){
					current_maximum = first_number;
					current_minimum = second_number;
				}else{/* first_number < second_number */
					current_maximum = second_number;
					current_minimum = first_number;
				}
				
				if(current_maximum < third_number){
					current_maximum = third_number;
				}
				if(current_minimum > third_number){
					current_minimum = third_number;
				}
			}
			
			/* 求出和、乘積和平均數 */{
				sum = first_number + second_number + third_number;
				product = first_number * second_number * third_number;
				average = sum / 3;
			}
			
			/* 輸出結果 */
			System.out.format("於 %d、%d 和 %d 中\n", first_number, second_number, third_number);
			System.out.format("最大值為 %d\n", current_maximum);
			System.out.format("最小值為 %d\n", current_minimum);
			System.out.format("和為 %d\n", sum);
			System.out.format("乘積為 %d\n", product);
			System.out.format("平均數為 %d\n", average);
		}
		return;
	}
}

