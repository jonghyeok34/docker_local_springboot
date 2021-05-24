db.createUser({user: 'DEMO', pwd: 'finotek1004!', roles:[{"role": 'dbOwner', "db": 'demo'}] });

// db.createCollection("access_token")
// expire 저장
// db.access_token.createIndex( { "expireDt": 1 }, { expireAfterSeconds: 0 } )