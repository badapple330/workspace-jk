
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class keisan5check {


	public static void main(String[] args) throws Exception {
		/**
		 * mainはメソッドを実行するだけ
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String param[] = input.split(" ");

		int sum = calc(param, 0, param.length); //return sum
		System.out.println(sum);
	}
//23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
// ( の前は必ず演算子
//計算処理 staticなメソッド
	public static int calc(String[] param, int startIdx, int endIdx){
		int sum=0; //return
		int num=0; //数値
		String type = null;	//演算子
		for(int i=startIdx;i<endIdx;i++){
			if(param[i].equals("+") || param[i].equals("-")){
//				if(param[i].equals("+")){
//					type = "+";
//				}else if(param[i].equals("-")){
//					type = "-";
//				}
				type = param[i]; //のみでおｋ
			}else if(param[i].equals("(")){
				//ここに ) をの項数を検索 endBacket(param, i);[
//null判定がいつ
				if(type != null){
					if(type.equals("+")){
						sum = sum + calc(param, i+1, endBacket(param, i+1));	//i+1じゃないと無限ループ。( の次
					}else if(type.equals("-")){
						sum = sum - calc(param, i+1, endBacket(param, i+1));
					}
				}else{
					sum = calc(param, i+1, endBacket(param, i+1)-1);
				}
//こいつがいなかった。staticとか関係なく、繰り返しの回数を引き継ぐ記述。
//元の解答例だと ) の例外記述ないのもendBacketで回避しているのか？
//あー、i++ で回避されてるわ。
//endBacketで戻すのが ) だからちょうど++で次の数値に移ってる。なるほどね～
// ) ) ) とかで実験するとやっぱり  java.lang.NumberFormatException はく
				i = endBacket(param, i+1);
// if(!(param[i].equals(")")))いらないのか？
			}else{	//数値のとき	error:ここだわ。 )が入っちゃてる
				num = Integer.parseInt(param[i]);
				if(type != null){
					if(type.equals("+")){
						sum = sum + num;
					}else if(type.equals("-")){
						sum = sum - num;
					}
				}else{	//if(type != null)がないと、常にこれが実行されてしまう
					sum = num;
				}
			}
		}
		return sum;
	}

//一番外側の (,に対応する,)の項数を判定
//ex:( ( )  () )  一番外側の()に対して項数を探す。一番外側の()ごとにkeisanメソッドを走らせる感じ。
	public static int endBacket(String[] param, int startBacket){
			//startBacket は ( の param[i]. そのときの i が入る。
		int end = startBacket;
		int hantei = 0;	//  ) が出たときに0になる。 (で1になる。 ()の数が対応したときに0になる。
		for(int i = startBacket; i<param.length; i++){
			end = i;
			if(param[i].equals("(")){
				hantei = hantei + 1;
			}else if(param[i].equals(")")){
				if(hantei == 0){
					break;	// ()の数が対応したとき、for文を抜ける。
				}
				hantei = hantei - 1;
			}
		}
		return end;	//for文の中で定義されたiをreturnできないからendに入れ直している
	}
}
