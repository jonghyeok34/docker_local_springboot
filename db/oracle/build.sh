docker stop demo_oracle
docker rm demo_oracle
docker build -t demo/oracle-xe-11g:latest .
docker run -i -d -p 1522:1521 --name demo_oracle \
--env-file=env.conf \
demo/oracle-xe-11g:latest
