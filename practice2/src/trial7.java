import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trial7 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



//		Dog dog = new Dog();	//右のDog()はデフォルトコンストラクタ
//		System.out.println("名前を入力");
//		String str = br.readLine();
//		System.out.println("年齢を入力");
//		int n2;
//		dog.setName(str);
//		dog.setAge(n2=Integer.parseInt(br.readLine()));
//		dog.ShowProfile();

//		Dog dog2 = new Dog();
//		String str2 = br.readLine();
//		int n3 = Integer.parseInt(br.readLine());
//		dog2.setName(str2);
//		dog2.setAge(n3);
//		dog2.ShowProfile();


//7-4
//		Dog dog3 = new Dog("いっぬ", 967, "雑種");
//		dog3.ShowProfile();

		Coincase coincase = new Coincase();
		for(int i=0;i<15;i++){
			coincase.setCase500();
			coincase.setCase100();
			coincase.setCase50();
			coincase.setCase10();
			coincase.setCase5();
			coincase.setCase1();
		}
		coincase.setCost();
		coincase.showprofile();




	}

}


class Dog{

	private String Name;
	private int Age;
	private String category;

	Dog(){

	}

	Dog(String name, int age, String category){
		this.Name = name;
		this.Age = age;
		this.category = category;
	}

	public void setAge(int age){
		Age = age;
	}

	public void setName(String name){
		Name = name;
	}
	public void ShowProfile(){
		System.out.println("名前は"+Name+"です。");
		System.out.println("年齢は"+Age+"です。");
		System.out.println("種類は"+category+"です。");
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}



class Coincase{
	private int case500;
	private int case100;
	private int case50;
	private int case10;
	private int case5;
	private int case1;
	private int Amount;


	int c500;
	int c100;
	int c50;
	int c10;
	int c5;
	int c1;
	int cAmount;
	/**
	 * case500取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case500
	 */
	public int getCase500() {
		return case500;
	}
	/**
	 *  case500格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case500
	 */
	public void setCase500() {
		case500++;
	}
	/**
	 * case100取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case100
	 */
	public int getCase100() {
		return case100;
	}
	/**
	 *  case100格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case100
	 */
	public void setCase100() {
		case100++;
	}
	/**
	 * case50取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case50
	 */
	public int getCase50() {
		return case50;
	}
	/**
	 *  case50格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case50
	 */
	public void setCase50() {
		case50++;
	}
	/**
	 * case10取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case10
	 */
	public int getCase10() {
		return case10;
	}
	/**
	 *  case10格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case10
	 */
	public void setCase10() {
		case10++;
	}
	/**
	 * case5取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case5
	 */
	public int getCase5() {
		return case5;
	}
	/**
	 *  case5格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case5
	 */
	public void setCase5() {
		case5++;
	}
	/**
	 * case1取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return case1
	 */
	public int getCase1() {
		return case1;
	}
	/**
	 *  case1格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param case1
	 */
	public void setCase1() {
		case1++;
	}
	/**
	 * amount取得メソッド
	 * @auther Toshifumi Yamashita
	 * @return amount
	 */
	public int getAmount() {
		return Amount;
	}
	/**
	 *  amount格納メソッド
	 * @auther Toshifumi Yamashita
	 * @param amount
	 */
	public void setAmount() {
		this.Amount = case500+case100+case50+case10+case5+case1;
	}
	public void setCost(){
		 c500 = getCase500()*500;
		 c100 =getCase100()*100;
		 c50 =getCase50()*50;
		 c10 =getCase10()*10;
		 c5 =getCase5()*5;
		 c1 =getCase1()*1;
		 cAmount = c500+c100+c50+c10+c5+c1;
	}
	public void showprofile(){
		setAmount();
		System.out.println("500円は"+case500*500);
		System.out.println("100円は"+case100*100);
		System.out.println("50円は"+case50*50);
		System.out.println("10円は"+case10*10);
		System.out.println("5円は"+case5*5);
		System.out.println("1円は"+case1*1);
		System.out.println("総数は"+Amount+"枚");
		System.out.println("総数は"+cAmount+"円");
	}

}