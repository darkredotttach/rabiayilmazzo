package paolorotolo.github.com.expandableheightlistviewexample;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;

public class MainAbility extends Ability implements Component.ClickedListener {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_main);
        findComponentById(ResourceTable.Id_bt_default).setClickedListener(this);
        findComponentById(ResourceTable.Id_bt_expandable).setClickedListener(this);
        findComponentById(ResourceTable.Id_bt_expandable_gridview).setClickedListener(this);
    }

    public void tryDefault() {
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("paolorotolo.github.com.expandableheightlistviewexample")
                .withAbilityName("paolorotolo.github.com.expandableheightlistviewexample.DefaultListView")
                .build();
        intent.setOperation(operation);
        startAbility(intent);

    }

    public void tryExpandable() {
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("paolorotolo.github.com.expandableheightlistviewexample")
                .withAbilityName("paolorotolo.github.com.expandableheightlistviewexample.ExpandableListView")
                .build();
        intent.setOperation(operation);
        startAbility(intent);
    }

    public void tryExpandableGridView() {
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder()
                .withDeviceId("")
                .withBundleName("paolorotolo.github.com.expandableheightlistviewexample")
                .withAbilityName("paolorotolo.github.com.expandableheightlistviewexample.ExpandableGridView")
                .build();
        intent.setOperation(operation);
        startAbility(intent);
    }

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_bt_default:
                tryDefault();
                break;
            case ResourceTable.Id_bt_expandable:
                tryExpandable();
                break;
            case ResourceTable.Id_bt_expandable_gridview:
                tryExpandableGridView();
                break;
        }
    }
}
