pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select branch', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Build') {
            steps {
                    // Get some code from a GitHub repository
                    git branch: "${params.BRANCH}", url: 'https://github.com/testershmester/SauceDemoQA19.git'

                    bat 'docker compose up -d'
            }
        }
//         stage('Reports') {
//             steps {
//                 script {
//                     allure([
//                         includeProperties: false,
//                         jdk: '',
//                         properties: [],
//                         reportBuildPolicy: 'ALWAYS',
//                         results: [[path: 'target/allure-results']]
//                     ])
//                 }
//             }
//         }
    }
}