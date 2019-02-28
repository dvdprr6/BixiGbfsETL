#!/bin/bash

# FOR DEBUGGING
export SPARK_SUBMIT_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5000

# FOR SPARK
spark-submit --class com.david.curator.main.Main --master local[*] Curator.jar
