
public class dentaku {

//すげぇおもしろい！！
//今までで一番面白かった！！
//家に帰ってから一人で作ってみよう！！
/*
 これはかんたんなプログラムだけれども、全てのプログラムはこういったかんたんな
 プログラムをより複雑にしていったものです。
 何か1つでもサンプルが作れるようになっているかどうかは大きな違いです！
 これまでの復習も兼ねて何かぜひ作ってみてください！
 →「じゃんけんゲーム」とかいいんじゃない？
 */
	

	public static void main(String[] args) {

//いままでの復習。
//電卓作成
//  ctrl + / で注釈をすぐ出せる
//プログラム実行時に指定した計算式をプログラム側で計算して結果を表示させる。
/*引数は3つ。数字、演算子、数字の3つ。
 * ↓
 * 2番目位の引数が演算子か確認
 * ↓
 * 1番目、3番目の引数が数値がどうかチェック		
 * 			数値以外が入力されたら、例外が発生する。
 * 			文字列→数値変換。valへの代入文をtry{}ブロックで囲む。
 * ↓
 * 計算結果を表示。
 * 			注意する点：割り算のときの0除算でエラー。
 */
		int val1 = 0;
		int val2 = 0;
		String ope;			//operator:演算子		
		int kekka;
		
		//ここコマンドライン引数。mainへの引数を与える
		//val1,val2,opeはコマンドライン引数で与えることになるのか？
		if(args.length !=3){	
			System.out.println("Usage :java dentaku 数値 演算子 数値");
			System.out.println("演算子は + - kake / の4つです");
			System.exit(0); 	//プログラム終了
		}
		
//文字列→数値への変換	
//かつコマンドライン引数へとargs[]たちで代入している。
//try追加
//発生する例外。発生したときの処理を書く。
		try{
			val1 = Integer.parseInt(args[0]);
			val2 = Integer.parseInt(args[2]);
		}catch(NumberFormatException e){
			System.out.println("Usage :java dentaku 数値 演算子 数値");
			System.out.println("数値でない値が入力されています");
			System.exit(0); 	//プログラム終了
		}
		ope = args[1];	//mainのデータがはStringゆえに文字列
		
		
//演算子の確認。+ - * /のどれかであるか確認。
//errFlag が true ならエラーメッセージを表示する。
//どれか一つでも equals が成り立ったならばerrFlag処理は行われない。
		/*
		boolean errFlag = true;  //変数errFlagの宣言
		if(ope.equals("+")){
			errFlag = false;
		}
		if(ope.equals("-")){
			errFlag = false;
		}
		if(ope.equals("kake")){
			errFlag = false;
		}
		if(ope.equals("/")){
			errFlag = false;
		}
		if(errFlag == true){
			System.out.println("演算子は + - kake / の4つです");
			System.exit(0); 	//プログラム終了
		}
		*/
		String opeStr[] = {"+", "-", "kake", "/"};
		boolean errFlag = true;
		for(int i = 0; i<4;  i++){
			if(ope.equals(opeStr[i])){
				errFlag = false;
			}
		}
		if(errFlag == true){
			System.out.println("演算子は + - kake / の4つです");
			System.exit(0); 	//プログラム終了
		}
		
//計算結果の表示
		if(ope.equals("kake")){		//変数.equalsメソッドは文字列に対する等号比較
			kekka = val1 * val2;
		}else if(ope.equals("+")){
			kekka = val1 + val2;
		}else if(ope.equals("-")){
			kekka = val1 - val2;
		}else{
			if(val2 == 0){
			errDisp("0除算");
			}
			kekka = val1 / val2;
		}
		
		System.out.println("入力された式は"+ val1 + " " + ope + " " + val2 + "です");
		System.out.println("計算結果は"+ kekka + "です");
	}
	
	private static void errDisp(String errStr){	//0除算のときエラー表記。
		System.out.println("Usage :java dentaku 数値 演算子 数値");
		System.out.println(errStr);
		System.exit(0); 	//プログラム終了
	}

}
