Running on different browser 
1) Open Config.properties
2) Enter ie or chrome, chrome is default choice

Running Cucumber tests from CLI
1) Navigate to Project Dir containing POM.xml
2) run mvn clean test -Dcucumber.options="src/main/java/features --tags @ui" for Assignment 1
3) mvn clean test -Dcucumber.options="src/main/java/features --tags @api"

Running Mocktest
1) Navigate to src/test/java/mocktest
2) Right click and run as Junit Test


For question and answers, refer to Answers.txt
