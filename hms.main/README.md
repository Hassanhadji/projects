<h1> SEG3102 Project Group 25 </h1> 

<h2> Members: </h2>


Noah Ndahirwa : 300152285 <br>
email: `nndah090@uottawa.ca` <br>



Hassan Hadji-Ibrahim :300126629 <br>
email: `hhadj034@uottawa.ca` <br>

<h2> Added Dependencies: </h2>

    - ThymeLeaf : Templating Language 
    - Spring Web : Spring MVC, REST and Tomcat
    - Lombok : Lombok Annotation (May Need Lombok Compiler Plugin)
    - Cucumber : Testing Framework

<h2> Useful Commands </h2>

Run the project
```shell
gradlew bootRun
```

Run all the contracts (features) with command
```shell
gradlew test
```

The test reports are generated in folder
`build/reports/test` open `index.html`

To clean previous test results
```shell
gradlew cleanTest
```

<h2> Docker Commands </h2>

To build the docker file, run the following
```shell
docker build -t hmspms .
```
docker build will soon be deprecated, so if you have buildx, use
```shell
docker buildx build -t your-image-name .
```


To run the docker configuration after building
```shell
docker run -p 8080:8080 hmspms
```
