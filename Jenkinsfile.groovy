pipeline {
	agent any
	stages {
		stage("安装依赖") {
			steps {
				sh "npm install"
			}
		}

		stage("跑单元测试") {
			steps {
				sh "npm run test:unit"
			}
		}
	}
}
