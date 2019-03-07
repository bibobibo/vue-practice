pipeline {
	agent any
	stages {
		stage("安装依赖") {
			steps {
				sh "npm install"
			}
		}

		stage("静态代码扫描") {
			steps {
				sh "npm run lint"
			}
		}

		stage("跑单元测试") {
			steps {
				sh "npm run test:unit"
			}
		}

		stage("构建打包") {
			steps {
				sh "npm run build"
			}
		}

		stage("部署上线") {
			steps {
				echo "部署上线"
			}
		}
	}
}
