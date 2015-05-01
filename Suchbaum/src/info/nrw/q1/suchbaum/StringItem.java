package info.nrw.q1.suchbaum;
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
		return content.equals(pContent.getContent());
	}

	public boolean isLess(StringItem pContent) {
		return content.compareTo(pContent.getContent()) < 0;
	}
	
	public String toString() {
		return content + "(" + count + ")";
	}
}
