package challenge;

import java.util.ArrayList;
import java.util.List;

public class File {

    private String name;
    private String alias;
    private List<File> children;

    File(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    void addChild(File child) {
        this.children.add(child);
    }

    public List<File> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return name;
    }
}
