/*
方式二

100以内所有的质数输出
质数：素数/水仙花数，只能被1和它本身整除的数-->从2开始到n-1结束，都不能被这个数整除	
*/


class PrimeNumberTest2{
	public static void main(String[] args){
		boolean isFlag = true;//标识i是否被除尽
		int count = 0;
		//获取当前时间距离1970.01.01 00：00：00的毫秒数
		long start = System.currentTimeMillis();

		label:for(int i = 2;i <= 100000;i++){//最小的质数为2,遍历
			
			for(int j = 2;j <= Math.sqrt(i);j++){//j被i去除

				if(i % j == 0){
					continue label;
				}
			}
			//执行到此处的都是质数
			count++;
			

			isFlag = true;//重置flag
		}

		//获取当前时间距离1970.01.01 00：00：00的毫秒数
		long end = System.currentTimeMillis();
		System.out.println("一共有多少个质数：" + count);
		System.out.println("所花费的时间：" + (end - start));//20105 -2437 -190
	}
}