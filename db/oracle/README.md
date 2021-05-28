# Oracle 구동하기 

# start

```
docker run -d --name oracle -p 1522:1521 demo/oracle-xe-11g:latest
```
# 정보 

```sql
-- 1. 계정생성
CREATE USER DEMO  IDENTIFIED BY  "test1004"
DEFAULT TABLESPACE TS_DEMO
TEMPORARY TABLESPACE TS_DEMO_TEMP
QUOTA UNLIMITED ON TS_DEMO;

-- 2. 접속 권한주기
GRANT RESOURCE, CONNECT to DEMO;
-- 3 테이블스페이스 사용권한
GRANT UNLIMITED TABLESPACE TO DEMO;
```


```sql
-- 테이블 스페이스 생성
CREATE TABLESPACE TS_DEMO  datafile '/u01/app/oracle/oradata/XE/TS_DEMO.dbf' SIZE 100M AUTOEXTEND on next 100M;
-- 임시 테이블스페이스 생성
CREATE TEMPORARY TABLESPACE TS_DEMO_TEMP  TEMPFILE  '/u01/app/oracle/oradata/XE/TS_DEMO_TEMP.dbf' SIZE 100M AUTOEXTEND on next 10M;

```