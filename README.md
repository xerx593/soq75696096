# soq75696096
Demo project for [How to serve static content from an external location with spring-boot+security?](https://stackoverflow.com/q/75696096/592355)

### Prerequisites

JDK >=17

### Installation and Run

- Execute from command line:
  ```lang-bash
  ./mvnw clean spring-boot:run
  ```
- Browse to http://localhost:8080/
- (Authentication credentials: User is `user` and password will be logged to console (at each container start))
### Key Points

Image + favicon from external folder ([/external](./external))
- can be viewed
- by any (un-/athenticated) user

### Key Configuration
- [application.properties](./src/main/resources/appliaction.properties)
  ```lang-properties
  spring.web.resources.static-locations=file:./external/
  ```
- [App/Config](./src/main/java/com/stackoverflow/q75696096/Q75696096Application.java):
  ```lang-java
  //...
  .requestMatchers(toStaticResources().atCommonLocations()).permitAll()
  ```
  
### Thanks To

- https://memegenerator.net/instance/81819896/joe-dirt-dang-it-works-on-my-computer
- https://raw.githubusercontent.com/spring-projects/spring-petclinic/main/src/main/resources/static/resources/images/favicon.png
 
 for the images.

### Relevant Spring Guides

* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
