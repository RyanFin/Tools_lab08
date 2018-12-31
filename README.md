# tools_lab08

COMPGS04/M024: Tools and Environments
Lab 8 (Continuous Integration)

c UCL 2015 wmjkucl November 27, 2017
This exercise is to be done individually by every group member.
Please note that you should do the lab work sheet in its entirety by continuing at home after the lab
session is over. If you are stuck, you can always ask for help in the next lab session.
Exercise 1 – Setup GitHub and project
We will migrate the Rational project (JUnit lab) from local testing environment to continuous integration environment. We select Travis CI as a continuous integration tool in this exercise. Travis CI is
free to use with open source projects and it integrates nicely with GitHub.
1. First, we need to configure a local installation of ANT. Try the following commands.
bash
cd
mkdir bin
cd bin
wget http://www-eu.apache.org/dist//ant/binaries/apache-ant-1.10.1-bin.zip
unzip apache-ant-1.10.1-bin.zip
rm apache-ant-1.10.1-bin.zip
export ANT_HOME=/cs/academic/phd3/<your CS username>/bin/apache-ant-1.10.1
export PATH=$ANT_HOME/bin:$PATH
2. Create a GitHub account at https://github.com/.
3. Create a new GitHub repository called “lab08”. Please select “Initialize this repository with a
README” before clicking the “Create repository” button. Then, clone it to your machine.
cd
git clone [the URL of your lab08 git repository]
4. Download the working implementation of the Rational project from
http://www0.cs.ucl.ac.uk/staff/C.Ragkhitwetsagul/gs04/rational.tar.gz.
cd
cd lab08
wget http://www0.cs.ucl.ac.uk/staff/C.Ragkhitwetsagul/gs04/rational.tar.gz
tar -xvf rational.tar.gz
rm rational.zip
5. Please make sure that your “Rational” directory has this structure:
1
COMPGS04/M024: Tools and Environments – Lab 8 (Continuous Integration)
Rational
|---README.md
|---Rational
|---build.xml
|---lib
| |---hamcrest.jar
| |---junit.jar
|---src
|---Rational.java
|---RationalTest.java
6. Go into the Rational project and try to invoke ant.
cd Rational
ant test
7. If the JUnit test cases are successfully executed, you are now ready to start integrating CI to
your project.
Exercise 2 – Install Travis CI
Install and setup Travis CI to your GitHub project by following the steps below.
1. Having logged in to GitHub, visit https://github.com/marketplace/category/continuous-integration.
You will see multiple continuous integration platforms available. Select “Travis CI”.
2. Click “Set up a plan” and then selected “Install it for free”.
3. You will be asked to confirm your installation. Travis CI is free for open source projects so the
order total must show $0. Click “Complete order and begin installation”.
4. Now you have installed Travis CI to your account and ready to integrate it into your project(s).
5. Visit https://travis-ci.org and login using your GitHub account.
6. Now you are going to enable Travis CI for your “lab08” project. Go to your profile picture on
the top right corner and select “Accounts”. You will see the Travis CI console.
7. In the Account page, you should see a list of all your GitHub projects. Flip the switch icon to
on (denoted by a green checkmark symbol) for “lab08”.
8. Go back to the main page by clicking on the Travis CI logo on the top left corner. You should
now see that the “lab08” project is listed on the left pane.
Exercise 3 – Setup Travis CI
You will create a setting file for Travis CI to execute the JUnit test cases in Rational via ant.
1. Travis CI requires a setting file called .travis.yml in the root of your repository. This setting
file will tell Travis CI what to do. Follow the steps below to create the .travis.yml file:
cd ˜/lab08
nano .travis.yml
2
COMPGS04/M024: Tools and Environments – Lab 8 (Continuous Integration)
2. Edit the file with the following content to run the JUnit test cases. More detailed information
of how to write the .travis.yml file can be found from the Travis CI website (https://docs.
travis-ci.com/user/getting-started).
language: java
before_install:
- cd Rational
jdk:
- oraclejdk8
script:
- ant test
3. Make sure the .travis.yml file resides in the root of your project directory as shown below.
Since files starting with a dot (‘.’) is hidden in Linux, you need to run ls -la to see the
.travis.yml.
lab08
|---.travis.yml
|---README.md
|---Rational
|---build.xml
|---lib
| |---hamcrest.jar
| |---junit.jar
|---src
|---Rational.java
|---RationalTest.java
4. Your project is now ready to build automatically using Travis CI every time you commit and
push your changes to GitHub.
Exercise 3 – Automated testing using Travis CI
1. Stage and commit the Rational project and the .travis.yml file to your GIT repository. Then,
push the changes to GitHub.
git add Rational
git add .travis.yml
git commit -m ‘‘Added Rational project and Travis CI setting file’’
git push origin master
2. Go back to the Travis CI console. You will now see that your commit is picked up by Travis CI
and your JUnit test is running. Note that the very first build with Travis CI might take some
time.
3. Make sure that your JUnit test cases are successfully executed.
Additional Exercise
Modify the Rational and the Travis CI setting file to use Maven instead of ant to run JUnit test.
3
