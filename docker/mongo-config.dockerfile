FROM mongo
MAINTAINER Nick Kras Borges
ADD . /files
WORKDIR /files
RUN mkdir -p /data/db && mongod --fork --logpath=/tmp/mongodb.log && sleep 20 && mongorestore --drop --db meubanco ./src/database/namedb/  #&& mongod --shutdown
EXPOSE 27017