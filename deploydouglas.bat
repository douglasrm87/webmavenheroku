echo ______
echo Maven
echo ______
call mvn clean install
call mvn package
echo ______
echo Login
echo ______
call heroku login
echo ______
echo GIT
echo ______
call git init
call git config --global http.sslVerify false
call heroku git:remote -a webmavenheroku
call git add .
echo ______
echo GIT Commit
echo ______
call git commit -am "versao 1.0"
echo ______
echo GIT Push
echo ______
call git push heroku master
echo ______
echo Deploy FINAL
echo ______
call heroku plugins:install java
call heroku war:deploy target/webmavenheroku-0.0.1-SNAPSHOT.war --remote origin
echo ______

echo Fim do Deploy