/*
For循环的使用
一、循环结构的四个要素
1.初始化条件
2.循环条件  (boolean)
3.循环体
4.迭代条件
二、for循环的条件

for(1;2;4){
	3;
}

执行过程：1-->2-->3-->4-->2-->3-->4-->2......-->2
*/

class ForTest{
	public static void main(String[] args){

		for (int i = 1;i <= 5;i++) {
			System.out.println("HelloWorld");
		}

		//练习：
		int num = 1;
		for(System.out.println('1');num <= 10;System.out.println('3'),num++){
			System.out.println('2');
		}

		//遍历100内的偶数,输出所有偶数的和
		int sum = 0;
		int count = 0;//记录偶数的个数
		for (int i = 1;i <= 100;i++) {
			if(i%2==0){
				System.out.println(i);
				sum += i;
				count++;
			}
		}
		System.out.println(sum);
		System.out.println(count);

		
	}
}