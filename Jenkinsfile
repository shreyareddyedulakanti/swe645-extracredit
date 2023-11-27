pipeline {
  agent any
  tools any {
  	maven 'Maven 3.9.5'
  }
  environment {
    dockerhubRegistry = "shreyare97/surveyformpage"
    dockerhubCred = 'docker'
  }
  stages {
    stage('Building the new jar file using maven') {
      steps {
        script {
          checkout scm
          sh 'mvn clean'
          sh 'mvn install'
          sh 'echo ${BUILD_TIMESTAMP}'
        }
      }
    }
    stage('Build docker Image') {
      steps {
        script {
          echo "Build docker image"
          echo "${dockerhubRegistry}"
          newDockerImage = docker.build("${dockerhubRegistry}:${BUILD_NUMBER}")
        }
      }
    }
    stage("Pushing Image to DockerHub") {
      steps {
        script {
          echo "Came to docker push"
          docker.withRegistry('', dockerhubCred) {
            newDockerImage.push()
          }
        }
      }
    }
    stage("Deploying to Rancher") {
      steps {
        sh "kubectl --kubeconfig='/home/ubuntu/.kube/config' set image deployment/hw3-form-backend-deployment container-0=shreyare97/surveyformpage:${BUILD_NUMBER} -n default"
      }
    }
  }
}