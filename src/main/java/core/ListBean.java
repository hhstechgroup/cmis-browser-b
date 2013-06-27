package core;

/**
 * Created with IntelliJ IDEA.
 * User: vladimir.ovcharov
 * Date: 6/26/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;


@ManagedBean(name = "listBean", eager = true)
@SessionScoped
public class ListBean implements Serializable {
    private List<User> users = new ArrayList<User>();

    public ListBean() {
    }

    @PostConstruct
    public void init() {
        User root = new User(1L, "root", "Ivanov");
        User rootChild1 = new User(2L, "rootChild1", "Ivanov");
        User rootChild2 = new User(3L, "rootChild2", "Petrov");
        root.addChild(rootChild1);
        root.addChild(rootChild2);

        users.add(root);
        User root2 = new User(4L, "root2", "Timkov");

        User root2Child1 = new User(5L, "root2Child1", "Senkov");
        root2.addChild(root2Child1);
        users.add(root2);

        User root3 = new User(6L, "root3", "Panov");
        users.add(root3);
    }

    public List<User> getUsers() {
        return users;
    }
}
