# springboot-mongodb-docker
Deploying Spring Boot and MongoDB as Containers Using Docker and Docker Compose

**Steps & Commands**

- pull mongo image from docker hub `docker pull mongo:latest`
- run mongo image **`docker run -d -p 27017:27017 --name javaexploremongodb mongo:latest`
- dockerize spring boot application **`docker build -t springboot-mongodb:1.0 .`
- run spring boot docker image and link that container to mongo container 
  `docker run -p 8080:8080 --name springboot-mongodb --link javaexploremongodb:mongo -d springboot-mongodb:1.0`**
- check docker running containers  **`docker ps`** it should display two container ids
- check logs of spring boot image **`docker logs springboot-mongodb`**
- if all good access your api  :tada:
```bash
curl --location --request POST 'http://localhost:8080/books' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":1,
    "bookName":"corejava",
    "authorName":"Prabhat"
}'
```
- login to mongo terminal to verify records **`docker exec -it javaexploremongodb bash`
- type mongosh and enter
- show dbs
- use book
- show collections
- db.book.find().pretty()

**Use Docker Compose**

- [x] Kill running container:
```
docker rm <containerId>
```

#### docker-compose.yml

```yaml
version: "3"
services:
  javatechiemongodb:
    image: mongo:latest
    container_name: "javatechiemongodb"
    ports:
      - 27017:27017
  springboot-mongodb:
    image: springboot-mongodb:1.0
    container_name: springboot-mongodb
    ports:
      - 8080:8080
    links:
      - javatechiemongodb
```
- [x] navigate to resources folder:
```
springboot-mongo-docker/src/main/resources and run 

docker-compose up

- login to mongo terminal to verify records **`docker exec -it javaexploremongodb bash`
- type mongosh and enter
- show dbs
- use book
- show collections
- db.book.find().pretty()
```


------------------------------------------ STOP AND DELETE THE DOCKER IMAGE --------------

docker ps -a: To see all the running containers in your machine.
docker stop <container_id>: To stop a running container.
docker rm <container_id>: To remove/delete a docker container(only if it stopped).
docker image ls: To see the list of all the available images with their tag, image id, creation time and size.
docker rmi <image_id>: To delete a specific image.
docker rmi -f <image_id>: To delete a docker image forcefully
docker rm -f (docker ps -a | awk '{print$1}'): To delete all the docker container available in your machine
docker image rm <image_name>: To delete a specific image
To remove the image, you have to remove/stop all the containers which are using it.

docker system prune -a: To clean the docker environment, removing all the containers and images.
