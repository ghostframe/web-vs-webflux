start "Slow External API" mvn -f slow-api/pom.xml spring-boot:run
start "Spring Web" mvn -f web-server/pom.xml spring-boot:run
start "Spring Webflux" mvn -f webflux-server/pom.xml spring-boot:run