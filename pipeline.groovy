pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Check out the code from the Git repository
                git url: 'https://github.com/yourusername/your-repo.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                // Use Gradle to build the project
                sh './gradlew clean build'
            }
        }
    }
    post {
        success {
            // Archive the JAR file
            archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            // Optionally, you can add a step to notify about success or deploy
            echo 'Build completed successfully.'
        }
        failure {
            // Notify about the failure
            echo 'Build failed!'
        }
    }
}