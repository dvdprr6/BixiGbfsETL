package com.david.GBFSCron.connection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.ClusterConnection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/*
REFERENCE:
create_namespace 'BIXI'
create 'BIXI:GBFS',  {NAME => 'STATION_INFORMATION', VERSIONS => 10}, {NAME => 'GOOGLE_GEOCODING', VERSIONS => 10}

*/

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
