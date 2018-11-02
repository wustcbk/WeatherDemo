基于mvvm框架的高德天气App；

功能点说明：
1. 高德天气API：文档参照：https://lbs.amap.com/api/webservice/guide/api/weatherinfo/
   实现情况：Get&Post方式可以正常返回查询数据并UI显示；
2. MVVM框架，文档参照：Android Architecture Components：https://developer.android.google.cn/topic/libraries/architecture/
3. LiveData： 实现View与ViewModel 数据交互解耦（TBD）；
4. WorkManager： 文档参照：https://www.jianshu.com/p/444eb98724e8
5. AdMob&Firebase（广告和统计）：文档参照：https://www.jianshu.com/p/dcebf2c7c9e3
6. 高德XML文件解析：转为本地存储高德adcode和城市信息对照表，用于本地天气动态查询api调用（TBD）；

备注说明：部分业务机制借鉴网络资源，不能用于商业用途，转载请注明出处，谢谢！ 
