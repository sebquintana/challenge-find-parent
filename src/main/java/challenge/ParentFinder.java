package challenge;

import java.util.ArrayList;
import java.util.List;

public class ParentFinder {
    public File findParent(File filesystem, File file1, File file2) {

        if(filesystem == null || file1 == null || file2 == null) {
            throw new IllegalArgumentException("Invalid input: One input is null");
        }

        List<File> path1 = getPath(filesystem, file1);
        System.out.println("Path1: " + path1);
        List<File> path2 = getPath(filesystem, file2);
        System.out.println("Path2: " + path2);


        if(path1 == null || path2 == null) {
            System.out.println("One file is from a different filesystem");
            return null;
        }

        File parent = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()) - 1; i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            parent = path1.get(i);
        }
        System.out.println("Parent: " + (parent != null ? parent.getName() : "Parent not found"));
        return parent;
    }

    private List<File> getPath(File root, File target) {
        if (root == target) {
            List<File> path = new ArrayList<>();
            path.add(root);
            return path;
        }

        for (File child : root.getChildren()) {
            List<File> path = getPath(child, target);
            if (path != null) {
                path.addFirst(root);
                return path;
            }
        }
        return null;
    }
}
