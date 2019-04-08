pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               sh './gradlew build --no-daemon --stacktrace'
            }
        }
        stage('Test') {
            steps {
               sh './gradlew test --no-daemon --stacktrace'
            }
        }
    }
}