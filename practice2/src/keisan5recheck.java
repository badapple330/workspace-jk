
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class keisan5recheck {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] param = input.split(" ");

		int sum = calc(param, 0, param.length);
		System.out.println(sum);
	}
//23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )
//6 - ( 3 + 2 )
//計算処理
	//param[1]が(のとき。sum = num;で初期化が0になってた。
	//再帰的に呼び出し時、i<param.lengthで計算箇所がおかしくなっていた問題。の2つ
//正解
	public static int calc(String[] param, int startIdx, int endIdex){
		int sum = 0;	//return 計算値
		int num = 0;	//数値
		String type = null; //演算子
		for(int i=startIdx; i<endIdex; i++){	//param.length→endIdx。再帰的に実行したときの計算箇所がおかしくなる
			if(param[i].equals("+") || param[i].equals("-")){
				type = param[i];
			}else if(param[i].equals("(")){
				if(type != null){
					if(type.equals("+")){
						sum = sum + calc(param, i+1, endBacket(param, i+1));	//i+1なのはiの位置が(だから。次の数字から検索させたい。
					}else if(type.equals("-")){
						sum = sum - calc(param, i+1, endBacket(param, i+1));
					}
				}else if(type == null){

//					sum = num; //ここだわ numの値がおかしい。
					sum = calc(param, i+1, endBacket(param, i+1));
				}
				i = endBacket(param, i+1); // )の位置をreturn。forで++されてとばされる。

			}else if(!param[i].equals(")")){	//i++で)の位置自体は飛ばされる
				num = Integer.parseInt(param[i]);
				if(type != null){
					if(type.equals("+")){
						sum = sum + num;
					}else if(type.equals("-")){
						sum = sum - num;
					}
				}else{
					sum = num; //初期値
				}
			}
		}
		return sum;
	}

//)の項数をreturn
	public static int endBacket(String param[], int startIdx){
		int end = startIdx;
		int count = 0; //()の1対で0にする。(が増えると1増加。)で1減少。
		for(int i = startIdx;i<param.length;i++){
			end = i;
			if(param[i].equals("(")){
				count = count + 1;
			}else if(param[i].equals(")")){
				if(count == 0){
					break;
				}
				count = count - 1;
			}
		}
		return end;
	}

}
