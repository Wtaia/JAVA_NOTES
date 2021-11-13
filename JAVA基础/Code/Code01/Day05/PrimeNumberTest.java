/*
100以内所有的质数输出
质数：素数/水仙花数，只能被1和它本身整除的数

	-->从2开始到n-1结束，都不能被这个数整除
*/
class PrimeNumberTest{
	public static void main(String[] args){
		boolean isFlag = true;//标识i是否被除尽

		for(int i = 2;i <= 100;i++){//最小的质数为2
			for(int j = 2;j < i;j++){
				if(i % j == 0){
					isFlag = false;
					
				}
			}

			if(isFlag == true){
				System.out.println(i);
			}

			isFlag = true;//重置flag
		}


		
	}
}