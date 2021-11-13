/*
分支结构二：switch-case

1.格式
switch(表达式){
	case 常量1：执行语句1；//break;
	case 常量2：执行语句2；//break;
	...
	default:执行语句n;//break;
}
2.说明：
根据switch表达式中的值，依次匹配各case值，一旦匹配成功则进入case的执行语句。
当执行完当前语句后会继续执行，知道遇到break或程序结束。
break可以表示在switch-case结构中，表示跳出当前结构。
switch结构中的表达式，只能是byte\short\char\int\枚举类型(JDK5.0)、String类型(JDK7.0)
case之后只能声明一个常量，不能声明一个范围。
break关键字是可选的。
default相当于if-else中的else。default是可选的，位置是灵活的。
*/

class SwitchCaseTest{
	public static void main(String[] args){
		int number = 2;
		switch(number){
			case 0:System.out.println("zero");break;
			case 1:System.out.println("one");break;
			case 2:System.out.println("two");break;
			default:System.out.println("other");
		}

		String season = "summer";
		switch (season) {
		case "spring":
		System.out.println("春暖花开");
		break;
		case "summer":
		System.out.println("夏日炎炎");
		break;
		case "autumn":
		System.out.println("秋高气爽");
		break;
		case "winter":
		System.out.println("冬雪皑皑");
		break;
		default:
		System.out.println("季节输入有误");
		break;
}
	}
}