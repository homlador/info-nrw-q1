package info.nrw.q1.suchbaum;

/**
 * Ein Inhaltsobjekt für einen BinarySearchTree
 * Es wird ein String zusammen mit seiner Häufigkeit gespeichert.
 * 
 * Sortiert wird das Item nach dem Alphabet, dazu wird die Methode
 * compareTo der Klasse String genutzt
 */
public class StringItem implements ComparableContent<StringItem> {

	private String content;
	private int count;

	public StringItem(String content) {
		this.content = content;
		this.count = 1;
	}

	public String getContent() {
		return content;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int pCount) {
		count = pCount;
	}
	
	public boolean isGreater(StringItem pContent) {
		return content.compareTo(pContent.getContent()) > 0;
	}

	public boolean isEqual(StringItem pContent) {		
		// TODO: benutze die Methode equals der Klasse String
	}

	public boolean isLess(StringItem pContent) {
		// TODO: benutze die Methode compareTo() der Klassse String (siehe isGreater())
	}
	
	public String toString() {
		return content + "(" + count + ")";
	}
}
