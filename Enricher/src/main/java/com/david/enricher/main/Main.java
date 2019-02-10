package com.david.enricher.main;

import com.david.enricher.model.TripHistory;
import com.david.enricher.utils.Constants;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.consumer.*;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws IOException{

        try(Consumer<Integer, TripHistory> kafkaConsumer = createConsumer()){
            kafkaConsumer.subscribe(Collections.singleton(Constants.TRIP_HISTORY_TOPIC));

            while(true){
                ConsumerRecords<Integer, TripHistory> tripHistoryRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
                for(ConsumerRecord<Integer, TripHistory> record : tripHistoryRecords){
                    TripHistory tripHistory = record.value();
                    System.out.println(tripHistory.getStartStationCode());
                }
            }
        }

    }

    private static Consumer<Integer, TripHistory> createConsumer(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "trip-history");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, Constants.SCHEMA_REGISTRY_URL);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        return new KafkaConsumer<Integer, TripHistory>(properties);
    }
}
