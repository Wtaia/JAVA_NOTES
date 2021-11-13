/*
运算符五：位运算符（二进制）

结论：
位运算操作的都是整型变量
<<在一定范围内每向左移以为，相当于*2
>>在一定范围内每向右移一位，相当于/2
>>若最高位为1用1补，最高位为0用0补
>>>无符号右移，无论最高位为0或1都用0补


面试题：
最高效的2*8？
2 << 3或8 << 1
*/

class BitTest{
	public static void main(String[] args){
		int i=21;
		System.out.println("i << 2:" + (i<<2));//i*2*2
		System.out.println("i << 2:" + (i<<3));//i*2*2*2
		System.out.println("i << 2:" + (i<<26));//i*2^26
		System.out.println("i << 2:" + (i<<27));//超过限度


		int m=12;
		int n=5;
		System.out.println("m & n:"+(m&n));//只要一个是0就是0，两个都是1才为1
		System.out.println("m | n:"+(m|n));//只要有一个是1就为1，两个都是0才为2
		System.out.println("m ^ n:"+(m^n));//两个相同为1，不同为0
		//~取反就是0变1，1变0

		//练习：交换两个变量的值
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 = "+num1+";num2 = "+num2);

		//方式一：定义临时变量（推荐）
		int temp = 0;
		temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println("num1 = "+num1+";num2 = "+num2);

		//方式二：不用开辟临时变量，但是相加后可能超出存储范围而且有局限性只能数值型
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println("num1 = "+num1+";num2 = "+num2);

		//方式三：使用位运算符m = k ^ n = (m ^ n) ^ n,有局限性只能数值型
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		System.out.println("num1 = "+num1+";num2 = "+num2);


	}
}