/*
运算符六
三元运算符

（条件表达式？表达式1：表达式2）

1.条件表达式的变量是一个boolean类型
2.根据条件表达式的真或假，执行表达式，若为true执行表达式1，若为false则为表达式2
3.表达式1和表达式2要求是一致的
4.三运运算符可以嵌套使用




三元运算符与if-else转换
凡是可以使用三元运算符的地方都可以改写为if-else,反之不成立


如果既可以使用三元运算符又可使用if-else推荐使用三元运算符
*/

class SanYuan{
	
	public static void main(String[] args){

		//获取两个整数中的较大值

		int m = 12;
		int n =5;

		int max = (m > n ? m : n);
		System.out.println(max);

		double num = (m > n)?2:1.0;
		System.out.println(num);


		//****************************
		String maxStr = (m > n) ? "m大" : "n大"	;
		System.out.println(maxStr);

		String maxStr1 = (m > n) ? "m大" :((m == n) ? "m,n" : "n大") ;
		System.out.println(maxStr1);

		//获取三个数的最大值
		int n1 = 12;
		int n2 = 30;
		int n3 = -43;

		int max1 = (n1 > n2)?n1:n2;
		int max2 = (max1 > n3)?max1:n3;
		System.out.println(max2);

		//不推荐
		int max3 = (((n1 > n2)?n1:n2)>n3)?((n1>n2)?n1:n2):n3;
		System.out.println(max3);


		//if-else
		if(m>n){
			System.out.println(m);
		}else{
			System.out.println(n);
		}

	}
}