docker stop demo_mongodb
docker rm demo_mongodb
docker build -t demo/mongo:3.6 .
docker run -i -d -p 27018:27017 --name demo_mongodb \
--env-file=env.conf \
demo/mongo:3.6
