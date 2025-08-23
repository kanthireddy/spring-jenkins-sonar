pipeline {
    agent any

    tools{
      maven 'Maven'
      jdk 'JDK'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git url: 'https://github.com/kanthireddy/spring-jenkins-sonar.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Copy WAR to Deployment Server') {
            steps {
                // Assuming WAR is at target/app.war
                sh '''
                cp target/*.war /home/ubuntu/app.war
                '''
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                sh '''
                ansible-playbook -i  hosts deploy-maven-app.yml
                '''
            }
        }
    }
}

