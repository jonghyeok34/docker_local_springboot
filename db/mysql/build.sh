docker stop demo_mysql
docker rm demo_mysql
docker build -t demo/mysql:5.7 .
docker run -i -d -p 3306:3306 --name demo_mysql \
--env-file=env.conf \
demo/mysql:5.7
