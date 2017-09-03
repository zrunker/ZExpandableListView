package cc.ibooker.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.ibooker.zexpandablelistview.R;

/**
 * 二级列表
 * create by 邹峰立 on 2016/9/27.
 */
public class TimeLineExpAdapter extends BaseExpandableListAdapter {
    private LayoutInflater inflater = null;
    private List<TimeLineGroupData> groupList = new ArrayList<>();

    /**
     * 构造方法
     */
    public TimeLineExpAdapter(Context context, List<TimeLineGroupData> group_list) {
        this.groupList = group_list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 刷新数据
    public void flashData(List<TimeLineGroupData> datas) {
        this.groupList = datas;
        this.notifyDataSetChanged();
    }

    /**
     * 返回一级Item总数
     */
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 返回二级Item总数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupList.get(groupPosition).getChildList() == null) {
            return 0;
        } else {
            return groupList.get(groupPosition).getChildList().size();
        }
    }

    /**
     * 获取一级Item内容
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 获取二级Item内容
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    // 一级列表
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = inflater.inflate(R.layout.activity_timeline_group_item, parent, false);
            holder.stepTv = (TextView) convertView.findViewById(R.id.tv_step);
            holder.titleTv = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(groupList.get(groupPosition).getGstep());
        holder.stepTv.setText(groupList.get(groupPosition).getGtitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder viewHolder;
        TimeLineChildData entity = (TimeLineChildData) getChild(groupPosition, childPosition);
        if (convertView != null) {
            viewHolder = (ChildViewHolder) convertView.getTag();
        } else {
            viewHolder = new ChildViewHolder();
            convertView = inflater.inflate(R.layout.activity_timeline_child_item, parent, false);
            viewHolder.descTv = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        }
        viewHolder.descTv.setText(entity.getDesc());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class GroupViewHolder {
        TextView titleTv, stepTv;
    }

    private class ChildViewHolder {
        TextView descTv;
    }

}
