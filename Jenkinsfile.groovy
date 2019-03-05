pipeline {
	agent any
	stages {
		stage("install") {
			steps {
				echo "the shell script context is:"
				sh "pwd"
			}
		}
	}
}
