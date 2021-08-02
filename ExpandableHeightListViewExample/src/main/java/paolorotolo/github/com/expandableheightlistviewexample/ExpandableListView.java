package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Text;
import ohos.agp.text.Font;
import ohos.multimodalinput.event.KeyEvent;

import java.util.ArrayList;

/**
 * @时间：2021/06/16
 * @描述：折叠效果
 */
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
        ExpandableHeightListView expandableListView = (ExpandableHeightListView) findComponentById
                (ResourceTable.Id_expandable_listview);
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        expandableListView.setExpanded(true);
        expandableListView.setProvider(this, arrayList);
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
