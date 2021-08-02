package com.github.paolorotolo.expandableheightlistview;

import com.github.paolorotolo.expandableheightlistview.provider.GridViewProvider;
import ohos.agp.components.AttrSet;
import ohos.agp.components.ListContainer;
import ohos.agp.components.TableLayoutManager;
import ohos.app.Context;

import java.util.ArrayList;

/**
 * @时间：2021/06/16
 * @描述：不折叠自定义
 */
public class ExpandableHeightGridView extends ListContainer {
    private TableLayoutManager manager;
    private final Context context;
    private boolean expanded = false;

    public ExpandableHeightGridView(Context context) {
        this(context, null);
    }

    public ExpandableHeightGridView(Context context, AttrSet attrs) {
        this(context, attrs, null);
    }

    public ExpandableHeightGridView(Context context, AttrSet attrs, String defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    private void initLayout() {
        if (expanded) {
            manager = new TableLayoutManager();
            manager.setOrientation(HORIZONTAL);
            setLayoutManager(manager);
        }
    }

    /**
     * 设置适配器
     *
     * @param column     列
     * @param arrayList  集合数据
     * @param padding    左右间距
     * @param paddingPar 父容器左右间距
     */
    public void setProvider(int column, ArrayList<Integer> arrayList, int padding, int paddingPar) {
        if (manager != null) {
            manager.setColumnCount(column);
        }
        GridViewProvider itemsAdapter =
                new GridViewProvider(context, arrayList, column, padding + paddingPar);
        setItemProvider(itemsAdapter);
    }

    /**
     * 是否折叠
     *
     * @return boolean是否折叠
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     * 设置是否折叠
     *
     * @param expanded true折叠，false不折叠
     */
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        initLayout();
    }

}