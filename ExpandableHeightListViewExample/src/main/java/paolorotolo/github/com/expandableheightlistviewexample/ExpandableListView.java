package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.multimodalinput.event.KeyEvent;

import java.util.ArrayList;

public class ExpandableListView extends Ability {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_activity_expandable_list_view);

        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        ExpandableHeightListView expandableListView = (ExpandableHeightListView) findComponentById(ResourceTable.Id_expandable_listview);

        int i;
        for (i = 0; i <= 20; i++) {
            numbersArray.add(i);
        }

//        ArrayAdapter<Integer> itemsAdapter =
//                new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbersArray);
//
//        expandableListView.setAdapter(itemsAdapter);

        // This actually do the magic
        expandableListView.setExpanded(true);
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
