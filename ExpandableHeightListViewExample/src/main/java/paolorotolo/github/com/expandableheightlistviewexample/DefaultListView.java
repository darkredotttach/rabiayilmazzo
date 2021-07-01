package paolorotolo.github.com.expandableheightlistviewexample;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.ListContainer;
import ohos.multimodalinput.event.KeyEvent;

import java.util.ArrayList;

public class DefaultListView extends Ability {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_activity_default_list_view);

        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        ListContainer defaultListView = (ListContainer) findComponentById(ResourceTable.Id_default_listContainer);

        int i;
        for (i = 0; i < 20; i++) {
            numbersArray.add(i);
        }
//        Provider<Integer> itemsAdapter =
//                new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbersArray);
//
//        defaultListView.setAdapter(itemsAdapter);
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
