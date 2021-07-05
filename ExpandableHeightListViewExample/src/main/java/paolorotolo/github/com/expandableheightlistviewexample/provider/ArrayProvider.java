package paolorotolo.github.com.expandableheightlistviewexample.provider;

import com.github.paolorotolo.expandableheightlistview.Contants;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayProvider
 *
 * @author hw
 * @since 2021/6/1
 */
public class ArrayProvider<T> extends BaseItemProvider {
    private final Object mLock = new Object();
    private Context mContext;
    private AbilitySlice slice;
    private ArrayList<T> mOriginalValues;
    /**
     * The resource indicating what views to inflate to display the content of this
     * array adapter in a drop down widget.
     */
    private int mDropDownResource;

    /**
     * Contains the list of objects that represent the data of this ArrayProvider.
     * The content of this list is referred to as "the array" in the documentation.
     */
    private List<T> mObjects;

    /**
     * Indicates whether the contents of {@link #mObjects} came from static resources.
     */
    private boolean mObjectsFromResources;

    /**
     * Indicates whether or not {@link #notifyDataChanged()} must be called whenever
     * {@link #mObjects} is modified.
     */
    private boolean mNotifyOnChange = true;

    /**
     * The resource indicating what views to inflate to display the content of this
     * array adapter.
     */
    private final int mResource;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     */
    public ArrayProvider(Context context, int resource) {
        this(context, resource, 0, new ArrayList<>());
    }

    /**
     * Constructor. This constructor will result in the underlying data collection being
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public ArrayProvider(Context context, int resource, int textViewResourceId, T[] objects) {
        this(context, resource, textViewResourceId, Arrays.asList(objects));
    }

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public ArrayProvider(Context context, int resource,
                         int textViewResourceId, List<T> objects) {
        this(context, resource, textViewResourceId, objects, false);
    }

    private ArrayProvider(Context context, int resource, int textViewResourceId,
                          List<T> objects, boolean objsFromResources) {
        mContext = context;
        mResource = mDropDownResource = resource;
        mObjects = objects;
        mObjectsFromResources = objsFromResources;
    }

    /**
     * 添加数据
     *
     * @param object addObj
     */
    public void add(T object) {
        synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.add(object);
            } else {
                mObjects.add(object);
            }
            mObjectsFromResources = false;
        }
        if (mNotifyOnChange) {
            notifyDataChanged();
        }
    }

    @Override
    public int getCount() {
        return mObjects == null ? 0 : mObjects.size();
    }

    @Override
    public T getItem(int position) {
        if (mObjects != null && position >= 0 && position < mObjects.size()) {
            return mObjects.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public Component getComponent(int pos, Component component, ComponentContainer componentContainer) {
        final Component rootComponent;
        if (component == null) {
            rootComponent = LayoutScatter.getInstance(componentContainer.getContext()).parse(mResource, null,
                    false);
        } else {
            rootComponent = component;
        }
        Text text = (Text) rootComponent;
        final T item = getItem(pos);
        text.setText(item.toString());
        return rootComponent;
    }

}
