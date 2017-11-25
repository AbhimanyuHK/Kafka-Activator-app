/**
 * 
 */
package services;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.google.inject.Singleton;

import play.Logger;

/**
 * @author abhimanyu
 *
 */

@Singleton
public class KafkaComsumers extends Thread {

	private static final List<String> AS_LIST_TOPIC = Arrays.asList("test", "test1");

	@Override
	public void run() {
		kafkaMsg();
	}

	private void kafkaMsg() {
		Logger.info("Kafka started.................");
		Properties properties = Propertiesz.properties();
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		consumer.subscribe(AS_LIST_TOPIC);
		for (String string : AS_LIST_TOPIC) {
			Logger.info("Kafka topic : " + string);
		}
		Logger.info("Kafka ip :" + properties.getProperty("bootstrap.servers"));
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
				for (ConsumerRecord<String, String> record : records) {
					// Logger.info("consumer record is : " + record.topic() + " and value " + record.value());
					process(record.value(), record.topic());
				}
			}
		} catch (Exception e) {
			Logger.error("error while comsuming : " + e.getMessage());
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}

	public void process(String value, String topic) {

		new ProcessKafka().process(value, topic);
	}
}
