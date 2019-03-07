pipeline {
	agent any

	stages {
		stage("") {
			steps{
				script{
					def remote = [:]
					remote.name = 'sit'
					remote.host = '119.27.186.251'
					remote.user = 'root'
					remote.password = 'Hml123456'
					remote.allowAnyHosts = true

					sshPut remote: remote, from: 'Jenkinsfile', into: 'brant', override: true
				}
			}
		}
	}
}
