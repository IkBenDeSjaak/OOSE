#!/bin/sh
mvn clean package && docker build -t han.oose.dea/simply-rest .
docker rm -f simply-rest || true && docker run -d -p 8080:8080 -p 4848:4848 --name simply-rest han.oose.dea/simply-rest 
