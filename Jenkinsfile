pipeline {
    agent any

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
    }

    // Removed tools block — you are using ./mvnw, so no need for Jenkins Maven config

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

        // Optional: Commented out Dockerhub stage
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
            cleanWs() // ✅ runs within the pipeline's agent, no need to wrap with node
        }
        success {
            echo '✅ Build succeeded'
        }
        failure {
            echo '❌ Build failed'
            // mail step removed to avoid SMTP errors
        }
    }
}
