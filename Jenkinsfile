pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git url: 'https://github.com/rchidana/calcwebapp.git'    
		            echo "Code Checked-out Successfully!!";
            }
        }
        stages {
        stage('Git Diff') {
            steps {
                // Checkout the repository
                git branch: 'master', url: 'https://github.com/rchidana/calcwebapp.git'
                
                // Run git diff command to get the changes
                bat 'git diff'
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package'    
		            echo "Maven Package Goal Executed Successfully!";
            }
        }
        
        stage('JUNit Reports') {
            steps {
                    junit 'target/surefire-reports/*.xml'
		                echo "Publishing JUnit reports"
            }
        }
        
        stage('Jacoco Reports') {
            steps {
                  jacoco()
                  echo "Publishing Jacoco Code Coverage Reports";
            }
        }

	stage('SonarQube analysis') {
	    steps {
	        withSonarQubeEnv(installationName: 'sq1') {
	            bat "mvn clean verify sonar:sonar -Dsonar.projectKey=sonarcodecoverage -Dsonar.projectName='sonarcodecoverage'"
		}
            }
        }
    }
    post {
        
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
    
     }
  }

