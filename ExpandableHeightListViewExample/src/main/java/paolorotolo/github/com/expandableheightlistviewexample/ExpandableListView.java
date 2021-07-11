package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.text.Font;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.multimodalinput.event.KeyEvent;
import com.github.paolorotolo.expandableheightlistview.provider.ArrayProvider;

import java.util.ArrayList;

public class ExpandableListView extends Ability {
    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");
    private ArrayList arrayList = new ArrayList<Integer>();

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_expandable_list_view);
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        Font font = new Font.Builder("myfont")
                .makeItalic(true)
                .setWeight(Font.BOLD)
                .build();
        text.setFont(font);
        ExpandableHeightListView expandableListView = (ExpandableHeightListView) findComponentById(ResourceTable.Id_expandable_listview);
//        ArrayProvider<Integer> itemsAdapter =
//                new ArrayProvider<Integer>(this, ResourceTable.Layout_simple_list_item);
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
//        expandableListView.setItemProvider(itemsAdapter);
        // This actually do the magic
//        expandableListView.setExpanded(true);
//        setListContainerHeightBasedOnChildren(expandableListView);
        expandableListView.setExpanded(true);
        expandableListView.setProvider(this, arrayList);
    }

    public void setListContainerHeightBasedOnChildren(ListContainer listContainer) {
        BaseItemProvider listAdapter = listContainer.getItemProvider();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            Component listItem = listAdapter.getComponent(i, null, listContainer);
            listItem.estimateSize(0, 0); // 获取item高度
            totalHeight += listItem.getEstimatedHeight();
        }

        ComponentContainer.LayoutConfig params = listContainer.getLayoutConfig();
        params.height = totalHeight + (listContainer.getPaddingTop() + listContainer.getPaddingBottom());
        listContainer.setLayoutConfig(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEY_BACK) {
            Intent intent = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("paolorotolo.github.com.expandableheightlistviewexample")
                    .withAbilityName("paolorotolo.github.com.expandableheightlistviewexample.MainAbility")
                    .build();
            intent.setOperation(operation);
            startAbility(intent);
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
