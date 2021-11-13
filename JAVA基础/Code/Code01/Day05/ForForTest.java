/*
嵌套循环的使用
1.嵌套循环：将一个循环结构A声明在另一个循环结构B的循环体中，构成嵌套循环
2.外层循环，内层循环
3.
	1>内层循环结构遍历一遍，只相当于外层循环体执行一次
	2>假设外层循环需要执行m次，内层循环需要执行n次，此时内层循环体执行m*n次

4.外层循环控制行数，内层循环控制列数
*/

class ForForTest{
	public static void main(String[] args){
		//*****
		for(int i=1;i<=6;i++)
		{
			System.out.print("*");
		}
		System.out.println();


		/*
		******
		******
		******
		******
		*/
		for(int j = 0;j<=4;j++){
			for(int i=1;i<=6;i++){
				System.out.print("*");

			}
			System.out.println();
		}



		/*				j（行号）   i（*的个数）
		*					1			1	
		**					2			2
		***					3			3
		****				4			4
		*****				5			5
		*/

		for(int j = 0;j<=5;j++){
			for(int i=1;i<=j;i++){
				System.out.print("*");
			}
			System.out.println();
		}


		/*
		****
		***
		**
		*
		*/
		for(int j = 1;j<=4;j++){
			for(int i=1;i<=5-j;i++){
				System.out.print("*");
			}
			System.out.println();
		}


		/*
				* 
			   * * 
			  * * * 
			 * * * * 
			* * * * * 
			 * * * * 
			  * * * 
			   * * 
			    * 
		*/
		//上半部分
		for(int j = 1;j<=5;j++){
			for(int i=1;i<=5-j;i++){
				System.out.print(" ");
			}
			for(int i=1;i<=j;i++){
				System.out.print("* ");
			}
			System.out.println();
		}
		//下半部分
		for(int j = 1;j<=4;j++){
			for(int i=1;i<=j;i++){
				System.out.print(" ");
			}
			for(int i=1;i<=5-j;i++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}