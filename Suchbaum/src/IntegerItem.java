public class IntegerItem implements ComparableContent<IntegerItem> {

	private int content;

	public IntegerItem(int content) {
		this.content = content;
	}

	public int getContent() {
		return content;
	}
	
	public boolean isGreater(IntegerItem pContent) {
		return content > pContent.getContent();
	}

	public boolean isEqual(IntegerItem pContent) {		
		return content == pContent.getContent();
	}

	public boolean isLess(IntegerItem pContent) {
		return content < pContent.getContent();
	}
	
	public String toString() {
		return Integer.toString(content);
	}
}
