curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.11/install.sh | bash
source ~/.bashrc
nvm install v8.12.0
npm install --global http-server

kill -9 $(lsof -t -i:8081)
http-server app -p 8081