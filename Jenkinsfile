pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select branch', name: 'BRANCH', type: 'PT_BRANCH'
        extendedChoice defaultValue: '@ui,@api', description: 'Select test tags to run:', name: 'CUCUMBER_OPTIONS', quoteValue: false, type: 'PT_CHECKBOX', value: '@ui,@api', visibleItemCount: 5
    }

    stages {
        stage('Initialize parameters') {
                    steps {
                         script {
                            if ("${params.CUCUMBER_OPTIONS}".contains("@ui") && "${params.CUCUMBER_OPTIONS}".contains("@api")) {
                                ${params.CUCUMBER_OPTIONS} = "-Dcucumber.filter.tags=@api or @ui"
                            } else {
                                ${params.CUCUMBER_OPTIONS} = "-Dcucumber.filter.tags=@ui"
                    }
                 }
             }
        }

        stage('Build') {
            steps {
                    git branch: "${params.BRANCH}", url: 'https://github.com/testershmester/SauceDemoDocker.git'
                    bat 'docker compose up --build --abort-on-container-exit'
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
