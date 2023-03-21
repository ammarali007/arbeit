
build:
	mvn clean install

docker:
	docker build -t arbiet-application .

up: build docker
	docker-compose up -d

down:
	docker-compose down --rmi local