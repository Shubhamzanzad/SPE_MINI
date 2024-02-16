pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'calc'
        GITHUB_REPO_URL = 'https://github.com/Shubhamzanzad/SPE_MINI.git'
        PATH = ""
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }
        stage('Run Unit Test') {
            steps {
                dir('SPE_MINI') {
                    sh 'java -cp "lib/*:." org.junit.runner.JUnitCore appTest'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', 'DockerHubCred') {
                    sh 'docker tag calc zanzadshubham/calculator:latest'
                    sh 'docker push zanzadshubham/calculator'
                    }
                 }
            }
        }

   stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }
    }
}