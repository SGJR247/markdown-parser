# Makefile for MarkdownParse
CLASSPATH = lib/*:.
# Step 1: make MarkdownParse.class
MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

# Step 2: make MarkdownParseTest.class
MarkdownParseTest.class: MarkdownParseTest.java	
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

# Step 3: run test cases in MarkdownParseTest.java
test: MarkdownParseTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java

