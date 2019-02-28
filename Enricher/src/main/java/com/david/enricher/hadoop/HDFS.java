package com.david.enricher.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFS {

    public static void write(String hdfsPath, String content){
        Path path = new Path(hdfsPath);

        try {
            FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), new Configuration());

            DataOutputStream dataOutputStream = fileSystem.create(path);
            dataOutputStream.write(content.getBytes());
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static boolean move(String hdfsPathSrc, String hdfsPathDst){
        Path pathSrc = new Path(hdfsPathSrc);
        Path pathDst = new Path(hdfsPathDst);
        boolean success = false;

        try{
            FileSystem fileSystem = FileSystem.get(new URI(hdfsPathSrc), new Configuration());

            success = fileSystem.rename(pathSrc, pathDst);
            fileSystem.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static void delete(String hdfsPath){
        Path path = new Path(hdfsPath);

        try{
            FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), new Configuration());

            if(fileSystem.exists(path)){
                fileSystem.delete(path, true);
            }

            fileSystem.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
