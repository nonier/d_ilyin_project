
Сервис для хранения информации о фильмах, актерах

#Запуск базы данных

docker build . -t film_service_postgres
docker run -p 5432:5432 -d film-service-postgres