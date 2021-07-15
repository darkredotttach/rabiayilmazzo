package com.github.paolorotolo.expandableheightlistview;

import ohos.agp.components.*;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @时间：2021/06/03
 * @描述：gridview适配器
 **/
public class GridViewProvider extends BaseItemProvider {
    private final int columnCount;
    private List<Integer> list = new ArrayList();
    private int width;
    private int parentPadding;

    public GridViewProvider(Context context, ArrayList<Integer> arrayList, int columnCount, int parentPadding) {
        this.list = arrayList;
        this.columnCount = columnCount;
        this.parentPadding = parentPadding;
        width = DisplayManager.getInstance().getDefaultDisplay(context).get().getAttributes().width;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Integer getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        final Component rootComponent;
        if (component == null) {
            rootComponent = LayoutScatter.getInstance(componentContainer.getContext()).parse(ResourceTable.Layout_simple_grid_item, null,
                    false);
        } else {
            rootComponent = component;
        }
        Text text = (Text) rootComponent.findComponentById(ResourceTable.Id_text_grid);
        DirectionalLayout roorView = (DirectionalLayout) rootComponent.findComponentById(ResourceTable.Id_layout_root);
        if (width != 0) {
            DirectionalLayout.LayoutConfig layoutConfig = new DirectionalLayout.LayoutConfig();
            layoutConfig.width = (width - parentPadding) / columnCount;
            roorView.setLayoutConfig(layoutConfig);
        }
        text.setText(String.valueOf(list.get(position)));
        return rootComponent;
    }
}
