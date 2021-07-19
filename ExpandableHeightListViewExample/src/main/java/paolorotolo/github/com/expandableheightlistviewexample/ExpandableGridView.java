package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightGridView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Text;
import ohos.agp.text.Font;
import ohos.multimodalinput.event.KeyEvent;
import java.util.ArrayList;

public class ExpandableGridView extends Ability {
    private ExpandableHeightGridView gridListContainer;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_gridview_list);
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        Font font = new Font.Builder("myfont")
                .makeItalic(false)
                .setWeight(Font.BOLD)
                .build();
        text.setFont(font);
        gridListContainer = (ExpandableHeightGridView) findComponentById(ResourceTable.Id_expandable_gridview);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        int padding = gridListContainer.getPaddingLeft() + gridListContainer.getPaddingRight();
        DirectionalLayout componentParent = (DirectionalLayout) gridListContainer.getComponentParent();
        int paddingPar = componentParent.getPaddingLeft() + componentParent.getPaddingRight();
        gridListContainer.setExpanded(true);
        gridListContainer.setProvider(3, arrayList, padding, paddingPar);
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