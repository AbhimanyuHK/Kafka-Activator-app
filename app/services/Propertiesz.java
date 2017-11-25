package services;

import java.util.Properties;

import javax.inject.Singleton;

import play.Logger;

@Singleton
public class Propertiesz extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Propertiesz() {
		super();
	}

	public static Propertiesz properties() {

		Logger.info("Kafka property.................");
		Propertiesz props = new Propertiesz();
		props.put("bootstrap.servers", "172.16.0.250:9092");
		props.put("group.id", "test-group-id");
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		return props;
	}

	public static Propertiesz producerProperties() {
		Propertiesz props = new Propertiesz();
		props.put("bootstrap.servers", "172.16.0.250:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return props;
	}
}
