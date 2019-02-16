package com.david.enricher.main;

import com.david.avro.EnrichedTrip;
import com.david.avro.StationInformation;
import com.david.avro.TripHistory;
import com.david.enricher.dao.stationinformation.StationInformationFactory;
import com.david.enricher.utils.Constants;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.*;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;


public class Main {

    public static void main(String[] args){

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        try(Consumer<Integer, TripHistory> kafkaConsumer = createConsumer(); Producer<String, GenericRecord> kafkaProducer = createProducer()){
            kafkaConsumer.subscribe(Collections.singleton(Constants.TRIP_HISTORY_TOPIC));
            List<StationInformation> stationInformationList = new ArrayList<StationInformation>();
            int partitionKey = 1;

            //while(kafkaConsumer.listTopics().size() > 0){
            while(true){
                ConsumerRecords<Integer, TripHistory> tripHistoryRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
                for(ConsumerRecord<Integer, TripHistory> record : tripHistoryRecords){
                    TripHistory tripHistory = record.value();
                    StationInformation startStationInformation = StationInformationFactory.getStationInformationDao().getById(tripHistory.getStartStationCode());
                    StationInformation endStationInformation = StationInformationFactory.getStationInformationDao().getById(tripHistory.getEndStationCode());

                    stationInformationList.add(startStationInformation);
                    stationInformationList.add(endStationInformation);

                    EnrichedTrip enrichedTrip = new EnrichedTrip(stationInformationList, tripHistory);

                    kafkaProducer.send(new ProducerRecord<>(Constants.ENRICH_TOPIC, String.valueOf(partitionKey), enrichedTrip));

                    partitionKey++;

                    stationInformationList.clear();
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

    private static Producer<String, GenericRecord> createProducer(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "gbfs-bixi-kafka");
        properties.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        return new KafkaProducer<String, GenericRecord>(properties);
    }
}
