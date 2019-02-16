package com.david.curator.kafka

import java.util.Properties

import com.david.avro.EnrichedTrip
import com.david.curator.util.Constants
import io.confluent.kafka.serializers.{AbstractKafkaAvroSerDeConfig, KafkaAvroDeserializer, KafkaAvroDeserializerConfig, KafkaAvroSerializer}
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.{Consumer, ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerConfig}
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}

object Kafka {
  def createConsumer: Consumer[Int, EnrichedTrip] = {
    val properties = new Properties();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS)
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "trip-history");
    properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
    properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    properties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, Constants.SCHEMA_REGISTRY_URL);
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName());
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[KafkaAvroDeserializer].getName());
    properties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);

    return new KafkaConsumer[Int, EnrichedTrip](properties)
  }

  def createProducer: Producer[String, GenericRecord] = {
    val properties = new Properties()
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
    properties.put(ProducerConfig.CLIENT_ID_CONFIG, "gbfs-bixi-kafka");
    properties.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[KafkaAvroSerializer]getName());

    return new KafkaProducer[String, GenericRecord](properties)
  }
}
