# ExpandableHeightListView

#### 项目介绍
- 项目名称：ExpandableHeightListView
- 所属系列：openharmony的第三方组件适配移植
- 功能：ScrollView嵌套ListContainer不折叠
- 项目移植状态：主功能完成
- 调用差异：无
- 开发版本：sdk5，DevEco Studio2.1 Release
- 基线版本：Release 1.0.0

#### 效果演示

![输入图片说明](./printscreen/screenshot.gif)

#### 安装教程

1.在项目根目录下的build.gradle文件中，

 ```
allprojects {

    repositories {

        maven {

            url 'https://s01.oss.sonatype.org/content/repositories/snapshots/'

        }
    }
}

 ```

2.在entry模块的build.gradle文件中，

 ```

 dependencies {

    implementation('com.gitee.chinasoft_ohos:expandableHeightListView:0.0.1-SNAPSHOT')

    ......  

 }

 ```

在sdk5，DevEco Studio2.1 Release下项目可直接运行
如无法运行，删除项目.gradle,.idea,build,gradle,build.gradle文件，
并依据自己的版本创建新项目，将新项目的对应文件复制到根目录下
#### 使用说明

1.定义ExpandableListView
```java
<com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView
            ohos:id="$+id:expandable_listview"
            ohos:height="match_content"
            ohos:long_click_enabled="false"
            ohos:width="match_parent"
            ohos:padding="8vp">
</com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView>
```
2.使用ExpandableListView
```java
       ExpandableHeightListView expandableListView = (ExpandableHeightListView) findComponentById(ResourceTable.Id_expandable_listview);
       for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
       }
       expandableListView.setExpanded(true);
       expandableListView.setProvider(this, arrayList);
```
3.定义ExpandableGridView
```java
<com.github.paolorotolo.expandableheightlistview.ExpandableHeightGridView
            ohos:id="$+id:expandable_gridview"
            ohos:height="match_content"
            ohos:width="match_parent"
            ohos:long_click_enabled="false"
            ohos:padding="8vp">
</com.github.paolorotolo.expandableheightlistview.ExpandableHeightGridView>
```
4.使用ExpandableGridView
```java
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
```
#### 测试信息

CodeCheck代码测试无异常

CloudTest代码测试无异常

火绒安全病毒安全检测通过

当前版本demo功能与原组件基本无差异

#### 版本迭代

- 0.0.1-SNAPSHOT



