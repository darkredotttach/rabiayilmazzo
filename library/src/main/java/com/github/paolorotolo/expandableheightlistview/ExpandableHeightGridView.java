package com.github.paolorotolo.expandableheightlistview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.app.Context;

public class ExpandableHeightGridView extends ListContainer implements Component.EstimateSizeListener{

    boolean expanded = false;

    public ExpandableHeightGridView(Context context) {
        super(context);
    }

    public ExpandableHeightGridView(Context context, AttrSet attrs) {
        super(context, attrs);
    }

    public ExpandableHeightGridView(Context context, AttrSet attrs, String defStyle) {
        super(context, attrs, defStyle);
        setEstimateSizeListener(this::onEstimateSize);
    }

    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public boolean onEstimateSize(int widthMeasureSpec, int heightMeasureSpec) {
//        if (isExpanded()) {
//            int expandSpec = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK, MeasureSpec.AT_MOST);
//            super.onMeasure(widthMeasureSpec, expandSpec);
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