/**
 *
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author internousdev
 *
 */
public class saiki {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//new クラス名。でインスタンス化＝実体＝オブジェクト。が作成されるっぽいな。あとはどのデータ型に格納するかどうか。

	String input = br.readLine();
	String param[] = input.split(" ");


	//問題4
		/**　再帰
		 * 入力として()を追加して行う。
		 * ()を入力したものは先に行う。
		 * param[]を使って行う
		 * 入力例：23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
		 * 多分 で区切ればparam[]に順番に入力される。
		 */
		/**
		 * paramの配列要素はどう確保するのか？
		 * 配列.length 要素数
		 * ArrayList.size ArrayListなどのCollectionを継承したクラスやメソッドにおいてその要素数を返す
		 * for(int i=0;i<param[].length;i++) で確保できる？b.readLine()の位置によりそうだが・・・？
		 *
		 * ( が入力→次以降を探しにいって
		 * 	 ( なら→aaa
		 * 	 ) なら→bbb	を実行する。ここもwhile()の繰り返し処理がいるっぽい。param[i],i++で(と)を.equalsで探す。
		 *	()の中身を先に計算して、置き換える？あるいはparam[]に再格納する？
		 *
		 * (がでるまで加算、減算。(を見つけた。→whileで)を探しに行く。ifで(が見つかったら ) を探しに行く
		 * while(param[i])で(を探しに行く感じじゃね？
		 *
		 * ・途中の計算結果は subtotal[] の配列に格納していく。
		 * 基本的には、+.-をwhileで探しに行く。
		 * →見つかった。
		 * →i-1,i+1の要素を確認。両方数値なら。演算子に対応して加算。減算。
		 * →結果を a に格納
		 * →演算子のとなりが(であった
		 * →現在の計算を一旦おいておく。
		 * →(のなかをwhileで上記と同じことをする。
		 * →if節で( か )で分岐させる。
		 * →次の演算子を見つけて。i-1,i+1も数値なら計算
		 * →
		 *
		 * 入力例：23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
		 */
	int i = 0;
	int subtotal[];
	int a1 = 0; //i-1の格納
	int a2 = 0; //i+1の格納

	keisan();
	String str[] = new String[param.length];
	}


//	if(!(param[i].equals("+")) && !(param[i].equals("-"))){
//		if(ff)
//	}
//メソッド。こいつを再帰的に呼び出す。1つの共通的なものを作る。
	public static void keisan(int i){

		for(int i=0;i<param.length;i++){ //いるのか？
			if(param[i].equals("+") || param[i].equals("-")){
				if(param[i+1].equals("(")){
					i=i+1;
					keisan(i);
				}else{
					param[i+1] = Integer.parseInt(param[i-1]) + Integer.parseInt(param[i+1]);
				}
			}
		}
	}

//keisanメソッドを作って。再帰的に利用する？
//param[]をそもそも使えるか？
//()の中身を配列に格納する？→優先的に計算。（を見つけたら、）までの文字列を配列に格納する？
	public void kakko(int i){	//iの初期値は0。
		while(!(param[i].equals("(")){	//(が出るまで検索
			i++;
		}
		int cash1 = i; //param配列のi番目を一時的に格納。上記のi++と同値
		while(!(param[i].equals(")"))){	//)が出るまで検索。
			if(param[i].equals("(")){
				kakko(i);
			}
			i++;	//ここの条件式はfalseになった param[i]が ) を保持。
		}
		int cash2 = i;
			//param[5]= (  ,param[9]= ), とする [6]=4 [7]=+ [8]=32 数字と演算子で奇数？
			//それとも、 -の直後に( ?
		for(int j=cash1+1;j<cash2;j++){
			if(param[j].equals("+")){
				int c1 = Integer.parseInt(param[j-1]);
				int c2 = Integer.parseInt(param[j+1]);
				int c3 = c1 + c2;	//計算
				param[j+1] = c3;	//格納	//結局param内部の値は削除されないから別の配列にいれるしかないだろ。
			}else if(param[j].equals("-")){
				int c1 = Integer.parseInt(param[j-1]);
				int c2 = Integer.parseInt(param[j+1]);
				int c3 = c1 - c2;	//計算
				param[j+1] = c3;
			}
		}
		//return intかstring で(***)の結果を 返すべきなのか？
		//多分ここで配列に格納	return c3;
	}
	
	
	


}	//classの }
