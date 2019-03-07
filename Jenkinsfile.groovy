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

					sshCommand remote: remote, command: "rm -rf xwfeng/"
					sshCommand remote: remote, command: "mkdir -p xwfeng/app"
					sshPut remote: remote, from: 'dist/', into: 'xwfeng/app', override: true
					// sshPut remote: remote, from: 'deploy/', into: '/root/xwfeng/', override: true
				}
			}
		}
	}
}
