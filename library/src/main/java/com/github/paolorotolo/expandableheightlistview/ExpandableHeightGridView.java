package com.github.paolorotolo.expandableheightlistview;

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
        initLayout();
    }

    private void initLayout() {
        manager = new TableLayoutManager();
        manager.setColumnCount(3);
        manager.setOrientation(HORIZONTAL);
        setLayoutManager(manager);
    }

    public void setAdapter(ArrayList<Integer> arrayList, int padding, int paddingPar) {
        GridViewProvider itemsAdapter =
                new GridViewProvider(context, arrayList, manager.getColumnCount(), padding + paddingPar);
        setItemProvider(itemsAdapter);
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

}