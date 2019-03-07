pipeline {
	agent any
	stages {
		stage("install") {
			steps {
				echo "the shell script context is:"
				sh "pwd"
			}
		}

		stage("跑单元测试") {
			steps {
				sh "npm run test:unit"
			}
		}
	}
}
