/*
While循环的使用：
一、循环结构的四个要素
1.初始化条件
2.循环条件  (boolean)
3.循环体
4.迭代条件

二、while循环的结构
1；
while（2；）{
	3；
	4；
}

说明：小心不要忘记迭代条件，
	可能导致死循环，
	for循环与while循环是可以相互转换的，初始换条件的作用域不同
算法：有限性

执行过程：1--》2--》3--》4--》2--》3--》4。。。。。。
*/

class WhileTest {
	public static void main(String[] args){

		//遍历100内的所有偶数
		int i = 1;//全局变量
		while(i <= 100){
			if(i % 2 == 0){
				System.out.println(i);
			}
			i++;
		}

		System.out.println(i);//101
		
	}
}