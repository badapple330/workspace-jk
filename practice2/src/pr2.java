import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class pr2 {

	public static void main(String[] args) {
		//javaDriveをやっていくよ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		//ArrayListについて
		/**
		 * arrayList配列は大きさが決まっていない配列
		 * ArrayList<クラス名> 変数名 = new ArrayList<型>();
		 * データ型ではなく、クラス名を指定することができる。
		 * データ型を使いたいときはラッパークラスを使用する。（それぞれのデータ型に対応したクラスのこと）
		 */

		//インスタンスの作成
		ArrayList<Integer> num = new ArrayList<Integer>();
		//addメソッド。リストの最後に要素が追加される
		num.add(10);	//autoboxing機能でデータ型を自動判定してくれる
		num.add(new Integer(10)); //上下同じ表記。クラスのインスタンスして値を入れてる、
		System.out.println(num.get(0));
		System.out.println(num.size());
		//要素の置き換えset
		num.set(0, 255);
		//検索　最初と最後。中間は？forとかのあとにindexof
		num.indexOf(255); //(elem)最初に出てきた値のindexを戻す。
		num.lastIndexOf(255); //リスト内で最後に現れるindexを返す。見つからない→ -1が返る


		/**
		 * LinkedList
		 * ArrayListと基本的に似ている。要素の順番を個別に管理している。
		 * 要素の追加、削除がArrayListに比べて早い。
		 * 要素の検索はArrayListのほうが早い。
		 */
		LinkedList<String> list = new LinkedList<String>();
		//<>の中はArrayListと同じくクラス。
		//add.
		list.add(new String("おちん○"));
		list.add("vagina");
		//LinkedListではadd
		list.add(0, "おちんちんんん");//要素の場所を指定してadd←すでに入ってるところには無理？
		//現在の位置に存在するものは右に移動する。
		list.get(0);
		list.size();
		list.addFirst("dick");
		list.addLast("Boobs");
		//setは置き換え
		list.set(0, "virgn");
		//remove削除
		list.remove(0); //indexを引数に
		list.clear(); //全削除
		//検索はindexOf,lastIndexOfでArrayListと一緒
		list.indexOf("おちん○"); //引数は値
								//削除されたもの以降のindexは左にずれる。つまり-1
		//offer リストの最後に追加
		list.offer("おっぱ");
		//peek リストの最初を取得。削除しない。element(例外を返す版
		list.peek();
		//poll リストの先頭を取得し削除。remove(例外を返す版
		list.poll();


		/**
		 * HashMap コレクション
		 * key名"String" と 要素が対応している。 indexを使ってない。
		 */
		//key と 要素 の2つのデータ型を指定する。
		HashMap<String, String> map = new HashMap<String, String>();
		//put 格納する
		map.put("key1", "oppaiAcup");
		//get 取得する
		map.get("key1");	//key名が引数。
		//remove
		map.remove("key1"); //keyが存在したら削除
		//clear 存在するkeyすべて削除
		map.clear();
		//containskey
		map.containsKey("key1"); //keyが存在するか判定.ture falsee


	/******	  配列系はここでおしまい	******/
	}

}
