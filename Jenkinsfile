#!/usr/bin/env groovy
pipeline {
    // agent ("predixci-jdk-1.8")
    agent { label "predixci-jdk-1.8" }
    stages{
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }
    }
}