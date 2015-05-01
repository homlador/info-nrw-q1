package info.nrw.q1.suchbaum;

/**
 * Ein Inhaltsobjekt für einen BinarySearchTree
 * Es wird ein String zusammen mit seiner Häufigkeit gespeichert.
 * 
 * Sortiert wird das Item nach der Häufigkeit seines Vorkommens.
 */
public class CountedStringItem implements ComparableContent<CountedStringItem> {

	private String content;
	private int count;

	public CountedStringItem(String content) {
		this(content, 1);
	}

	public CountedStringItem(String content, int pCount) {
		this.content = content;
		count = pCount;
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

	public boolean isGreater(CountedStringItem pContent) {
		return count > pContent.getCount();
	}

	public boolean isEqual(CountedStringItem pContent) {
		return count == pContent.getCount();
	}

	public boolean isLess(CountedStringItem pContent) {
		return !isGreater(pContent);
	}

	public String toString() {
		return content + "(" + count + ")";
	}
}
