package paolorotolo.github.com.expandableheightlistviewexample.provider;

import com.github.paolorotolo.expandableheightlistview.Contants;
import ohos.agp.components.*;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import paolorotolo.github.com.expandableheightlistviewexample.ResourceTable;

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

    public GridViewProvider(ArrayList<Integer> arrayList, int columnCount) {
        this.list = arrayList;
        this.columnCount = columnCount;
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

    public void setItemWidth(int width) {
        this.width = width;
        notifyDataChanged();
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
            layoutConfig.width = width / columnCount;
            roorView.setLayoutConfig(layoutConfig);
        }
        text.setText(String.valueOf(list.get(position)));
        HiLog.info(Contants.LABEL, "text==" + width);
        return rootComponent;
    }
}
