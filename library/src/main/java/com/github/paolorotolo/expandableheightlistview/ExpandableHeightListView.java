package com.github.paolorotolo.expandableheightlistview;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.components.TableLayoutManager;
import ohos.app.Context;
import com.github.paolorotolo.expandableheightlistview.provider.ArrayProvider;

import java.util.ArrayList;

public class ExpandableHeightListView extends ListContainer {

    boolean expanded = false;

    public ExpandableHeightListView(Context context) {
        this(context, null);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs) {
        this(context, attrs, null);
    }

    public ExpandableHeightListView(Context context, AttrSet attrs, String styleName) {
        super(context, attrs, styleName);
        init();
    }

    private void init() {
        if (expanded) {
            TableLayoutManager tableLayoutManager = new TableLayoutManager();
            tableLayoutManager.setColumnCount(1);
            tableLayoutManager.setOrientation(Component.HORIZONTAL);
            setLayoutManager(tableLayoutManager);
        }
    }

    public void setProvider(Context context, ArrayList<Integer> arrayList) {
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<Integer>(context, ResourceTable.Layout_simple_list_item);
        itemsAdapter.add(arrayList);
        setItemProvider(itemsAdapter);
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        invalidate();
    }

}