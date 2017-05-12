pipeline {
  agent any
  stages {
    stage('compile') {
      steps {
        sh 'echo "hello"'
      }
    }
    stage('echo') {
      steps {
        sh 'echo "hello"'
      }
    }
    stage('deploy') {
      steps {
        parallel(
          "deploy": {
            sh 'echo "deploying"'
            
          },
          "": {
            echo 'ich deploye jetzt'
            
          }
        )
      }
    }
  }
}