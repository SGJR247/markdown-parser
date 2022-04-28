import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;                         

public class MarkdownParseTest {            
    @Test                         
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testGetLinks1() throws Exception {
        String[] expectedLinks1 = {"https://something.com", "some-thing.html"};
        
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks1 = MarkdownParse.getLinks(content);
        assertArrayEquals(expectedLinks1, actualLinks1.toArray()); 
    }

    @Test
    public void testGetLinks2() throws Exception {
        String[] expectedLinks2 = {"some-thing.html", "https://www.thesaurus.com/", 
                                  "https://www.dictionary.com/", "https://wordcounter.net/", 
                                  "https://www.desmos.com/calculator", "wumpa-islands.html", 
                                  "https://something.com"};
        
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks2 = MarkdownParse.getLinks(content);
        assertArrayEquals(expectedLinks2, actualLinks2.toArray()); 
    }

    @Test
    public void multiplication() {
        assertEquals(8, 2 * 2 * 2);
    }

    @Test
    public void division() {
        assertEquals(5, 12 / 2);
    }
}