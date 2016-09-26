package qianfeng.expandablelistviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class MyExpandBase extends BaseExpandableListAdapter {
    private List<GroupBean> groupBeenList;
    private Context context;
    private LayoutInflater inflater;

    public MyExpandBase(List<GroupBean> groupBeenList, Context context) {
        this.groupBeenList = groupBeenList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public MyExpandBase() {
    }

    @Override
    public int getGroupCount() {
        return groupBeenList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupBeenList.get(groupPosition).getChildBeanList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupBeenList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupBeenList.get(groupPosition).getChildBeanList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewGroupHolder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.group_item,parent,false);
            holder = new ViewGroupHolder();
            holder.tv_group = (TextView) convertView.findViewById(R.id.tv);
            holder.iv_group = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewGroupHolder) convertView.getTag();
        }
        if(isExpanded) // 如果是展开的
        {
            holder.iv_group.setImageResource(R.drawable.rounds_open);
        }else
        {
            holder.iv_group.setImageResource(R.drawable.rounds_close);
        }

        holder.tv_group.setText(groupBeenList.get(groupPosition).getGroupname());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewChildHolder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.child_item,parent,false);
            holder = new ViewChildHolder();
            holder.tv_username = (TextView) convertView.findViewById(R.id.username);
            holder.tv_usersign = (TextView) convertView.findViewById(R.id.usersign);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewChildHolder) convertView.getTag();
        }
        ChildBean childBean = groupBeenList.get(groupPosition).getChildBeanList().get(childPosition);
        holder.tv_username.setText(childBean.getUsername());
        holder.tv_usersign.setText(childBean.getUsersign());
        return convertView;
    }

    // 子item是否能被选择
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 点击child的item是否能点击，false表示不能点击，这里要改为true
        return true;
    }

    class ViewGroupHolder
    {
        TextView tv_group;
        ImageView iv_group;
    }
    class ViewChildHolder
    {
        TextView tv_username;
        TextView tv_usersign;
    }
}
