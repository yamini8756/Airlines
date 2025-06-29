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
                bat 'mvnw.cmd clean install'
            }
        }

        stage('Package') {
            steps {
                bat 'mvnw.cmd package'
            }
        }
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
