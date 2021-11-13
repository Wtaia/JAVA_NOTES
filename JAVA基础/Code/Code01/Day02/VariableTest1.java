/*
Java定义的数据类型

一、按照数据类型来分

	基本数据类型：
		整型：byte\short\int\long
		浮点型：float\double
		字符型：char
		布尔型：boolean
	引用数据类型：
		类（class）
		接口（interface）
		数组（array）
二、变量在类中声明的位置
	成员变量
	局部变量
*/




class VariableTest1{
	public static void main(String[] args){
	// System.out.println("HelloWorld");

	// 1.整型：byte（1字节=8bit，-128~127）\short（2字节）\int（4字节）\long（8字节）
	
	byte b1=12;
	byte b2=-128;
	//b2 = 128;//编译失败	
	System.out.println(b1);
	System.out.println(b2);

	//声明long类型变量，必须以“l”或“L”结尾
	//定义整型变量通常用int型

	short s1=128;
	int i1=1234;
	long l1=34111233;
	System.out.println("l1");

	//2.浮点型：float（4字节），double（8字节）
	double d1=123.3;
	System.out.println(d1+1);

	float f1=12.3f;
	//定义float类型变量时，变量要以“f”或“F”结尾
	System.out.println(f1);

	//通常定义浮点型变量时使用double


	//3.字符型：char(1字符=2字节)
	//声明字符型变量通常使用一对‘’,内部只能写一个字符
	char c1='a';
	String hhh1="abc";
	System.out.println(c1);
	System.out.println(hhh1);
	
	char c2='1';
	char c3='中';
	char c4='*';
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(c4);


	//char表示方式：1）声明一个字符，2）转义字符(\n,\t等)，3）直接使用Unicode值来表示字符型常量
	char c5='\t';
	System.out.print("hello"+c5);
	System.out.println("world");

	char c6='\u0043';//Unicode编码集
	System.out.println(c6);

	//4.布尔型：boolean
	//只能取两个值中的一个，true，false
	//通常在条件判断或循环结构中使用
	boolean bb1=true;
	System.out.println(bb1);

	boolean isMarried = true;
	if(isMarried){
		System.out.println("你就不能参加单身派对了\\n123");//转义字符用一个反斜线\
	}else{
		System.out.println("你可以参加单身派对");
	}
	}
}