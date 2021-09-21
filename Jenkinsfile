pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        stage('Build') {
            steps {
                bat 'dotnet build'
            }
        }
    }

    post {
        always {
            archiveArtifacts 'EmptyProject/bin/Debug/net5.0/*.dll'
        }
    }
}