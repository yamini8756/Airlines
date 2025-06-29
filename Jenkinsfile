pipeline {
    agent any

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                dir('airlines') {
                    bat 'mvnw.cmd clean install'
                }
            }
        }

        stage('Package') {
            steps {
                dir('airlines') {
                    bat 'mvnw.cmd package'
                }
            }
        }

        // Optional: Comment out Dockerhub stage if not using
        /*
        stage('Dockerhub') {
            steps {
                echo 'Push image to Dockerhub'
            }
        }
        */
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo '✅ Build succeeded'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}
