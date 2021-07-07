package com.github.paolorotolo.expandableheightlistview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.ListContainer;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;

public class ExpandableHeightListView extends ListContainer implements Component.EstimateSizeListener {

    boolean expanded = false;
    private int maxHeight;

    public ExpandableHeightListView(Context context) {
        this(context, null);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs) {
        this(context, attrs, null);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs, String styleName) {
        super(context, attrs, styleName);
//        setEstimateSizeListener(this::onEstimateSize);
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public boolean onEstimateSize(int widthEstimatedConfig, int heightEstimatedConfig) {
//        if (isExpanded()) {
//            measureChildren(widthEstimatedConfig, heightEstimatedConfig);
//            int expandSpec = EstimateSpec.getSizeWithMode(EstimateSpec.ESTIMATED_STATE_BIT_MASK, EstimateSpec.NOT_EXCEED);
//            ComponentContainer.LayoutConfig params = getLayoutConfig();
//            params.height = maxHeight;
//            super.setEstimatedSize(widthEstimatedConfig, expandSpec);
//            HiLog.info(Contants.LABEL, "daying==" + params.height);
//        } else {
//            super.setEstimatedSize(widthEstimatedConfig, heightEstimatedConfig);
//        }
        return false;
    }

    private void measureChildren(int widthEstimatedConfig, int heightEstimatedConfig) {
        for (int idx = 0; idx < getChildCount(); idx++) {
            Component childView = getComponentAt(idx);
            if (childView != null) {
                measureChild(childView, widthEstimatedConfig, heightEstimatedConfig);
            }
        }
    }

    private void measureChild(Component child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ComponentContainer.LayoutConfig lc = child.getLayoutConfig();
        int childWidthMeasureSpec = EstimateSpec.getChildSizeWithMode(
                lc.width, parentWidthMeasureSpec, EstimateSpec.NOT_EXCEED);
        int childHeightMeasureSpec = EstimateSpec.getChildSizeWithMode(
                lc.height, parentHeightMeasureSpec, EstimateSpec.NOT_EXCEED);
        child.estimateSize(childWidthMeasureSpec, childHeightMeasureSpec);
        maxHeight += child.getEstimatedHeight();
        System.out.print("maxHeight==" + maxHeight);
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }


}