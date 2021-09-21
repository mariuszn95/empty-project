pipeline {
    agent any
    triggers { cron('* * * * *') }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/mariuszn95/empty-project.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                bat 'dotnet build'
            }

            post {
                always {
                    archiveArtifacts 'EmptyProject/bin/Debug/net5.0/*.dll'
                }
            }
        }
    }
}