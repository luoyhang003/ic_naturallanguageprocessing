package OCTest;

import com.officecoder.xml.XMLWorker;

public class XMLWorkerTest {

	public static void main(String[] args) {
		XMLWorker xmlWorker = new XMLWorker("5c933fabed1a469c85fe70f93546ccdb",
				"test1");
		xmlWorker.addFullPage("p1");
		xmlWorker.addPage(false, "local", "#ffffff", "color","");
		xmlWorker.addWidget("page1", "OCButton_Cancel");
	}
}
