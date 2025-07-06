# Board Project

This is a simple board toy project using HTML, CSS, and Spring Boot.

## Tech Stack

* **Backend:** Java 17, Spring Boot 3.4.0
* **Frontend:** HTML, CSS, Thymeleaf
* **Database:** MySQL
* **Build Tool:** Gradle

## Project Structure

```
/Users/song/Documents/self_project/board-project/
├───.gitignore
├───build.gradle
├───gradlew
├───gradlew.bat
├───LICENSE
├───README.md
├───settings.gradle
├───.git/...
├───.gradle/...
├───.idea/...
├───build/
│   ├───classes/...
│   ├───generated/...
│   ├───libs/...
│   ├───reports/...
│   ├───resources/...
│   ├───test-results/...
│   └───tmp/...
├───gradle/
│   └───wrapper/
│       ├───gradle-wrapper.jar
│       └───gradle-wrapper.properties
└───src/
    ├───main/
    │   ├───java/
    │   │   └───basic/
    │   │       └───boardproject/
    │   │           ├───BoardProjectApplication.java
    │   │           ├───controller/
    │   │           │   ├───PostController.java
    │   │           │   └───UserController.java
    │   │           ├───domain/
    │   │           │   ├───Posts.java
    │   │           │   └───Users.java
    │   │           ├───dto/
    │   │           │   ├───PostModifyDto.java
    │   │           │   ├───PostNewResponseDto.java
    │   │           │   ├───PostResponseAllDto.java
    │   │           │   ├───PostResponseOneDto.java
    │   │           │   ├───TestDto.java
    │   │           │   └───UserNewDto.java
    │   │           ├───repository/
    │   │           │   ├───PostRepository.java
    │   │           │   └───UserRepository.java
    │   │           └───service/
    │   │               ├───PostService.java
    │   │               ├───PostServiceTest.java
    │   │               ├───UserService.java
    │   │               └───UserServiceTest.java
    │   └───resources/
    │       ├───application.properties
    │       ├───static/
    │       │   ├───css/
    │       │   │   └───header_footer.css
    │       │   ├───image/
    │       │   │   ├───cat.png
    │       │   │   ├───loginCat.png
    │       │   │   └───luckyCat.png
    │       │   └───js/
    │       └───templates/
    │           ├───article.html
    │           ├───articleList.html
    │           ├───articletmp.html
    │           ├───luckyCat.html
    │           ├───modifyArticle.html
    │           ├───modifyArticletmp.html
    │           ├───newArticle.html
    │           ├───signUp.html
    │           └───signUptmp.html
    └───test/
        └───java/
            └───basic/
                └───boardproject/
                    └───BoardProjectApplicationTests.java
```

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/board-project.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd board-project
   ```
3. **Build the project:**
   ```bash
   ./gradlew build
   ```
4. **Run the application:**
   ```bash
   java -jar build/libs/app.jar
   ```
5. **Open your browser and go to:** `http://localhost:8080`