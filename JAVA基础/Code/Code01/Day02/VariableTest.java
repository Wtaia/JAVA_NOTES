/*
变量的使用
1.java定义变量的格式：数据类型 变量名 = 变量值；

2.说明：
	变量必须先声明后使用；
	变量都定义在其作用域内，在作用域内才是有效的；
	同一个作用域内不能定义同名变量；

 
*/

class VariableTest{
	public static void main(String[] args){
		//变量的定义
		int myAge = 12;
		//变量的使用
		System.out.println(myAge);	
		//编译错误：使用myNumber之前未定义
		// System.out.println(myNumber);



		//变量的声明
		int myNumber;


		//编译错误：使用myNumber之前未赋值
		//System.out.println(myNumber);
		//变量的赋值
		myNumber = 1001;

		System.out.println(myNumber);
		//作用域不适用
		//System.out.println(myClass);
	}

	public void method(){
		int myClass = 1;
	}
}