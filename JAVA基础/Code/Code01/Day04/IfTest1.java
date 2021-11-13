/*
编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，
对它们进行排序(使用 if-else if-else),并且从小到大输出。

说明：
if-else可以嵌套使用
如果执行语句只有一行，大括号可以省略，但是不建议省略
*/
import java.util.Scanner;
class IfTest1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入三个整数：");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		int temp = 0;
/*
		//交换次序实现
		if(num1 > num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if(num1 > num3){
			temp = num1;
			num1 = num3;
			num3 = temp;
		}

		if(num2 > num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}

		System.out.println(num1 + "<" + num2 + "<" + num3);
*/


		if(num1 > num2){
			if(num3 >= num1){
				System.out.println(num2 + "<" + num1 + "<" + num3);
			}else if(num3 <= num2){
				System.out.println(num3 + "<" + num2 + "<" + num1);
			}else{
				System.out.println(num2 + "<" + num3 + "<" + num1);
			}
		}else{
			if(num3 >= num2){
				System.out.println(num1 + "<" + num2 + "<" + num3);
			}else if(num3 <= num1){
				System.out.println(num3 + "<" + num1 + "<" + num2);
			}else{
				System.out.println(num1 + "<" + num3 + "<" + num2);
			}
		}


	}
}