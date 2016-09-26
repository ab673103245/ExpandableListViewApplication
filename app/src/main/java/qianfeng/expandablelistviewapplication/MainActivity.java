package qianfeng.expandablelistviewapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView elv;
    private List<GroupBean> groupBeanList;
    private String[] gourpname = new String[]{"家人","同事","同学","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elv = ((ExpandableListView) findViewById(R.id.elv));
        initInfo(); // 数据源已经构造好了

        elv.setAdapter(new MyExpandBase(groupBeanList,this));

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,groupBeanList.get(groupPosition).getChildBeanList().get(childPosition).toString(),Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // 返回true ，屏蔽掉group的点击事件, 返回true，代表事件已经处理完，就不再让CPU执行OnChildClickListener方法。
                // 返回true，表示事件已经处理完。
                // 处理事件的顺序：肯定是先调用 setOnGroupClick------------->setOnChildClickListener
                return false;
            }
        });

        // 还有一个方法是，默认选项全部展开
        for(int i = 0;i<groupBeanList.size();i++)
        {
            elv.expandGroup(i);
        }
    }

    private void initInfo()
    {
        groupBeanList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            GroupBean groupBean = new GroupBean();
            List<ChildBean> childBeenList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                childBeenList.add(new ChildBean("李四:"+i,"签名：*****"+i));
            }
            groupBean.setGroupname(gourpname[i]);
            groupBean.setChildBeanList(childBeenList);
            groupBeanList.add(groupBean);
        }

    }
}
