# Build
mvn clean package && docker build -t han.oose.dea/TEST .

# RUN

docker rm -f TEST || true && docker run -d -p 8080:8080 -p 4848:4848 --name TEST han.oose.dea/TEST 