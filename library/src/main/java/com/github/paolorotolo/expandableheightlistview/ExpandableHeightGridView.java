package com.github.paolorotolo.expandableheightlistview;

import com.github.paolorotolo.expandableheightlistview.provider.GridViewProvider;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.ArrayList;

public class ExpandableHeightGridView extends ListContainer {

    private final Context context;
    boolean expanded = false;
    private TableLayoutManager manager;

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

    public void setProvider(int column, ArrayList<Integer> arrayList, int padding, int paddingPar) {
        if (manager != null) {
            manager.setColumnCount(column);
        }
        GridViewProvider itemsAdapter =
                new GridViewProvider(context, arrayList, column, padding + paddingPar);
        setItemProvider(itemsAdapter);
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        initLayout();
    }

}