package kr.ac.halla.Capstone;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		ArrayList keywords = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		Extracter et;

		System.out.print(":::키워드 추출 프로그램입니다:::\n새로 키워드를 추출하시겠습니까?(y / n) : ");
		String state = sc.next();
		while (!(state.equals("n") || state.equals("y"))) {
			System.out.print("다시 입력해주세요. 새로 키워드를 추출하시겠습니까?(y / n) : ");
			state = sc.next();
		}
		if (state.equals("n")) {
			System.out.println("프로그램을 종료합니다.");
			return;
		} else {
			et = new Extracter();
			boolean status = true;
			while (doExtract(et, status, et.isAlreadySetted())) {
			}
		}
	}

	public static boolean doExtract(Extracter et, boolean state, boolean textState) {
		Scanner sc = new Scanner(System.in);
		if (textState) {
			System.out.print("작업을 선택해 주세요.(1.키워드 추출   2.문장 교체   3.종료) : ");
			int index = sc.nextInt();
			sc.nextLine();
			while (!(index == 1 || index == 2 || index == 3)) {
				System.out.print("다시 입력해주세요.(1.키워드 추출   2.문장 교체   3.종료) : ");
				index = sc.nextInt();
				sc.nextLine();
			}
			switch (index) {
			case 1:
				while(getKeywords(et)) {}
				break;
			case 2:
				String text1 = "";
				System.out.println("문장을 입력하세요 : ");
				text1 = sc.nextLine();
				et.inputText(text1);
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				state = false;
				break;
			}
		} else {
			System.out.print("작업을 선택해 주세요.(1.문장 입력   2.종료) : ");
			int index = sc.nextInt();
			sc.nextLine();
			while (!(index == 1 || index == 2)) {
				System.out.print("다시 입력해주세요.(1.문장 입력   2.종료) : ");
				index = sc.nextInt();
				sc.nextLine();
			}
			switch (index) {
			case 1:
				String text2 = "";
				System.out.println("문장을 입력하세요 : ");
				text2 = sc.nextLine();
				et.inputText(text2);
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				state = false;
				break;
			}
		}
		return state;
	}
	
	public static boolean getKeywords(Extracter et) {
		boolean state = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("키워드 추출 방법을 선택해주세요.(1.전체 키워드 추출   2.문장별 키워드 추출   3.이전으로 돌아가기) : ");
		ArrayList keywords = new ArrayList<String>();
		ArrayList sentences = new ArrayList<ArrayList>();
		keywords = et.getAllKeywordList();
		sentences = et.getKeywordList();
		int index = sc.nextInt();
		sc.nextLine();
		while (!(index == 1 || index == 2 || index == 3)) {
			System.out.print("다시 입력해주세요.(1.전체 키워드 추출   2.문장별 키워드 추출   3.이전으로 돌아가기) : ");
			index = sc.nextInt();
			sc.nextLine();
		}
		switch(index) {
		case 1:
			System.out.println("\n:::전체 키워드를 추출합니다:::\n");
			for(int i = 0; i < keywords.size(); i++) {
				System.out.println(keywords.get(i));
			}
			break;
		case 2:
			while(getKeywordsFromSentence(sentences)) {}
			break;
		case 3:
			state = false;
			break;
		}
		return state;
	}
	
	public static boolean getKeywordsFromSentence(ArrayList<ArrayList> sentences) {
		boolean state = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("키워드를 추출할 문장의 번호를 입력하세요.(숫자로 입력 / exit : 이전으로 돌아가기) : ");
		String index = sc.nextLine();
		int indexNum = 0;
		if(index.equals("exit")) {
			state = false;
		}else {
			indexNum = Integer.parseInt(index);
			System.out.println("");
			for(int i = 0; i < sentences.get(indexNum-1).size(); i++) {
				System.out.println(indexNum + "번째 문장의 키워드 : " + sentences.get(indexNum-1).get(i));
			}
			System.out.println("-------------------------------");
		}
		return state;
	}
}
