# Makefile for MarkdownParse

# Step 1: make MarkdownParse.class and MarkdownParseTest.class
compile: MarkdownParse.java MarkdownParseTest.java
	javac MarkdownParse.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

# Step 2: run test cases in MarkdownParseTest.java
test: MarkdownParseTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest