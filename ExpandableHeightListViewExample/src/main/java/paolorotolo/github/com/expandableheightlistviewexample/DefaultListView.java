package paolorotolo.github.com.expandableheightlistviewexample;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.agp.text.Font;
import ohos.multimodalinput.event.KeyEvent;
import com.github.paolorotolo.expandableheightlistview.provider.ArrayProvider;

public class DefaultListView extends Ability {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_default_list_view);
        Text text = (Text) findComponentById(ResourceTable.Id_text);
        Font font = new Font.Builder("myfont")
                .makeItalic(false)
                .setWeight(Font.BOLD)
                .build();
        text.setFont(font);
        ListContainer defaultListView = (ListContainer) findComponentById(ResourceTable.Id_default_listContainer);
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<>(this, ResourceTable.Layout_simple_list_item);
        for (int i = 0; i < 20; i++) {
            itemsAdapter.add(i);
        }
        defaultListView.setItemProvider(itemsAdapter);
    }

}
