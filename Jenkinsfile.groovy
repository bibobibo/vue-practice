pipeline {
	agent any
	stages {
		stage("install") {
			steps {
				echo "pwd"
				echo "install"
				sh "npm install"
			}
		}
		stage("scan") {
			steps {
				echo "scan"
				sh "npm run lint"
			}
		}
		stage("test") {
			steps {
				echo "test"
				sh "npm run test:unit"
			}
		}
		stage("build") {
			steps {
				echo "build"
				sh "npm run build"
			}
		}
		stage("deploy") {
			steps {
				echo "deploy"
			}
		}
	}
}
