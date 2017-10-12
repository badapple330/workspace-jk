
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class keisan {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] param = input.split(" ");
		int sum = calc(param,0,param.length - 1); //.length-1 は()検索あとのendOfFormulaにfor文を合わせるためにここでは引いてる
		System.out.println(sum);
	}
	//23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
	//static なのか
	//staticでも 元のsum と再帰的に起動した　return:sumの値が違っても別の値みたいだ
	//static メソッドは インスタンス化しなくてもアクセスできる。 staticな変数とはまた違う？
	//returnで返してるのは、 ※int型の数値
	//staticなメソッドだから、実行されんのはこのメソッドだわ。中に色々残ってる
	public static int calc(String[] param, int startIdx, int endIdx){
		int sum = 0;
		String type = null;
		for(int idx = startIdx; idx < endIdx + 1;idx++){
			if(param[idx].equals("+") || param[idx].equals("-")){
				type = param[idx];
			}else if(param[idx].equals("(")){
				int endOfFormula = checkEndOfFormula(param,idx);
				if(type != null){
					if(type.equals("+")){	//ここで ( 直前の演算子を使ってる。
						sum = sum + calc(param, idx + 1, endOfFormula -1);	//+1で(の次。 endOfFormula-1で)の前
							//ここで使われたstartidxが保存されて渡されているのか？
					}else if(type.equals("-")){
						sum = sum - calc(param, idx + 1, endOfFormula -1);
					}
				}else{
					sum = calc(param, idx + 1, endOfFormula -1);
				}
				idx = endOfFormula;
			}else{
				int num = Integer.parseInt(param[idx]);
				if(type != null){
					if(type.equals("+")){
					sum = sum + num;
					}else if(type.equals("-")){
						sum = sum - num;
					}
				}else{
					sum = num;
				}
			}
		}
	return sum;
	}
	// 「(」の終わりを見つけるメソッド
	public static int checkEndOfFormula(String[] param, int startIdx){	//startIndexは ( のときの項数
		int end = startIdx + 1;
		int startCount = 0;
		for(int idx = startIdx + 1 ; idx < param.length; idx++){	//paramは.lengthのため
			end = idx;
			if(param[idx].equals("(")){
				startCount++;
			}else if(param[idx].equals(")")){
				if(startCount == 0){
					break;
				}else{
					startCount--;
				}
			}
		}
		return end;
	}
}
