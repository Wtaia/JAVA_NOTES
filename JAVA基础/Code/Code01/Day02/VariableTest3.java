/*
强制类型转换：自动类型提升的逆运算
1.需要使用强转符（）
2.强制类型转换可能导致精度损失

*/

class VariableTest3{
	public static void main(String[] args){

	double d1 = 12.9;
	int i1 = (int)d1;//double强制转为int，不同于四舍五入，截断操作损失精度
	System.out.println(i1);


	long l1 = 123;
	short s2 = (short)l1;//没有精度损失

	//精度损失举例2
	int i2 = 128;
	byte b = (byte)i2;
	System.out.println(b);//-128
	}
}