package cc.ibooker.zexpandablelistview;

import java.util.ArrayList;

/**
 * 一级列表数据类
 */
public class FatherData {
    private String title;
    private ArrayList<ChildrenData> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ChildrenData> getList() {
        return list;
    }

    public void setList(ArrayList<ChildrenData> list) {
        this.list = list;
    }
}
