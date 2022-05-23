import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import java.io.IOException;                         

public class MarkdownParseTest {
    @Test                         
    public void addition() {
        assertEquals(12, 8 + 4);
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
        assertEquals(10, 20 / 2);
    }

    @Test
    public void testGetLinks3() throws Exception {
        String[] expectedLinks3 = {"https://www.dictionary.com/"};
        
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks3 = MarkdownParse.getLinks(content);
        assertArrayEquals(expectedLinks3, actualLinks3.toArray());
    }

    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("broken-image-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("thereallink.com"), links);
    }

    /*
    @Test
    public void testSnippet1() throws Exception {
        String[] expectedSnip1 = {"url.com", "`google.com", "google.com", "ucsd.edu"};

        Path fileName = Path.of("test-snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualSnip1 = MarkdownParse.getLinks(content);

        assertArrayEquals(expectedSnip1, actualSnip1.toArray());
    }

    @Test
    public void testSnippet2() throws Exception {
        String[] expectedSnip2 = {"a.com", "b.com", "a.com(())", "example.com"};

        Path fileName = Path.of("test-snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualSnip2 = MarkdownParse.getLinks(content);

        assertArrayEquals(expectedSnip2, actualSnip2.toArray());
    }

    @Test
    public void testSnippet3() throws Exception {
        String[] expectedSnip3 = {"https://www.twitter.com", 
                                  "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
                                  "https://cse.ucsd.edu/"};

        Path fileName = Path.of("test-snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualSnip3 = MarkdownParse.getLinks(content);
        
        assertArrayEquals(expectedSnip3, actualSnip3.toArray());
    }
    */
}