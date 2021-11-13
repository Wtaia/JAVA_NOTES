/*
基本数据类型之间的运算规则：
	前提：这里讨论除布尔外的其中基本数据类型的运算

	1.自动类型提升
	byte-->short-->int-->long-->float-->double
	特别的：byte,short,char三者做运算时全部提升为int
	short与char做运算提升为int
	byte与char做运算提升为int

	当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
	此时的容量大小指的是表示数的范围的大小，比如float的容量要大于long的容量

	2.强制类型转换


*/
class VariableTest2{
	public static void main(String[] args){

		byte b1 = 2;
		int i1 = 129;

		//byte b2 = b1 + i1;//编译不通过，从int转换到byte可能有损失
		int i2 = b1 + i1;
		long l1 = b1 + i1;
		System.out.println(i2);
		System.out.println(l1);

		float f1 = b1 + i1;
		System.out.println(f1);

		double d1 = b1 + i1;
		System.out.println(d1);

		short s1 = 123;
		double d2 = s1;

		System.out.println(d2);


		//************特别的******************

		char c1 = 'a';//97
		int i3 = 10;
		int i4 = c1 + i3;

		System.out.println(i4);

		short s2 = 10;
		int s3 = c1 + s2;

		System.out.println(s3);

		byte b2 =1;
		int s4 = c1 +b2;

		System.out.println(s4);
		//********************************
	}
}