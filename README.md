--for install redis
docker run -d -p 6379:6379 -i -t redis:latest

--inside container
docker exec -it "name_container" sh

--inside redis
redis-cli

--see keys
KEYS *

--see values
HGETALL "key"
HGETALL "UserEntity:1"

POST
curl -i -d '{"id":1, "name": "DAZO", "salary": 10.500}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8082/user

curl -i -d '{"id":2, "name": "DAZO2", "salary": 12.500}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8082/user

GET - ALL
curl -i -H "Content-Type: application/json" \
-X GET http://localhost:8082/user

GET BY ID=1
curl -i -H "Content-Type: application/json" \
-X GET http://localhost:8082/user/1

PUT ID=2
curl -i -d '{"id":2, "name": "DAZO3", "salary": 13.500}' \
-H "Content-Type: application/json" \
-X PUT http://localhost:8082/user

DELETE ID=2
curl -i -H "Content-Type: application/json" \
-X DELETE http://localhost:8082/user/2