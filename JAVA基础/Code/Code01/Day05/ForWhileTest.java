/*
从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入
为0时结束程序。

说明：
1 for(;;)
2 while(true)
3 结束循环： 
	循环条件返回false
	循环体中执行break
*/

import java.util.Scanner;
class ForWhileTest{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int z = 0,f = 0;

		//for循环
		/*for(int i = 1;i != 0;){
			System.out.println("please input a int number:");
			
			int input = scan.nextInt();
			if(input > 0){
				z++;
			}else if(input < 0){
				f++;
			}else{
				i = 0;
			}
		}
		*/
		

		//while循环
		while(true){
			System.out.println("please input a int number:");
			
			int input = scan.nextInt();
			if(input > 0){
				z++;
			}else if(input < 0){
				f++;
			}else{
				break;
			}
		}

		System.out.println("正数："+z);
		System.out.println("负数："+f);
	}	
}