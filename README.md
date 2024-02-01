### Demo Spring boot 3 application with GraphQl

* Start db container
```shell
docker run --name psql -e POSTGRES_PASSWORD=postgres -d --rm -p 5432:5432 --health-cmd "pg_isready -U postgres" --health-interval=10s --health-timeout=10s --health-retries=5 postgres:14-alpine
```
* Create db for application
```shell
docker exec -it psql psql -U postgres -d postgres -c "create DATABASE test_graphql_db"
```

For testing, you can use `graphiql` console:

* For get all appliances: 
```graphql
query{
  getAppliances {
    id,
    amount,
    brand,
    equipment
  }
}
```
* For insert new item into db, we can use `mutation`:

```graphql
mutation {
  createNewAppliance(dto:{
    amount:5,
    brand: "Apple",
    equipment: "Iphone"
  }){
    id,
    amount,
    brand,
    equipment
  }
}
```
* For update exists appliance in db:
```graphql
mutation {
  updateAppliance(id:1, dto:{
    amount:10,
    brand: "Apple",
    equipment: "MacBook Pro"
  }){
    id,
    amount,
    brand,
    equipment
  }
}
```
* For remove exists appliance:
```graphql

mutation {
  deleteAppliance(id:1)
}
```