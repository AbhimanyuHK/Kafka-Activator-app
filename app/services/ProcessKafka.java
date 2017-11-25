package services;

import utils.KafkaTest;
import utils.KafkaTest1;

public class ProcessKafka  {

	public ProcessKafka() {
		super();
	}

	public void process(String value, String topic) {
	
		switch (topic) {
		case "test":
			new KafkaTest().process(value, topic);
			break;
		case "test1":
			new KafkaTest1().process(value, topic);
			break;
	
		default:
			break;
		}
	}

}