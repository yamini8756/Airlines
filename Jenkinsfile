pipeline {
    agent any

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
    }

    tools {
        maven 'M3' // Make sure this matches your Jenkins Maven tool name
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
                    sh './mvnw clean install'
                }
            }
        }

        stage('Package') {
            steps {
                dir('airlines') {
                    sh './mvnw package'
                }
            }
        }

        // Optional: Comment this out if DockerHub push is not ready
        /*
        stage('Dockerhub') {
            steps {
                echo 'Push image to Dockerhub'
                // Add docker build/push logic here if needed
            }
        }
        */
    }

    post {
        always {
            node {
                cleanWs()
            }
        }
        success {
            echo '✅ Build succeeded'
        }
        failure {
            echo '❌ Build failed'
            // Remove this or configure email properly
            // mail to: 'admin@example.com', subject: 'Build failed', body: 'Check Jenkins!'
        }
    }
}
