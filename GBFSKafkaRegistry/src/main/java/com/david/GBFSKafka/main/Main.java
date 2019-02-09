package com.david.GBFSKafka.main;

import com.david.GBFSKafka.avro.model.TripHistory;
import com.david.GBFSKafka.utils.Constants;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, RestClientException, URISyntaxException {
        int identityMapCapacity = 1;
        int partitionKey = 1;

        SchemaRegistryClient schemaRegistryClient = new CachedSchemaRegistryClient(Constants.SCHEMA_REGISTRY_URL, identityMapCapacity);
        schemaRegistryClient.register("trip-history-value", TripHistory.SCHEMA$);

        List<TripHistory> tripHistoryValues = readTripHistory(Constants.TRIP_HISTORY_PATH);

        Producer<Integer, GenericRecord> producer = createProducer();

        for(TripHistory tripHistory : tripHistoryValues){
            //String partitionKey = "";
            //partitionKey++;
            producer.send(new ProducerRecord<>(Constants.TOPIC, partitionKey, tripHistory));
            partitionKey++;
        }
    }

    private static List<TripHistory> readTripHistory(String fileName) throws URISyntaxException, IOException{
        List<String> inRecords = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        inRecords.remove(0);

        return inRecords.stream().map(Main::stringToTripHistory).collect(Collectors.toList());
    }

    private static TripHistory stringToTripHistory(String record){
        String[] line = record.split(",");

        String startDate = line[0];
        int startStationCode = Integer.valueOf(line[1]);
        String endDate = line[2];
        int endStationCode = Integer.valueOf(line[3]);
        int durationSec = Integer.valueOf(line[4]);
        int isMember = Integer.valueOf(line[5]);

        return new TripHistory(startDate, startStationCode, endDate, endStationCode, durationSec, isMember);
    }

    private static Producer<Integer, GenericRecord> createProducer(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "gbfs-bixi-kafka");
        properties.put("schema.registry.url", Constants.SCHEMA_REGISTRY_URL);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        return new KafkaProducer<>(properties);
    }
}
