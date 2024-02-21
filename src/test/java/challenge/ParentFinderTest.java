package challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParentFinderTest {

    @Test
    @DisplayName("Boilerplate test")
    public void testParentFinder() {
        File root = new File("root");
        File a = new File("a");
        File b = new File("b");
        File c = new File("c");
        File d = new File("d");

        root.addChild(a);
        root.addChild(b);
        a.addChild(c);
        a.addChild(d);

        ParentFinder parentFinder = new ParentFinder();

        assert(parentFinder.findParent(root, a, b).getName().equals("root"));
        assert(parentFinder.findParent(root, c, d).getName().equals("a"));
    }

    @Test
    @DisplayName("Files are not direct children of the same parent.")
    public void testFilesWithDifferentDirectParent() {
        File root = new File("root");
        File a = new File("a");
        File b = new File("b");
        File c = new File("c");
        File d = new File("d");
        File e = new File("e");
        File f = new File("f");

        root.addChild(a);
        a.addChild(b);
        a.addChild(c);
        c.addChild(d);
        b.addChild(e);
        b.addChild(f);

        ParentFinder parentFinder = new ParentFinder();

        assert(parentFinder.findParent(root, f, d).getName().equals("a"));
    }

    @Test
    @DisplayName("One file is null")
    public void testNullFile() {
        File root = new File("root");
        File a = new File("a");

        root.addChild(a);

        ParentFinder parentFinder = new ParentFinder();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parentFinder.findParent(root, a, null)
        });

        assert("Invalid input: One input is null".equals(exception.getMessage()));
    }

    @Test
    @DisplayName("The two files are the same")
    public void testTwoSameFiles() {
        File root = new File("root");
        File a = new File("a");
        File b = new File("b");

        root.addChild(a);
        root.addChild(b);

        ParentFinder parentFinder = new ParentFinder();

        assert(parentFinder.findParent(root, a, a).getName().equals("root"));
    }

    @Test
    @DisplayName("The two files in different filesystems")
    public void testTwoFilesOfDifferentFileSystems() {
        File root = new File("root");
        File admin = new File("admin");
        File a = new File("a");
        File b = new File("b");

        root.addChild(a);
        admin.addChild(b);

        ParentFinder parentFinder = new ParentFinder();

        assert(parentFinder.findParent(root, a, b) == null);
    }

}
