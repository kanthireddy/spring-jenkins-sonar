pipeline {
    agent any

    tools {
        maven 'Maven3'   // Set name as defined in Jenkins global tools
        jdk 'JDK17'           // Set name as defined in Jenkins global tools
    }

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer' // Jenkins configured SonarQube instance name
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/kanthireddy/spring-jenkins-sonar.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Code Analysis - SonarQube') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SERVER}") {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=spring-jenkins-sonar'
                }
            }
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add deployment steps here
            }
        }
    }
}
