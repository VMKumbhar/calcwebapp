pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git url: 'https://github.com/rchidana/calcwebapp.git'    
		            echo "Code Checked-out Successfully!!";
            }
        }
        stage('Retrieve Git Info') {
            steps {
                // Execute git commands to retrieve information
                script {
                    // Get the commit ID of the last successful build
                    def lastSuccessfulCommit = bat(returnStdout: true, script: 'git rev-parse HEAD').trim()

                    // Get the commit ID of the current build
                    def currentCommit = bat(returnStdout: true, script: 'git rev-parse HEAD').trim()

                    // Get the changed files between the last successful commit and current commit
                    def changedFiles = bat(returnStdout: true, script: "git diff --name-only $lastSuccessfulCommit..$currentCommit").trim()

                    // Get the commit log between the last successful commit and current commit
                    def commitLog = bat(returnStdout: true, script: "git log --pretty=oneline $lastSuccessfulCommit..$currentCommit").trim()

                    // Print the retrieved information
                    println "Last Successful Commit: $lastSuccessfulCommit"
                    println "Current Commit: $currentCommit"
                    println "Changed Files:"
                    println changedFiles
                    println "Commit Log:"
                    println commitLog
                }
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

