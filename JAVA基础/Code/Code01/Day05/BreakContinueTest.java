/*
break和continue关键字的使用
				使用范围					
break       switch-casse或循环结构		结束当前循环

continue    循环结构中					结束当次循环

return 结束方法
*/
class BreakContinueTest{
	public static void main(String[] args){
		for(int i = 1;i <= 10;i++){
			if(i % 4 == 0){
				break;
			}
			System.out.print(i);
		}
		System.out.println();

		for(int i = 1;i <= 10;i++){
			if(i % 4 == 0){
				continue;
			}
			System.out.print(i);
		}
		System.out.println();

		//******************************
		
		label:for(int i = 1;i <= 4;i++){
		
			for(int j = 1;j <= 10;j++){
				
				if(j % 4 == 0){
					//break;//默认跳出包裹此关键字最近的一层循环。
					//continue;

					//break label;//结束指定标识的一层循环结构
					continue label;//结束指定标识的一层循环结构当次循环
				}
				
				System.out.print(j);
			}
			
			System.out.println();
		}
	}
}