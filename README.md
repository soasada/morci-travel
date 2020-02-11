# Morci travel agency

## Deploy project

1. Compile frontend

`mvn -U clean install -pl :morci-travel-frontend`

2. Package backend

`mvn -U clean test package -pl :morci-travel-api`

3. Run app

`mvn -U spring-boot:run -pl :morci-travel-api`

## Run acceptance tests

`mvn -U clean test -pl :morci-travel-acceptance-tests`