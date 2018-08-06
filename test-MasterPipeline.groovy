node('nodejs') {

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
	
	   echo "doing code analysis"
	
	}

	stage('Start OpenShift build') {
	   
           echo "doing openshift builds"

	}
	
	stage('Scan Image') {
	   
           echo "doing image scan"

	}
	
	stage('Tag OpenShift Image') {
	   
           echo "tag image"
	}

    	stage('Deploy to Test') {
	   
           echo "deploy to cluster"

	}
	
	stage('Send Email Notification') {
	   
           echo "send email"

	}
}
