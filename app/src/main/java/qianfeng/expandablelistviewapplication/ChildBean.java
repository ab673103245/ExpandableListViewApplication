package qianfeng.expandablelistviewapplication;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class ChildBean {

    private String username;
    private String usersign;

    public ChildBean(String username, String usersign) {
        this.username = username;
        this.usersign = usersign;
    }

    public ChildBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersign() {
        return usersign;
    }

    public void setUsersign(String usersign) {
        this.usersign = usersign;
    }

    @Override
    public String toString() {
        return "ChildBean{" +
                "username='" + username + '\'' +
                ", usersign='" + usersign + '\'' +
                '}';
    }
}
