package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.provider.ArrayProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import org.junit.Test;

import java.util.ArrayList;

/**
 * ArrayProvider单元测试
 *
 * @author ：hw
 * @since ：2021/06/16
 */
public class ArrayProviderTest extends AbilitySlice {
    private final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");

    /**
     * 适配器添加int类型数据
     */
    @Test
    public void add() {
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<>(this, ResourceTable.Layout_simple_list_item);
        for (int i = 0; i < 20; i++) {
            itemsAdapter.add(i);
        }
        HiLog.info(label, "adapter int type=" + itemsAdapter.getCount());
    }

    /**
     * 适配器添加集合数据
     */
    @Test
    public void testAdd() {
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<>(this, ResourceTable.Layout_simple_list_item);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        itemsAdapter.add(arrayList);
        HiLog.info(label, "adapter list type=" + itemsAdapter.getCount());
    }
}