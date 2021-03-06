package com.david.enricher.connection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.ClusterConnection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import java.io.IOException;

public class HBaseConnection {
    private static ClusterConnection clusterConnection;

    private HBaseConnection(){}

    public static synchronized ClusterConnection getHBaseConnection(){
        if(clusterConnection == null){
            try{
                Configuration configuration = new Configuration();
                configuration.set("hbase.zookeeper.property.clientPort", "2182");
                clusterConnection = (ClusterConnection) ConnectionFactory.createConnection(configuration);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return clusterConnection;
    }
}
