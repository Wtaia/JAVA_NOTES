
class RandomTest{
	//如何获取一个随机数10-99
	public static void main(String[] args){
	int value = (int)(Math.random() * 90 + 10);//[0.0,1.0]--> [10.0,100.0）-->[10,99]
	//公式：[a,b]:(int)(Math.random()*(b-a+1)+a)

	System.out.println(value);
	}
}