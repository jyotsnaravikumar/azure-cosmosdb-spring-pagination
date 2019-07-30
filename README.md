## A reference Java Spring-boot app showing CosmosDB pagination with Spring-data PagingSortingRepository

### Steps to use
git clone https://github.com/jyotsnaravikumar/azure-cosmosdb-spring-pagination </br>  
cd azure-cosmosdb-spring-pagination </br>  
mvn clean install </br>  
mvn spring-boot:run </br>  
 
### Steps to test
curl -v http://localhost:8080/api/volcanoesbypage?pageNo=0&pageSize=10 </br>  
