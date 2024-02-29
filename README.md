# poo241

Docker

Instalando Postgres via Docker:
``` shel
docker run --name my_post -e POSTGRES_USERNAME=espm -e POSTGRES_DB=espm -e POSTGRES_PASSWORD=espm -d postgres
```

Exemplo de Docker Compose
``` yaml
# docker compose up -d --build --force-recreate
version: '3.8'
name: espm

services:

  db-postgres:
    container_name: db-postgres
    image: postgres:latest
    ports:
      - 5432:5432
    environment:
      - POSTGRES_USER=espm
      - POSTGRES_PASSWORD=espm
      - POSTGRES_DB=espm
    volumes:
      - ./volume/postgres/data:/var/lib/postgresql/data
    networks:
      - private-network

  db-mysql:
    container_name: db-mysql
    image: mysql:latest
    networks:
      - private-network

  redis:
    container_name: db-redis
    image: redis:latest
    networks:
      - private-network

networks:
  private-network:
    driver: bridge
```