package cc.ibooker.timeline;

import java.util.List;

/**
 * 一级Item实体类
 * create by 邹峰立 on 2016/9/27.
 */
public class TimeLineGroupData {
    private String gtitle;
    private String gstep;
    /**
     * 二级Item数据列表
     **/
    private List<TimeLineChildData> childList;

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public String getGstep() {
        return gstep;
    }

    public void setGstep(String gstep) {
        this.gstep = gstep;
    }

    public List<TimeLineChildData> getChildList() {
        return childList;
    }

    public void setChildList(List<TimeLineChildData> childList) {
        this.childList = childList;
    }
}