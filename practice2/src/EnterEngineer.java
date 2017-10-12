
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EnterEngineer {


	public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//new クラス名。でインスタンス化＝実体＝オブジェクト。が作成されるっぽいな。あとはどのデータ型に格納するかどうか。

	String input = br.readLine();
	String param[] = input.split(" ");
	//こいつがsplit keyを入力するたびに、param[]の要素が追加される？
		//" "のため、空白(ダブルクーテションの中の値)を入力すると、入力値を分解しparam[]の要素に格納
		//paramは配列のため、paramの各要素に分解されるまでの値が格納される。続けて連続で格納できるっぽい。
	/*
	for(int i=0;i<10;i++){
		System.out.println(param[i]);
	}
	*/

//1
//	int a;
//	int b;
//	a=Integer.parseInt(param[0]);
//	b=Integer.parseInt(param[1]);
//	System.out.println(a+b);


//2
//	/**
//	 * 入力する数値は整数のみ
//	 * 入力する演算記号は + - *  / を使う。
//	 * 演算は1回のみ行う。
//	 * 商を求める際は、あまりを...Nとする。
//	 */
//	//param[]の[]に要素の数値を入れるとそこに格納される。
//	int num1 = Integer.parseInt(param[0]);
//	String ch = param[1];
//	int num2 = Integer.parseInt(param[2]);
//
//	if(ch.equals("+")){
//		System.out.println(num1+"+"+num2 + "=" +(num1 + num2));
//	}else if(ch.equals("-")){
//		System.out.println(num1+"-"+num2 + "=" +(num1 - num2));
//	}else if(ch.equals("*")){
//		System.out.println(num1+"*"+num2 + "=" +(num1 * num2));
//	}else if(ch.equals("/")){
//		if(num2 != 0){
//		System.out.println(num1+"/"+num2 + "=" +(num1 / num2)+"...N");
//		}else{
//			System.out.println("0除算。許可できません");
//		}
//	}

//3
//	/**
//	 * 複数回の演算を行う場合の記述
//	 * param[]だとよくわかんねぇな。param = br.readLine().split(" ");
//	 * 基本形は
//	 * int aで
//	 * a = a+n; nは計算の結果。a+nでもないのか？ +の部分は入力された演算子でないとだめか
//	 * すると
//	 * 数値を格納するための配列1
//	 * 演算子を格納するための配列2？を作る
//	 * or
//	 * １つの配列の　偶数列→数値
//	 * 				 奇数列→演算子でいいか。
//	 * 	param[]
//	 * まず最初に入力値の数を取得しないと行けない。
//	 * かつ入力された入力値はかならず偶数でないといけない。
//	 * forを使って、配列に格納していく。←すでにされている？
//	 * 数字に直す際の int型を格納する配列も必要？要素数はparamの要素数の/2
//	 *
//	 *
//	 * 処理的にはまとめないほうがやりやすい。かつ配列に格納しないほうがやりやすい。
//	 *
//	 * switch文も可能
//	 */
//	int n1=0;
//	int n2=0;
//	int count=1;
//	String str;
//	int a=0; //各合計
//	while(count!=0){
//		System.out.println("数値1を入力");
//		n1 = Integer.parseInt(br.readLine());
//		System.out.println("+,-,*,/のどれかを入力");
//		str = br.readLine();
//		if(count==1){
//			System.out.println("数値2を入力");
//			n2 = Integer.parseInt(br.readLine());
//			if(str.equals("+")){
//				a = n1+n2;
//			}else if(str.equals("-")){
//				a = n1-n2;
//			}else if(str.equals("*")){
//				a = n1*n2;
//			}else if(str.equals("/")){
//				a = n1/n2;
//			}
//			System.out.println(a);
//			System.out.println("結果に対して計算を続けるなら2を入力");
//			System.out.println("結果を初期化して再計算なら1を入力");
//			System.out.println("計算を終わるなら0を入力");
//			count = Integer.parseInt(br.readLine());
//		}else{
//			if(str.equals("+")){
//				a = a+n1;
//			}else if(str.equals("-")){
//				a = a-n1;
//			}else if(str.equals("*")){
//				a = a*n1;
//			}else if(str.equals("/")){
//				a = a/n1;
//			}
//			System.out.println(a);
//			System.out.println("結果に対して計算を続けるなら2を入力");
//			System.out.println("結果を初期化して再計算なら1を入力");
//			System.out.println("計算を終わるなら0を入力");
//			count = Integer.parseInt(br.readLine());
//		}
//	}
//	System.out.println("最終結果は: "+a);



//3
	/**
	 * この考え方に俺は a + bの計算結果をまとめるように考えていたが
	 * 左から順番に sum = a, + b , -c, + d, -fのように区切ると分かりやすい
	 * これは回答例の方法だ。
	 */
	//大成功。
	String type = "no"; //演算子を格納。
	int sum = 0; 	//数字ごとの合計値を格納
	int num = 0; 	//param[]のint変換を格納
	for(int i=0;i<param.length;i++){	//paramの数だけ繰り返す
		if(param[i].equals("+") || param[i].equals("-")){
			type = param[i];
		}else{
			num = Integer.parseInt(param[i]);
			if(type.equals("+")){
				sum = sum + num;
			}else if(type.equals("-")){
				sum = sum - num;
			}else{
				sum = num;	//一番最初のparam[0]の保存。
			}
		}
	}
	System.out.println("計算結果は:"+sum);

//4
	/**
	 * (が出るたびにtype3のメソッドを実行するかたちになるのでは？
	 */
	for(int i=0;i<param.length;i++){
		if(param[i].equals("(")){
			String kakko = "("; // )は探さなくていいのかも
		}
	}






	}//mainメソッド

	//23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
	public void keisan(int kurikaesi){
		String type="reset";	//初期化
		int sum=0;			//計算値の格納
		int num=0;			//配列の各値の格納
		String kakko = null; //kakkoが存在するか
		for(int i=kurikaesi;i<param[i].length();i++){
			if(param[i].equals("+") || param[i].equals("-")){
				type = param[i];
			}else if(param[i].equals("(") || param[i].equals(")")){
				if(param[i].equals("(")){
					kakko = "(";
					kurikaesi = i++;
					keisan(kurikaesi);
				}else if(param[i].equals(")")){
					
				}
					//(の中の合計値を先に sum に入れたい。
			}else{
				num = Integer.parseInt(param[i]);
				if(type.equals("+")){
					sum = sum + num;
				}else if(type.equals("-")){
					sum = sum - num;
				}else{
					sum = sum + num; //初期
				}

			}
		}
	}
}
