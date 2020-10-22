import java.util.Random;

public class Omojan {
	final static String[] words = new String[]{
			"シャー専用","ザク","はじめての","チュー","極道の","妻たち","さよなら","三角","おはよう","101回目の","プロポーズ","池中玄太","80キロ","姉さん","ピンチです","白い","赤い",
	};
	
	private String getSingleWord(){
		int index =new Random().nextInt(words.length);
		return words[index];
	}
	
	public String getWord(){
		String word = getSingleWord() + " " + getSingleWord();
		if (word.indexOf("白い") != -1){
			word = String.format("<font color=\"white\">%s</font>",word);
		}else if(word.indexOf("赤い") != -1){
			word = String.format("<font color=\"red\">%s</font>",word);
		}
		return word;
	}
}
