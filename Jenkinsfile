pipeline {
  agent any
  environment {
    IMAGE         = 'yamini8756/airlines'
    DOCKER_CRED   = credentials('dockerhub')
    KUBECONFIG_ID = 'kubeconfig-minikube'
  }
  stages {
    stage('1. Checkout') {
      steps { git url: 'https://github.com/yamini8756/Airlines.git', branch: 'main' }
    }
    stage('2. Build (Maven)') {
      steps { sh 'mvn clean package -DskipTests' }
    }
    stage('3. Build & Tag Docker') {
      steps {
        script {
          dockerImage = docker.build("${IMAGE}:${BUILD_ID}")
          sh "docker tag ${IMAGE}:${BUILD_ID} ${IMAGE}:latest"
        }
      }
    }
    stage('4. Push to Docker Hub') {
      steps {
        script {
          docker.withRegistry('', 'dockerhub') {
            dockerImage.push()
            dockerImage.push('latest')
          }
        }
      }
    }
    stage('5. Deploy to Kubernetes') {
      steps {
        withKubeConfig(credentialsId: "${KUBECONFIG_ID}") {
          sh 'kubectl apply -f k8s/'
          sh "kubectl set image deployment/airlines-app airlines=${IMAGE}:${BUILD_ID}"
        }
      }
    }
  }
  post {
    success {
      mail to: 'yaminiadiri8@gmail.com',
           subject: "✅ Build & Deploy #${BUILD_ID} Successful",
           body: "Your Airlines app is live!"
    }
    failure {
      mail to: 'yaminiadiri8@gmail.com',
           subject: "❌ Build #${BUILD_ID} Failed",
           body: "Check Jenkins logs."
    }
    always { cleanWs() }
  }
}
