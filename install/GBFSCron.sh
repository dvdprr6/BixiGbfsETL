#!/bin/bash

java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5000 -jar GBFSCron-1.0-SNAPSHOT.jar
