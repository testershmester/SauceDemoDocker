pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select branch', name: 'BRANCH', type: 'PT_BRANCH'
        extendedChoice defaultValue: '@ui,@api', description: 'Select test tags to run', name: 'TAGS', type: 'PT_CHECKBOX', value: '@ui,@api'
    }

    stages {
        stage('Initialize parameters') {
                    steps {
                         script {
                            if ("${params.TAGS}".contains("@ui") && "${params.TAGS}".contains("@api")) {
                                env.CUCUMBER_OPTIONS = "-Dcucumber.filter.tags=@api or @ui"
                            } else {
                                env.CUCUMBER_OPTIONS = "-Dcucumber.filter.tags=@ui"
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
    }
    post {
            always {
                cucumber buildStatus: 'UNSTABLE', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: '**/target/test-reports', pendingStepsNumber: -1, reportTitle: 'Test Result Report', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            }
        }
}
