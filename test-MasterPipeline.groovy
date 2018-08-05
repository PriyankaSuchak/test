@Library('pengg-openshift-pipelines') _

node('maven') {
    
    
    def buildEnv =  null 
    
    def deployEnv = null 

	
    stage('Checkout source') {
	
	   checkoutSource()

	}
 
	stage ('Build') {
          echo "start installing dependency"
          sh "pwd"
           sh "ls -ltr "
          echo " my command executed" 
	}
	
	stage ('Static Code Analysis') {
	
	   staticCodeAnalysis()
	
	}

	stage('Start OpenShift build') {
	   
           startOcpBinaryBuild(buildEnv)

	}
	
	stage('Scan Image') {
	   
           scanImage()

	}
	
	stage('Tag OpenShift Image') {
	   
           tagOcpImage()
	}

    	stage('Deploy to TPAAS') {
	   
           deployToOcp(deployEnv)

	}
	
	stage('Send Email Notification') {
	   
           sendEmailNotification()

	}
}
