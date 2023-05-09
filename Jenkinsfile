pipeline {
    agent any
    tools { 
        maven 'maven-3.6.3' 
    }
    stages {
        stage('Checkout git') {
            steps {
               git branch: 'main', url: 'https://github.com/apexabhi/demo.git'
            }
        }
        
        stage ('Build') {
            steps {
                bat 'mvn clean install' 
            }
        }
    }
}
    
