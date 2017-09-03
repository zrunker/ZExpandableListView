package cc.ibooker.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cc.ibooker.zexpandablelistview.R;

/**
 * 申请代理流程
 * create by 邹峰立 on 2016/9/27.
 */
public class TimeLineActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView backImg;
    private ExpandableListView expandlistView;
    private TimeLineExpAdapter statusAdapter;

    private List<TimeLineGroupData> groupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        initView();
        setListData();
        setAdapter();
        initExpandListView();
    }

    // 初始化控件
    private void initView() {
        backImg = (ImageView) findViewById(R.id.img_back);
        if (backImg != null) {
            backImg.setOnClickListener(this);
        }
        expandlistView = (ExpandableListView) findViewById(R.id.expandlist);
    }

    /**
     * 自定义setAdapter
     */
    private void setAdapter() {
        if (statusAdapter == null) {
            statusAdapter = new TimeLineExpAdapter(this, groupList);
            expandlistView.setAdapter(statusAdapter);
        } else {
            statusAdapter.flashData(groupList);
        }
    }

    /**
     * 初始化可拓展列表
     */
    private void initExpandListView() {
        expandlistView.setGroupIndicator(null); // 去掉默认带的箭头
        expandlistView.setSelection(0);// 设置默认选中项

        // 遍历所有group,将所有项设置成默认展开
        int groupCount = expandlistView.getCount();
        for (int i = 0; i < groupCount; i++) {
            expandlistView.expandGroup(i);
        }

        expandlistView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }

    // 列表赋值
    private List<TimeLineGroupData> setListData() {
        if (groupList == null) {
            groupList = new ArrayList<>();
            // 一级列表数据
            for (int i = 0; i < 8; i++) {
                TimeLineGroupData timeLineGroupData = new TimeLineGroupData();
                timeLineGroupData.setGtitle("第" + i + "步");
                timeLineGroupData.setGstep("第" + i + "步的标题");
                // 二级列表数据
                ArrayList<TimeLineChildData> childDataList = new ArrayList<>();
                for (int j = 0; j < 2; j++) {
                    TimeLineChildData timeLineChildData = new TimeLineChildData();
                    timeLineChildData.setDesc("第" + i + "步描述" + j + "实现时间轴效果");
                    childDataList.add(timeLineChildData);
                }
                timeLineGroupData.setChildList(childDataList);
                groupList.add(timeLineGroupData);
            }
        }
        return groupList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:// 返回
                finish();
                break;
        }
    }

}