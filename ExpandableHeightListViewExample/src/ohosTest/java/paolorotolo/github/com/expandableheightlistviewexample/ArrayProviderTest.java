package paolorotolo.github.com.expandableheightlistviewexample;

import com.github.paolorotolo.expandableheightlistview.provider.ArrayProvider;
import ohos.aafwk.ability.AbilitySlice;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @时间：
 * @描述：
 **/
public class ArrayProviderTest extends AbilitySlice {
    @Test
    public void add() {
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<>(this, ResourceTable.Layout_simple_list_item);
        for (int i = 0; i < 20; i++) {
            itemsAdapter.add(i);
        }
        System.out.print("adapter添加完成int类型数据=" + itemsAdapter.getCount());
    }

    @Test
    public void testAdd() {
        ArrayProvider<Integer> itemsAdapter =
                new ArrayProvider<>(this, ResourceTable.Layout_simple_list_item);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        itemsAdapter.add(arrayList);
        System.out.print("adapter添加完成集合类型数据=" + itemsAdapter.getCount());
    }
}