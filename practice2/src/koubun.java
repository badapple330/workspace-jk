import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/**
 * @author internousdev
 *
 */
public class koubun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//1
		System.out.println(args.length);
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}


//2
		try{
			String test = null;	//nullメソッドでNullPointerException
			int test2;	//引数string にint型いれてClassCastException
			test = test.substring(0);	//メソッドならなんでもいい。引数か元変数がnullならぬるぽ

		}catch(NullPointerException e){
			e.printStackTrace();	//こいつは
				/**
				 * 	at Hoge.badMethod(Hoge.java:14)
					at Hoge.main(Hoge.java:6)
					を表示させるメソッド。
				 */
			System.out.println("メソッドの引数がnullです");
			System.exit(0);
		}
//OutOfBoundsException
		try{
			int[] str = new int[10];
			for(int i=0;i<str.length+1;i++){
				str[i] = i;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("ArrayIndexOutOfBoundsException。配列の要素数を超えています");
		}
//ClassCastException 互換性の無いオブジェクト型の変換
//String型を Integer.parseIntで変換しようとするとなるっぽい
		try{
			Object obj = "oppai";
				//Object型はオブジェクト型の変数の値であるならなんでも代入可能。Stringもintも
				//ゆえにObject方はInteger型に変換も可能で、コンパイルエラーも吐かぬが…。
				//実際に格納されているのはString型でInteger型に変更不可
			Integer number = (Integer)obj;
		}catch(ClassCastException e){
			e.printStackTrace();
			System.out.println("ClassCastException。互換性のない変換です");
		}


		ArrayList<String> list = new ArrayList<String>();	//初期要素数は10こ
		for(int i=0;i<list.size();i++){		//ただの配列:list.length  ArrayList:list.size()
			list.add(args[i]);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list);
		}

//Q3
		List<String> params = Arrays.asList(args);
		//List<データ型> = Arrays.asList(配列);
		//配列の変数 args というString配列をList型に変換する処理。
		//args[1],[2],[3]…はargsに格納されている

	}

	public static void test(String test){
		System.out.println(test);
	}

}
