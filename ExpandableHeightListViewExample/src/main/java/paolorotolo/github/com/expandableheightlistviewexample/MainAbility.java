package paolorotolo.github.com.expandableheightlistviewexample;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;
import ohos.agp.window.service.Window;

/**
 * 主页面
 *
 * @author ：hw
 * @since ：2021/06/16
 */
public class MainAbility extends Ability implements Component.ClickedListener {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        Window window = getWindow();
        window.setStatusBarColor(Color.BLACK.getValue());
        window.setStatusBarVisibility(Component.VISIBLE);
        setUIContent(ResourceTable.Layout_ability_main);
        findComponentById(ResourceTable.Id_bt_default).setClickedListener(this);
        findComponentById(ResourceTable.Id_bt_expandable).setClickedListener(this);
        findComponentById(ResourceTable.Id_bt_expandable_gridview).setClickedListener(this);
        Text title = (Text) findComponentById(ResourceTable.Id_title);
        title.setText(getString(ResourceTable.String_app_name));
    }

    /**
     * 跳转默认页
     */
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

    /**
     * 跳转可折叠页
     */
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

    /**
     * 跳转GridView页
     */
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
