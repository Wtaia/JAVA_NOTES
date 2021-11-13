class VariableTest4{
	public static void main(String[] args){
	//1.编码情况1
	long l = 123213;//整型默认为int
	
	System.out.println(l);

	long l1 = 213333333333333333l;//不加l被认定为int
	System.out.println(l1);

	float f1 = 12.3f;//浮点型默认为double
	System.out.println(f1);


	//2.编码情况2
	byte b = 12;
	//byte b1 = b + 1;//整型常量默认为int，浮点型常量默认为double
	//float f1 = b + 12.3;//编译失败
	}
}