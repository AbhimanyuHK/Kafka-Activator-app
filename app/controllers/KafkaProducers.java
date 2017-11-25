/**
 * 
 */
package controllers;

import play.mvc.Result;
import services.Propertiesz;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import play.Logger;
import play.mvc.Controller;

/**
 * @author abhimanyu
 *
 */
public class KafkaProducers extends Controller {

	public Result kafkaProducer(String topic, String message) {

		Properties properties = Propertiesz.producerProperties();

		Producer<String, String> producer = new KafkaProducer<>(properties);
		try {
			producer.send(new ProducerRecord<String, String>(topic, message));
			Logger.info("kafka message published to topic : " + topic + " with message : " + message);
			producer.close();
			return ok("kafka message published to topic : " + topic + " with message : " + message);
		} catch (Exception e) {
			return ok("" + e);
		}

	}
}
