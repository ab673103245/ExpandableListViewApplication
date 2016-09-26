package qianfeng.expandablelistviewapplication;

import java.util.List;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class GroupBean {

    private String groupname;
    private List<ChildBean> childBeanList;

    public GroupBean(String groupname, List<ChildBean> childBeanList) {
        this.groupname = groupname;
        this.childBeanList = childBeanList;
    }

    public GroupBean() {
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<ChildBean> getChildBeanList() {
        return childBeanList;
    }

    public void setChildBeanList(List<ChildBean> childBeanList) {
        this.childBeanList = childBeanList;
    }

    @Override
    public String toString() {
        return "GroupBean{" +
                "groupname='" + groupname + '\'' +
                ", childBeanList=" + childBeanList +
                '}';
    }
}
