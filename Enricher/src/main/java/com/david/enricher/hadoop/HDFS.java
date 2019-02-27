package com.david.enricher.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFS {

    public static void write(String hdfsPath, String content){
        Path path = new Path(hdfsPath);

        try {
            FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), new Configuration());

            if(fileSystem.exists(path)){
                fileSystem.delete(path, true);
            }

            DataOutputStream dataOutputStream = fileSystem.create(path);
            dataOutputStream.write(content.getBytes());
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
