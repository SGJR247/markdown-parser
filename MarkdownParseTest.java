import static org.junit.Assert.*; // Imports assert methods

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;               // Imports junit methods

public class MarkdownParseTest {  // creates new class for MarkdownParseTest
    @Test                         // Annotation to make following method a test case method
    public void addition() {      // New method created, called addition
        assertEquals(2, 1 + 1);   // Determines if expected value (2) and actual value (1 + 1) are equal
    }
    
    @Test
    public void testGetLinks() throws Exception {
        String[] expectedLinks = {"https://something.com", "some-thing.html"};
        
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);
        assertArrayEquals(expectedLinks, actualLinks.toArray()); 
    }
}