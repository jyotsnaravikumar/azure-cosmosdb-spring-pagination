##A reference Java Spring-boot app showing CosmosDB pagination with Spring-data PagingSortingRepository

Clone the repository </br>  
Open a terminal in the local repo directory </br>  
git clone https://github.com/jyotsnaravikumar/azure-cosmosdb-spring-pagination </br>  
cd azure-cosmosdb-spring-pagination </br>  
mvn clean install </br>  
mvn spring-boot:run </br>  
curl -v http://localhost:8080/api/volcanoesbypage?pageNo=0&pageSize=10 </br>  
