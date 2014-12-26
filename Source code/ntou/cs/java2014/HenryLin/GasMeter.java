/** @file GasMeter.java
    @brief 1-3 作業 GasMeter 物件類別實作
    @author 林博仁(09957010) <Henry.Lin.Taiwan@gmail.com>
    @copyright 本來源程式碼以 General Public Licence 授權條款第 3 版或其任一更近期版本釋出 */
package ntou.cs.java2014.HenryLin;

/* 用於讀取使用者的輸入 */
import java.util.Scanner;

/** 
 * @brief 車輛耗油計算器物件類別
 */
public class GasMeter {
	/**
	 * @brief 向使用者讀取資料並計算每英里耗油量的子程式
	 */
	public static void readAndEvaluateMilesPerGallons(){
		/** 
		 * 本次行駛英里數（迴圈終止值：-1）
		 * @todo 理論上 current_miles 變數資料行態改成浮點數比較實際，終止值可改為任意負數值（因作業要求不修正） */
		int current_miles = 0;
		
		/* 本次耗油量（單位：加侖） */
		float current_gasoline_consumption;
		
		/* 總行駛英里數 */
		float total_miles = 0;
		
		/* 總耗油量（單位：加侖） */
		float total_gasoline_consumption = 0;
		
		Scanner standard_input_scanner = new Scanner(System.in);
		
		/** ## 實作細節<br>Implementation details */
		/** 1. 讀取使用者輸入 */
		System.out.print("請輸入本次行駛哩數（輸入 -1 以結束程式）：");
		current_miles = standard_input_scanner.nextInt();
		if(current_miles == -1){
			System.exit(0);
		}
		System.out.print("請輸入本次耗油量（單位：加侖）：");
		current_gasoline_consumption = standard_input_scanner.nextFloat();
		
		/** 2. 進入處理、輸入迴圈 */
		while(current_miles != -1){
			/** * 更新合計值 */ 
			total_miles += current_miles;
			total_gasoline_consumption += current_gasoline_consumption;
			
			/** 	* 輸出本次耗油度 */
			System.out.format("MPG this tankful: %.2f\n", current_miles / current_gasoline_consumption);
			
			/** 	* 輸出總耗油度 */
			System.out.format("Total MPG: %.2f\n", total_miles / total_gasoline_consumption);
			
			/** 	* 再次讀取使用者輸入 */
			System.out.print("請輸入本次行駛哩數（輸入 -1 以結束程式）：");
			current_miles = standard_input_scanner.nextInt();
			System.out.print("請輸入本次耗油量（單位：加侖）：");
			current_gasoline_consumption = standard_input_scanner.nextFloat();
			
		}
		
		standard_input_scanner.close();
	}
}
