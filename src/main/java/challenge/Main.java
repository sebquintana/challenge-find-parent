package challenge;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(parentFinder.findParent(root, a, b).getName());  // -> root
        System.out.println(parentFinder.findParent(root, c, d).getName());  // -> a
    }
}