docker stop ssanijaro_mongodb
docker rm ssanijaro_mongodb
docker build -t ssanijaro_mongodb .
docker run -i -p 27017:27017 --name ssanijaro_mongodb -d ssanijaro_mongodb
