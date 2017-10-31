import java.io.IOException;
import java.util.Scanner;

public class pr1 {

	public static void main(String[] args) throws IOException{
		System.out.println("Hello World");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
			//Scannerクラスのnextメソッドにおけるトークンの区切りは、スペースです。
		System.out.println("test "+num);

	/**
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//System.inは標準入力と呼ばれる。キーボードからの入力のこと。
		String str = br.readLine();
		System.out.println("Scanner ClassとBufferedReaderClass(new InputStreamReader))Classは何が違うのだろう"+str);
	*/

		for(int i=0;i<num;i++){
			System.out.print("*");
		}

		if(num==0){
			System.out.println("0");
		}else if(num>0){
			System.out.println("正");
		}else{
			System.out.println("負");
		}

		int sum=0;
		for(int i=1;i<10;i++){
			sum = sum + i;
		}
		System.out.println(sum);

		int[] array = {10, 4, 64, 255, 39};
		//index1を他の全てと比較。小さいなら入れ替える。
		//index n まで繰り返す。
		//index0が最小値。index n が最大値になるように並べ替えよ。
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i] > array[j]){
					int a = 0;
					a = array[i];
					array[i] = array[j];
					array[j] = a;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
