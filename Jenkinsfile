pipeline {
    agent any

    stages {
        stage('Clone Code') {
            steps {
                git 'https://github.com/yamini8756/Airlines'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
     }
    }
    }