package kr.ac.halla.Capstone;

import java.util.ArrayList;

public class Extracter {
	// text == 입력받은 문장
	// allKeywords == 전체 키워드들
	// keywordsBySentence == 각 문장별 키워드
	// sentence == 여러 키워드들이 종합되어있는 문장들
	// sentence의 0번 인덱스 => 1번째 문장의 키워드들이 저장되어있는 keywordsBySentence List 반환
	// sentence의 1번 인덱스 => 2번째 문장의 키워드들이 저장되어있는 keywordsBySentence List 반환
	private String text = null;
	private ArrayList<String> allKeywords;
	private ArrayList<String> keywordsBySentence;
	private ArrayList<ArrayList> sentences;
	
	public Extracter() {
		// 키워드 추출기 생성자
		super();
		System.out.println("\n:::키워드 추출기가 생성되었습니다:::");
	}
	
	public void inputText(String text) {
		this.text = text;
		extractKeywordFromText();
		System.out.println("\n:::텍스트 설정 완료!!\t 키워드 추출이 가능합니다:::");
	}
	
	public ArrayList getAllKeywordList() {
		return allKeywords;
	}
	
	public ArrayList getKeywordList() {
		return sentences;
	}
	
	public void extractKeywordFromText() {
		sentences = new ArrayList<ArrayList>();
		allKeywords = new ArrayList<String>();
		String[] lines = text.split("\\.");
		for(int i = 0; i < lines.length; i++) {
			String[] arr = lines[i].split(" ");
			keywordsBySentence = new ArrayList<String>();
			for(int j = 0; j < arr.length; j++) {
				if(arr[j].equals("") || arr[j].equals(" ")) {}
				else keywordsBySentence.add(arr[j]);
			}
			sentences.add(keywordsBySentence);
		}
		
		for(int i = 0; i < sentences.size(); i++) {
			for(int j = 0; j < sentences.get(i).size(); j++) {
				allKeywords.add((i+1)+"번째 문장의 키워드 : "+sentences.get(i).get(j));
			}
		}
	}
	
	public boolean isAlreadySetted(){
		return (text != null);
	}
}
