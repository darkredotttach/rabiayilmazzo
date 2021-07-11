package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightGridView;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentParent;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.TableLayoutManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import java.util.ArrayList;

public class ExpandableGridView extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "MY_TAG");
    private ExpandableHeightGridView gridListContainer;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_gridview_list);
        gridListContainer = (ExpandableHeightGridView) findComponentById(ResourceTable.Id_expandable_gridview);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        int padding = gridListContainer.getPaddingLeft() + gridListContainer.getPaddingRight();
        DirectionalLayout componentParent = (DirectionalLayout) gridListContainer.getComponentParent();
        int paddingPar = componentParent.getPaddingLeft() + componentParent.getPaddingRight();
        gridListContainer.setAdapter(arrayList, padding, paddingPar);
    }
}