import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class Sample {
	public static void main(String[] args) {
		String text = "岸田文雄首相は衆院本会議で所信表明演説し、個人のリスキリング（学び直し）の支援に5年で1兆円を投じると表明した。";
		CJKAnalyzer analyzer = new CJKAnalyzer();
		// StandardAnalyzer analyzer = new StandardAnalyzer();
		// List<String> tokens = new ArrayList<String>();
		// 
		TokenStream tokenStream = analyzer.tokenStream("testField", text);
		try {
			tokenStream.reset();
			CharTermAttribute termAtt = tokenStream.addAttribute(CharTermAttribute.class);
			// OffsetAttribute offsetAtt = tokenStream.addAttribute(OffsetAttribute.class);
			while (tokenStream.incrementToken()) {
				// tokens.add(termAtt.toString());
				System.out.println(termAtt.toString());
			}
			tokenStream.end();
		} catch (IOException e) {
			// System.out.println(e);
		}
	}
}