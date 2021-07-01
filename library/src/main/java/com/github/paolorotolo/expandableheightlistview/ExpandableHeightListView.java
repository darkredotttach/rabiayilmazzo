package com.github.paolorotolo.expandableheightlistview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.app.Context;

public class ExpandableHeightListView extends ListContainer implements Component.EstimateSizeListener {

    boolean expanded = false;

    public ExpandableHeightListView(Context context) {
        super(context);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs) {
        super(context, attrs);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs, String styleName) {
        super(context, attrs, styleName);
        setEstimateSizeListener(this::onEstimateSize);
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public boolean onEstimateSize(int widthMeasureSpec, int heightMeasureSpec) {
//        if (isExpanded()) {
//            int expandSpec = EstimateSpec.getSizeWithMode(MEASURED_SIZE_MASK, EstimateSpec.NOT_EXCEED);
//
//            ViewGroup.LayoutParams params = getLayoutParams();
//            params.height = getMeasuredHeight();
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
        return false;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }


}