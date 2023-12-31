package design_patterns.decorator;

import java.util.List;

public interface DecorableTree {
    List<List<String>> getTree();
    void display();
}
