pipeline {
	agent any
	stages {
		// stage("install") {
		// 	steps {
		// 		echo "pwd"
		// 		echo "install"
		// 		sh "npm install"
		// 	}
		// }
		// stage("scan") {
		// 	steps {
		// 		echo "scan"
		// 		sh "npm run lint"
		// 	}
		// }
		// stage("test") {
		// 	steps {
		// 		echo "test"
		// 		sh "npm run test:unit"
		// 	}
		// }
		// stage("build") {
		// 	steps {
		// 		echo "build"
		// 		sh "npm run build"
		// 	}
		// }
		stage("deploy") {
			steps {
				script{
					def remote = [:]
					remote.name = 'sit'
					remote.host = '119.27.186.251'
					remote.user = 'root'
					remote.password = 'Hml123456'
					remote.allowAnyHosts = true

					sshCommand remote: remote, command: "rm -rf xwfeng"
					sshCommand remote: remote, command: "mkdir xwfeng"
					sshPut remote: remote, from: 'dist/', into: 'xwfeng', override: true
					sshCommand remote: remote, command: "mv xwfeng/dist xwfeng/app"
					sshPut remote: remote, from: 'deploy/deploy.sh', into: 'xwfeng', override: true
					sshCommand remote: remote, command: "chmod +x xwfeng/deploy.sh"
					sshCommand remote: remote, command: "cd xwfeng && nohup ./deploy.sh > /dev/null &"
					// sshScript remote: remote, script: "xwfeng/deploy.sh"
				}
			}
		}
	}
	post {
		always {
			// archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
		}
	}
}
