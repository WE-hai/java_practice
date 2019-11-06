public class VariableDemo {
	public static void main(String[] args) {
		int a;
		a = 13;
		System.out.println(a);
		
		System.out.println("===================");
		
		byte minByte = Byte.MIN_VALUE;
		byte maxByte = Byte.MAX_VALUE;
		System.out.println(minByte);
		System.out.println(maxByte);
		
		int minInt = Integer.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;
		System.out.println(minInt);
		System.out.println(maxInt);
		
		System.out.println("===================");
		
		
		short maxShort = Short.MAX_VALUE;
		short minShort = Short.MIN_VALUE;
		System.out.println(minShort);
		System.out.println(maxShort);
		short maxShortAdd1 = (short)(maxShort + 1);
		System.out.println(maxShortAdd1);
		short minShortSub1 = (short)(minShort - 1);
		System.out.println(minShortSub1);
		
		System.out.println("===================");
		
		// 演示命名的规则
		int A;
		// int _;			// 有警告
		int $;
		int 中文;
		
		// 演示错误的
		// int 9aaa;	数字开头了
		// int a 10;	出现空格了
		
		System.out.println("===================");
		
		// 演示字面量
		int bInt = 10;
		System.out.println(bInt);
		bInt = 0b101;
		System.out.println(bInt);
		bInt = 011;
		System.out.println(bInt);
		bInt = 0x3F;
		System.out.println(bInt);
		
		System.out.println("===================");
		
		/* 编译错误
		int aInt = 10L;
		System.out.println(aInt);
		*/
		long aLong = 10L;
		System.out.println(aLong);
		aLong = 0b101L;
		System.out.println(aLong);
		
		System.out.println("===================");
		// 不同类型的赋值，类型转换
		// int a = 10L;		// 编译错误
		long bLong = 10;
		System.out.println(bLong);
		System.out.println("===================");
		// 类型转换的特例
		// 针对字面量：范围内允许，否则不允许
		byte aByte;
		short aShort;
		aByte = 1;
		System.out.println(aByte);
		//aByte = 128;
		//System.out.println(aByte);
		aShort = 1;
		System.out.println(aShort);
		//aShort = 65536;
		//System.out.println(aShort);
		int cInt = 1;
		//aByte = cInt;
		//aShort = cInt;
		System.out.println("===================");
		double aDouble = 1E3;	// 1e3;
		System.out.println("===================");
		int dInt = 1;
		int eInt = 2;
		System.out.println(dInt / eInt);	// 0
		System.out.println(dInt * 1.0 / eInt);	// 0.5
		System.out.println("===================");
		char aChar;
		aChar = 'A';
		System.out.println(aChar);
		aChar = '中';
		System.out.println(aChar);
		aChar = '❤';	// emoji
		System.out.println(aChar);
		aChar = '\n';
		aChar = '\r';		// 回到行首
		aChar = '\t';		// 换行
		// windows 上		\r\n
		// linux/macOS		\n
	}
}







