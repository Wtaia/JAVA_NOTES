/*
do-while循环的使用
一、循环结构的四个要素
1.初始化条件
2.循环条件  (boolean)
3.循环体
4.迭代条件

二、do-while循环的结构
1;
do{
	3;
	4;
}
while（2）;

执行过程：1--》3--》4--》2--》3--》4.。。

说明：至少执行一次循环体
*/

class DoWhileTest{
	public static void main(String[] args){


		//遍历100内的偶数

		int num =1;
		do{
			if(num%2 == 0){
						System.out.println(num);

			}

			num++;
		}while(num <= 100);
		
	}
}