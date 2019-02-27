package com.david.enricher.main;

import com.david.avro.StationInformation;
import com.david.avro.TripHistory;
import com.david.enricher.dao.stationinformation.StationInformationFactory;
import com.david.enricher.hadoop.HDFS;
import com.david.enricher.utils.Constants;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.consumer.*;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public class Main {

    public static void main(String[] args){

        StringBuilder stringBuilder = new StringBuilder(Constants.ENRICH_CSV_HEADER + "\n");

        try(Consumer<Integer, TripHistory> kafkaConsumer = createConsumer()){
            kafkaConsumer.subscribe(Collections.singleton(Constants.TRIP_HISTORY_TOPIC));

            ConsumerRecords<Integer, TripHistory> tripHistoryRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<Integer, TripHistory> record : tripHistoryRecords){
                TripHistory tripHistory = record.value();
                StationInformation startStationInformation = StationInformationFactory.getStationInformationDao().getById(tripHistory.getStartStationCode());
                StationInformation endStationInformation = StationInformationFactory.getStationInformationDao().getById(tripHistory.getEndStationCode());

                stringBuilder.append(tripHistory.getStartDate() + Constants.DELIMITER +
                        tripHistory.getStartStationCode() + Constants.DELIMITER +
                        startStationInformation.getStationId() + Constants.DELIMITER +
                        startStationInformation.getExternalId() + Constants.DELIMITER +
                        startStationInformation.getName() + Constants.DELIMITER +
                        startStationInformation.getShortName() + Constants.DELIMITER +
                        startStationInformation.getLat() + Constants.DELIMITER +
                        startStationInformation.getLon() + Constants.DELIMITER +
                        startStationInformation.getRentalMethods0() + Constants.DELIMITER +
                        startStationInformation.getRentalMethods1() + Constants.DELIMITER +
                        startStationInformation.getCapacity() + Constants.DELIMITER +
                        startStationInformation.getEightdHasKeyDispenser() + Constants.DELIMITER +
                        startStationInformation.getHasKiosk() + Constants.DELIMITER +
                        startStationInformation.getGoogleApiGeocodingJson() + Constants.DELIMITER +
                        tripHistory.getEndDate() + Constants.DELIMITER +
                        tripHistory.getEndStationCode() + Constants.DELIMITER +
                        endStationInformation.getStationId() + Constants.DELIMITER +
                        endStationInformation.getExternalId() + Constants.DELIMITER +
                        endStationInformation.getName() + Constants.DELIMITER +
                        endStationInformation.getShortName() + Constants.DELIMITER +
                        endStationInformation.getLat() + Constants.DELIMITER +
                        endStationInformation.getLon() + Constants.DELIMITER +
                        endStationInformation.getRentalMethods0() + Constants.DELIMITER +
                        endStationInformation.getRentalMethods1() + Constants.DELIMITER +
                        endStationInformation.getCapacity() + Constants.DELIMITER +
                        endStationInformation.getEightdHasKeyDispenser() + Constants.DELIMITER +
                        endStationInformation.getHasKiosk() + Constants.DELIMITER +
                        endStationInformation.getGoogleApiGeocodingJson() + Constants.DELIMITER +
                        tripHistory.getDurationSec() + Constants.DELIMITER +
                        tripHistory.getIsMember() + "\n");
            }
        }

        HDFS.write(Constants.ENRICH_CSV_FILE, stringBuilder.toString());

        stringBuilder.setLength(0);

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
