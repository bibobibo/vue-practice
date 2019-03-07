pipeline {
	def remote = [:]
    remote.name = 'test'
    remote.host = 'test.domain.com'
    remote.user = 'root'
    remote.password = 'password'
    remote.allowAnyHosts = true
    stage('Remote SSH') {
      sshGet remote: remote, from: 'abc.sh', into: 'abc_get.sh', override: true
    }
}
