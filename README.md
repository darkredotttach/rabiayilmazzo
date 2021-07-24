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

    implementation('com.gitee.chinasoft_ohos:boxedverticalseekbarlibrary:0.0.1-SNAPSHOT')

    ......  

 }

 ```

在sdk5，DevEco Studio2.1 beta3下项目可直接运行
如无法运行，删除项目.gradle,.idea,build,gradle,build.gradle文件，
并依据自己的版本创建新项目，将新项目的对应文件复制到根目录下
#### 使用说明

1.定义BoxedVertical
```java
 <com.example.boxedverticalseekbarlibrary.view.BoxedVertical
         ohos:id="$+id:boxSeekbar"
         ohos:height="match_parent"
         ohos:width="60vp"
         ohos:align_parent_bottom="true"
         ohos:below="$+id:dl_layout2"
         ohos:bottom_margin="30vp"
         ohos:horizontal_center="true"
         ohos:top_margin="30vp"
         hap:backgroundColor="#4b4b4b"
         hap:defaultValue="30"
         hap:enabled="true"
         hap:imageEnabled="true"
         hap:libCornerRadius="20"
         hap:max="100"
         hap:step="1"
         hap:progressColor="#fbfbfb"
         hap:textColor="#FF0000"
         hap:textEnabled="false"
         hap:defaulTextSize="14"
         hap:imgResourceMax="$media:ic_volume_up_black_48dp"
         hap:imgResourceMin="$media:ic_volume_off_black_48dp"
         hap:imgResourceDefault="$media:ic_volume_down_black_48dp"
         hap:touchDisabled="true"
```
2.使用方式
```java
        bv = (BoxedVertical) findComponentById(ResourceTable.Id_boxSeekbar);
        bv.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
            @Override
            public void onPointsChanged(BoxedVertical boxedPoints, final int points) {
                valueTextView.setText("Current Value is " + String.valueOf(points));
            }

            @Override
            public void onStartTrackingTouch(BoxedVertical boxedPoints) {

            }

            @Override
            public void onStopTrackingTouch(BoxedVertical boxedPoints) {

            }
        });
```
#### 测试信息

CodeCheck代码测试无异常

CloudTest代码测试无异常

火绒安全病毒安全检测通过

当前版本demo功能与原组件基本无差异

#### 版本迭代

- 0.0.1-SNAPSHOT

### 版权和许可信息

```
The library is a free software, you can use it, extended with no requirement to open source your changes. You can also make paid apps using it.

Pull requests are welcomed
```



