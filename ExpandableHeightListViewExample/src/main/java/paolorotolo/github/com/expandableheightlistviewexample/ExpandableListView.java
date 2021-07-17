package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.text.Font;
import ohos.hiviewdfx.HiLog;
import ohos.multimodalinput.event.KeyEvent;

import java.util.ArrayList;

public class ExpandableListView extends Ability {
    private ArrayList arrayList = new ArrayList<Integer>();

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_expandable_list_view);
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        Font font = new Font.Builder("myfont")
                .makeItalic(false)
                .setWeight(Font.BOLD)
                .build();
        text.setFont(font);
        ExpandableHeightListView expandableListView = (ExpandableHeightListView) findComponentById(ResourceTable.Id_expandable_listview);
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        expandableListView.setExpanded(true);
        expandableListView.setProvider(this, arrayList);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

}
