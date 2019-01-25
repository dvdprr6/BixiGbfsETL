package com.david.GBFSCron.connection;

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
                clusterConnection = (ClusterConnection) ConnectionFactory.createConnection(new Configuration());
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return clusterConnection;
    }
}
