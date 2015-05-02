package info.nrw.q1.kreismaler;
/**
 * Ein Druckauftrag
 */
public class PrintJob {

	private static int lastPrintJobNo = 0;
	
	private int printJobNo;
	private String metaData;
	
	public PrintJob(String pMetaData) {
		metaData = pMetaData;
		printJobNo = ++lastPrintJobNo;
	}

	public String toString() {
		return "PrintJob " + printJobNo + ": " + metaData;
	}
}
