/**
 * 
 */
package utils;

import play.Logger;

/**
 * @author abhimanyu
 *
 */
public class KafkaTest1 {


	public KafkaTest1() {
		super();
	}

	public void process(String value, String topic) {
		
		Logger.info("topic : " + topic + " values : " + value);
		
	}
}
