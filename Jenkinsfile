node {
   stage('Preparation') { 
      git 'https://github.com/Leela-Prasad/fleetman-position-tracker'
   }
   stage('Build') {
        sh "mvn package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('Deploy') {
      ansiblePlaybook credentialsId: 'SSH-Credentails', playbook: 'deploy.yaml'
   }
}
