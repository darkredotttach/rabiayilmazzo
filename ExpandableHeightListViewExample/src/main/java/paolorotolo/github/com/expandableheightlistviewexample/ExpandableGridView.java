package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightGridView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.TableLayoutManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import paolorotolo.github.com.expandableheightlistviewexample.provider.ArrayProvider;
import paolorotolo.github.com.expandableheightlistviewexample.provider.GridViewProvider;

import java.util.ArrayList;

import static ohos.agp.components.Component.HORIZONTAL;

public class ExpandableGridView extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "MY_TAG");
    private ExpandableHeightGridView gridListContainer;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_gridview_list);
        gridListContainer = (ExpandableHeightGridView) findComponentById(ResourceTable.Id_expandable_gridview);
        TableLayoutManager manager = new TableLayoutManager();
        manager.setColumnCount(3);
        manager.setOrientation(HORIZONTAL);
        gridListContainer.setLayoutManager(manager);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        GridViewProvider itemsAdapter =
                new GridViewProvider(arrayList, manager.getColumnCount());
        gridListContainer.setBindStateChangedListener(new Component.BindStateChangedListener() {
            @Override
            public void onComponentBoundToWindow(Component component) {
                HiLog.info(LABEL_LOG, "------" + gridListContainer.getWidth());
                int width = gridListContainer.getWidth();
                itemsAdapter.setItemWidth(width);
            }

            @Override
            public void onComponentUnboundFromWindow(Component component) {

            }
        });
        gridListContainer.setItemProvider(itemsAdapter);
    }

    @Override
    public boolean hasWindowFocus() {
        HiLog.info(LABEL_LOG, "------2" + gridListContainer.getWidth());
        return super.hasWindowFocus();
    }
}