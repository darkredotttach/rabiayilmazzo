package com.github.paolorotolo.expandableheightlistview.provider;
/*

 * Copyright (C) 2021 Huawei Device Co., Ltd.

 * Licensed under the Apache License, Version 2.0 (the "License");

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *     http://www.apache.org/licenses/LICENSE-2.0

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.

 */

import com.github.paolorotolo.expandableheightlistview.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * 添加数据
     *
     * @param list addObj
     */
    public void add(ArrayList<T> list) {
        synchronized (mLock) {
            if (mOriginalValues != null) {
                mOriginalValues.addAll(list);
            } else {
                mObjects.addAll(list);
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
    public Optional<T> getItem(int position) {
        if (mObjects != null && position >= 0 && position < mObjects.size()) {
            return Optional.of(mObjects.get(position));
        }
        return Optional.empty();
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
        Component comLine = rootComponent.findComponentById(ResourceTable.Id_component);
        Text text = (Text) rootComponent.findComponentById(ResourceTable.Id_text);
        final Optional<T> item = getItem(pos);
        text.setText(item.get().toString());
        if (pos == getCount() - 1) {
            comLine.setVisibility(Component.HIDE);
        } else {
            comLine.setVisibility(Component.VISIBLE);
        }
        return rootComponent;
    }

}
