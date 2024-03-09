pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checkout the code from the Github.Com'
                git branch: 'main', url: 'https://github.com/nramprasad85/boa-jenkins-java-demo.git'
                // git branch: 'main', credentialsId: 'a8735a40-64ad-4bda-9047-75b09fe9361d', url: 'git@github.com:JitenPalaparthi/boa-jenkins-java-demo.git'
            }
        }
         stage('build') {
            steps {
                echo 'Maven build '
                sh 'mvn clean package'
                sh 'mvn test'
            }
        }
        stage('docker build') {
            steps {
                echo 'creating docker build'
                sh 'docker build -t ramprasad85/jenkinspipelinedemo .'
            }
        }
        
         stage('docker push') {
            steps {
                echo 'Docker login'
                withCredentials([string(credentialsId: 'b1b7440b-b287-4c85-9cc7-44396c103f18', variable: 'RAM_GIT_PASSWORD')]) {
                   sh 'docker login -u ramprasad85 -p "${RAM_GIT_PASSWORD}"'
                   sh 'docker push ramprasad85/jenkinspipelinedemo'
                }                
              }
        }
    }
}
