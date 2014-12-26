/** @file EmployeeTest.java
    @brief 1-2 作業 Employee 物件類別測試程式
    @author 林博仁(09957010) <Henry.Lin.Taiwan@gmail.com>
    @copyright 本來源程式碼以 General Public Licence 授權條款第 3 版或其任一更近期版本釋出 */
package ntou.cs.java2014.HenryLin;

/** @brief EmployeeTest 物件類別 */
public class EmployeeTest{
	/**@brief  Java 程式進入點(entry point)
	 *  
	 *  @param args 從命令列傳進來的命令參數 */
	public static void main(String[] args){
		System.out.println("1-2 作業 Employee 類別測試程式");
		System.out.println("林博仁(09957010) <Henry.Lin.Taiwan@gmail.com> © 2014");
		System.out.println("發現任何軟體問題請至本專案的議題追蹤系統建檔回報：");
		System.out.println("https://github.com/Vdragon/NTOUCS_Java_Programming_Homework_Opensource_Project/issues");
		System.out.println("---------------------------------------------------------");
		Employee bob_jones = new Employee("俊賢", "陳", 34500);
		Employee susan_baker = new Employee("佳燕", "歐陽", 37809);
		
		System.out.format(
			"第一位員工：%s %s；年薪：%.2f\n", 
			bob_jones.getFirstName(), 
			bob_jones.getLastName(), 
			bob_jones.getSalary()
		);
		
		System.out.format(
			"第二位員工：%s %s；年薪：%.2f\n", 
			susan_baker.getFirstName(),
			susan_baker.getLastName(), 
			susan_baker.getSalary()
		);
		
		System.out.println("老闆：「所有員工加薪 10%。」");
		bob_jones.setSalary(bob_jones.getSalary() * 1.1);
		susan_baker.setSalary(susan_baker.getSalary() * 1.1);
		
		System.out.format(
				"第一位員工：%s %s；年薪：%.2f\n", 
				bob_jones.getFirstName(), 
				bob_jones.getLastName(), 
				bob_jones.getSalary()
			);
			
			System.out.format(
				"第二位員工：%s %s；年薪：%.2f\n", 
				susan_baker.getFirstName(),
				susan_baker.getLastName(), 
				susan_baker.getSalary()
			);
		return;
	}
}
