pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                gradleTask('build', false, '--no-parallel')
            }
        }
        stage('Test') {
            steps {
                gradleTask('test', false, '--no-parallel')
            }
        }
    }
}