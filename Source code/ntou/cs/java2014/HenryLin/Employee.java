/** @file Employee.java
    @brief 1-2 作業 Employee 物件類別測試程式
    @author 林博仁(09957010) <Henry.Lin.Taiwan@gmail.com>
    @copyright 本來源程式碼以 General Public Licence 授權條款第 3 版或其任一更近期版本釋出 */
package ntou.cs.java2014.HenryLin;

/** @brief 描述員工的物件類別 */
public class Employee {
	/** @brief 員工名字 */
	private String first_name = null;
	/** @brief 員工姓氏 */
	private String last_name = null;
	/** @brief 員工年薪 */
	private double salary = 12345.12345;
	
	public Employee(String first_name, String last_name, double salary){
		this.first_name = first_name;
		this.last_name = last_name;
		if(salary < 0){
			this.salary = 0;
		}else{
			this.salary = salary;
		}
	}
	
	/** @brief 取得名字
	 * @return 名字
	 */
	public String getFirstName(){
		return first_name;
	}
	
	/** @brief 設定名字
	 * 
	 * @param first_name 名字
	 */
	public void setFirstName(String first_name){
		this.first_name = first_name;
		return;
	}
	
	/** @brief 取得員工姓氏
	 * @return 姓氏
	 */
	public String getLastName(){
		return last_name;
	}

	/** @brief 設定員工姓氏
	 * @param last_name 姓氏
	 */
	public void setLastName(String last_name){
		this.last_name = last_name;
		return;
	}
	
	/** @brief 取得員工年薪
	 * @return 年薪
	 */
	public double getSalary(){
		return salary;
	}

	/** @brief 設定員工年薪
	 * @param salary 年薪
	 */
	public void setSalary(double salary){
		this.salary = salary;
		return;
	}
}
