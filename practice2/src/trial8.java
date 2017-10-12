
public class trial8 {

	public static void main(String[] args) {

//		Animal animal = new Animal();
//		cat cat = new cat();
//		cat.sleep();
//		cat.setName("nayanyanyanya");	//文字列を使うなら""で囲む
//		cat.setAge(255);
//		cat.Show();
//
//		dog dog = new dog();
//		dog.Run();
//		dog.Show();

//		cat cat = new cat();
//		dog2 dog = new dog2();
//		cat.speak();
//		dog.speak();

		String str[] = new String[5];
			//配列のオブジェクト化。

//		Animal animal[] = new Animal[4];	//()いらないのか？コンストラクタの起動をしない？
//		for(int i=0;i<4;i++){
//			if(i%2==0){
//				cat cat = new cat();
//				animal[i] = cat;
//				animal[i].Speak();
//			}else{
//				dog2 dog = new dog2();
//				animal[i] = dog;
//				animal[i].Speak();
//			}
//
//		}

		Animal animal[] = new Animal[4];	//()いらないのか？コンストラクタの起動をしない？
		for(int i=0;i<4;i++){
			if(i%2==0){
				animal[i] = new cat();	//配列の入れ物にnew cat()オブジェクトが格納される？変数名は？
				animal[i].Speak();
			}else{
				animal[i] = new dog2();
				animal[i].Speak();
			}
		}

	}
}


class Animal{	//classに引数の()はつかない。コンストラクタのときのみ使う。class class_name
	public String Name;
	public int Age;

	public void Show(){
		System.out.println("名前"+Name);
		System.out.println(Age+"歳です。");
	}

	public void Speak(){
		System.out.println("let's getfuck'n bed");
	}
}

class cat extends Animal{
	public void sleep(){
		System.out.println("スースー");
	}

	public void setName(String name){
		super.Name = name;
	}
	public void setAge(int age){
		super.Age = age;
	}
	public void Speak(){
		System.out.println("にゃんにゃんお");
	}

}

class dog2 extends Animal{
	public void Run(){
		System.out.println("ドンドコドコドコドンドコドン");
	}

	public void Speak(){
		System.out.println("わんわんお");
	}

}
