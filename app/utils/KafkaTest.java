/**
 * 
 */
package utils;

import play.Logger;
import services.KafkaComsumers;

/**
 * @author abhimanyu
 *
 */
public class KafkaTest  {


	public KafkaTest() {
		super();
	}

	public void process(String value, String topic) {
		
		Logger.info("topic : " + topic + " values : " + value);
		
	}

	

}
