pipeline {
    agent any

    

    tools{
      maven 'Maven'
      jdk 'JDK'
    }

    environment {
        ANSIBLE_HOST = "ubuntu@34.221.144.250"
        SSH_KEY_ID = "ansible-key" // Jenkins credentials ID for SSH key
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


      stage('Deploy WAR using Ansible') {
    steps {
        sshagent (credentials: ['ansible-key']) {
            sh '''
                cd /home/ubuntu/ansible-deploy
                ansible-playbook -i hosts.ini deploy_tomcat.yml
            '''
        }
    }
}

    }
}

