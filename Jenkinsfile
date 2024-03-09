pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checkout the code from the Github.Com'
                git branch: 'main', url: 'https://github.com/JitenPalaparthi/boa-jenkins-java-demo.git'
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
                sh 'docker build -t jpalaparthi/jenkinsdemo .'
            }
        }
        
         stage('docker push') {
            steps {
                echo 'Docker login'
              withCredentials([string(credentialsId: 'faddb1d6-5cfa-4b89-a4b6-b12b48afb000', variable: 'DOCKER_PASSWORD')]) {
                 sh 'docker login -u jpalaparthi -p "${DOCKER_PASSWORD}"'
                }
                sh 'docker push jpalaparthi/jenkinsdemo' 
              }
        }
    }
}
