/*
题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
比如：12和20的最大公约数是4，最小公倍数是60。
说明：break关键字的使用
*/

import java.util.Scanner;
class ForTest3{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input m:");
		int m = scan.nextInt();
		System.out.println();

		System.out.print("Please input n:");
		int n = scan.nextInt();
		System.out.println();

		
		int max = 0,min = 0;
		if(m>n){
			max = m;
			min = n;
		}else{
			max = n;
			min = m;
		}

		//最大公约数
		int yueshu = 0;
		for(int i = max;i > 0;i--){
			if(m % i == 0 && n % i == 0){
				yueshu = i;
				break;
			}
			
		}

		//最小公倍数
		int beishu = 0;
		for(int i = min;i <= m * n;i++){
			if(i % m == 0 && i % n == 0){
				beishu = i;
				break;
			}
			
		}

		System.out.println("最大公约数:"+yueshu);
		System.out.println("最小公倍数:"+beishu);
	}
}