#!/bin/bash

# FOR DEBUGGING
#export SPARK_SUBMIT_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5000

spark-submit --class com.david.GenerateGBFS.main.Main --master local[*] GenerateGBFSDataset.jar
