package com.github.paolorotolo.expandableheightlistview.provider;
/*

 * Copyright (C) 2021 Huawei Device Co., Ltd.

 * Licensed under the Apache License, Version 2.0 (the "License");

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *     http://www.apache.org/licenses/LICENSE-2.0

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.

 */

import com.github.paolorotolo.expandableheightlistview.ResourceTable;
import ohos.agp.components.*;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * gridview适配器
 *
 * @author ：hw
 * @since ：2021/06/16
 */
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

    /**
     * 设置新的数据
     *
     * @param arrayList 新的集合数据
     */
    public void setNewArrayList(ArrayList<Integer> arrayList) {
        this.list = list;
        notifyDataChanged();
    }

    /**
     * 获取集合数据
     *
     * @return list集合
     */
    public List<Integer> getArrayList() {
        return list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Integer getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        final Component rootComponent;
        if (component == null) {
            rootComponent = LayoutScatter.getInstance(componentContainer.getContext()).parse(
                    ResourceTable.Layout_simple_grid_item, null, false);
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
