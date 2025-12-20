#!/bin/bash

cleanup() {
    cd mariadb
    sudo docker-compose down
    cd ..
    exit
}

trap cleanup SIGINT

echo "Start aplikacji todo-list..."

echo "Uruchomienie bazy danych MariaDB..."
cd mariadb
sudo docker-compose up -d
if [ $? -ne 0 ]; then
    exit 1
fi
cd ..

sleep 5

echo "Uruchomienie aplikacji"
./gradlew bootRun

cleanup
