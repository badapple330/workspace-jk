
public class dentaku2 {

	public static void main(String[] args) {
//1コマンドライン引数を適用できるような文。変数の作成。文字列→数値変換
//2演算子の確認
		/*
		 * ここどうすんだっけ？
		 * tasu hiku kake waruのみopeに入力できる
		 */
//3数値の確認
		/*
		 * 数値の確認どうやんだっけ？
		 * 整数のみおｋ？←これわかんね？
		 */
//4実行計算式の出力
//5エラーチェック。0除算。整数エラー表示
/*
 * 自力で作ったけど意外と動くなぁ。
 * あとコマンドライン引数の数による制御。
 */

//変数
		int val1 = 0;
		int val2 = 0;
		String ope;
		boolean errFlag = true;		//演算子を入力制限。errFlag = trueならエラー判定。
		
//コマンドライン引数の数でエラーチェック　（変数代入さきにするとエラー出るんだよなぁ。順番が大事ってことだ）
		if(args.length !=3){		//args.length 　配列変数argsの長さの値。[]はいらない
			System.out.println("コマンドライン引数エラー。");
			System.out.println("数値1 演算子 数値2 の形で入力");
			System.exit(0);
		}
//文字列→数値変換。変数にコマンドライン引数代入
		try{
		val1 = Integer.parseInt(args[0]);
		val2 = Integer.parseInt(args[2]);
		}catch(NumberFormatException e){
			System.out.println("数値には整数を入力してください");
			System.exit(0);
		}

		ope = args[1];	//演算子
/*この変数がコマンドライン引数の数参照より前だと
 * なんかバグる。なんでや？
 */
		
//opeに分岐
//結果の出力
//tasu hiku kake waruをStringでまとめてもいい
		System.out.println("java クラス名 数値1 演算子 数値2 の形で入力");
		if(ope.equals("tasu")){
			errFlag = false;
			System.out.println(val1+ " " + ope + " " + val2 + "= "+(val1 + val2));
		}else if(ope.equals("hiku")){
			errFlag = false;
			System.out.println(val1+ " " + ope + " " + val2 + "= "+(val1 - val2));
		}else if(ope.equals("kake")){
			errFlag = false;
			System.out.println(val1+ " " + ope + " " + val2 + "= "+(val1 * val2));
		}else if(ope.equals("waru")){
			if(val2 == 0){
				System.out.println("0除算エラー");
				System.exit(0);
			}
			errFlag = false;	
			System.out.println(val1+ " " + ope + " " + val2 + " = "+(val1 / val2));
		}
		
		if(errFlag == true){
			System.out.println("演算子エラー。tasu hiku kake waruのみ可能");
			System.exit(0);
		}
		
	}

}
