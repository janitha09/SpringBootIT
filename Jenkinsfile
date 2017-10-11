#!/usr/bin/env groovy
pipeline {
    // agent ("predixci-jdk-1.8")
    agent { label "predixci-jdk-1.8" }
    stages{
        stage('Build') {
            steps {
                sh "mvn clean install -Pcoverage"
            }
        }
        stage('Code Coverage') {
            steps {
                script {
                    step([$class: 'JacocoPublisher', execPattern: '**/target/coverage-reports/jacoco*.exec'])
                }
            }
        }
        stage('Sonar') {
            steps {
                sh "mvn sonar:sonar -Dsonar.host.url=https://i.ci.build.ge.com/janitha-jayaweera-ge-com/derm_sonarqube -Pcoverage"
            }
        }
    }
}