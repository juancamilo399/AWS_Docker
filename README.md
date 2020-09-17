# AWS

### Prerequisites

* [Docker](https://www.docker.com/) - Container Manager
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Development Environment 
* [Git](https://git-scm.com/) - Version Control System
* [Spark](http://sparkjava.com/) - Micro framework for creating web applications in Java 8


## Instrucciones de uso 

1. Clone the repository

```
git clone https://github.com/juancamilo399/AWS_Docker.git
```

2. Compile the projet

```
mvn package 
```

3. Executing the program (you must use the command from the root directory using Docker ToolBox)

```
docker-compose up -d --scale web=3
```

The application can be used from http://192.168.99.100:8088


## Test

Posting messages.

![img1](img/img1.PNG)


Content of the database.

![img2](img/img2.PNG)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](http://sparkjava.com/) - Micro framework for creating web applications in Java 8


## Author

* **Juan Camilo Angel Hernandez** 


## License

This project is under GNU General Public License - see the [LICENSE](LICENSE) file for details.
