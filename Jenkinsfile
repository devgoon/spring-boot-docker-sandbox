pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                ./gradlew build
            }
        }
        stage('Test') {
            steps {
                ./gradlew test
            }
        }
    }
}