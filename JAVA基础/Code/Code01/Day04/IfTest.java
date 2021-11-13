/*
岳小鹏参加Java考试，他和父亲岳不群达成承诺：
如果：
成绩为100分时，奖励一辆BMW；
成绩为(80，99]时，奖励一台iphone xs max；
当成绩为[60,80]时，奖励一个 iPad；
其它时，什么奖励也没有。
请从键盘输入岳小鹏的期末成绩，并加以判断


说明：
1.else是可省略的
2.针对条件表达式
	如果多个条件表达式是“互斥”关系（没有交集的关系），那个判断和执行语句在上面无所谓；
	如果多个条件表达式有交集关系，需要考虑先后次序；
	如果多个条件表达式有包含关系，通常将范围小的声明在大的关系；
*/
import java.util.Scanner;
class IfTest{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入成绩：");
		int score = scan.nextInt();
		String prize;
		if(score == 100){
			prize = "BMW";
		}else if(score >80 && score <= 99){
			prize = "iphone 12";
		}else if(score >=60 && score <=80){
			prize = "ipad";
		}else{
			prize = "gun";
		}

		System.out.println("奖励一个" + prize);
	}
}