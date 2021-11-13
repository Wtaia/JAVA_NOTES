/*
String类型变量的使用
1.String属于引用数据类型，翻译为 字符串
2.声明String类型变量时，使用一对“”
3.String可以和8种基本数据类型变量做运算，且运算只能是连接运算  “+”
4.运算结果仍然是String类型
*/


class StringTest{
	public static void main(String[] args){
		String s1 = "Hello World";
		System.out.println(s1);

		String s2 = "a";
		String s3 = "";//String类型可以为空

		//char c = '';//编译错误：char类型不能为空,有且只有一个

		System.out.println(s3);
		//*********************
		int num = 1001;
		String numStr = "学号：";
		String info = numStr + num;//连接运算
		System.out.println(info);
		boolean b1 = true;
		String info1 = info + b1;
		System.out.println(info1);


		//练习一
		char c = 'a';//a:97  A:65
		int num1 = 10;
		String str = "hello";
		System.out.println(c + num1 + str);//107hello
		System.out.println(c + str + num1);//ahello10
		System.out.println(c + (num1 + str));//a10hello
		System.out.println((c + num1) + str);//107hello
		System.out.println(str + num1 + c);//hello10a

		//练习二
		//*	*
		char c1 = '*';
		System.out.println(c1+'\t'+c1);
		System.out.println('*' + '\t' + '*');//char对应ascll自动转换为int
		System.out.println('*' + "\t" + '*');//“\t”表示String
		System.out.println("*" + '\t' + '*');
		System.out.println('*' + ('\t' + '*'));
		

	}
}