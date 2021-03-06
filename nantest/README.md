在局域网环境下，使用一台设备作为中心设备，其他设备下载中心设备的文件 技术可行，DEMO已在测试设备上跑通。
测试过程：
1. 使用一台手机作为中心设备，连接abupdate的wifi，共享其sdcard下100MB的文件；
2. 其他设备连接同样的wifi，通过URL（如：http://172.18.7.175:8089/storage/emulated/0/update.zip）下载此文件；
3. 统计下载数据；

测试结果：
1. 此局域网下所有手机都能下载此文件；
2. 下载速度和设备性能有关，性能好的设备，平均下载速度可以达到2MB/s，性能差的设备，平均下载速度为0.3~0.7MB/s；
3. 中心设备的性能同样影响最大上行速度。性能好的中心设备的上行速度可大5MB/s，性能差的设备最大为2MB/s;
4. 多台设备并行下载,对速度也会产生影响。目前使用了5台设备同时下载，虽平均速度较慢，但还算稳定，未出现下载失败的情况；


## 方案一
1. 在后台页面【升级推送】中添加推送类型为“局域网升级推送”，指定一批待升级的设备和一个用作共享设备的A；
2. 后台先推送消息1给设备A，设备A收到消息后先执行检测版本，下载安装包，将局域网文件地址消息（URL、Length、MD5） PUSH给后台；
3. 后台收到URL后，将消息2（携带地址消息）推送给待升级的的设备，待升级的设备收到此类消息后从局域网路径下载此安装包；
4. 每台待升级的设备下载结果、安装结果后，都实时将处理消息push给后台，后台页面可以看到推送任务的处理过程。

说明：
1： 在设备较多的情况下，一个设备作为共享设备处理速度较慢，可以根据根据设备总数分配共享设备，比如：每10台设备分配一台共享设备；此需要服务器有一套策略来管理；
2： 待升级的设备如何保障升级包的一致性，需要在收到消息2后进行检测版本，匹配check下发的versionInfo中的md5和消息2中的md5是否一致，一致才进行后续流程；

优点：
1. 不影响原有的http业务线，只需要指定mqtt协议开辟新的业务线；
2. 傻瓜式操作，不需要客户过多配置；

缺点：
1. 过于依赖MQTT推送；
2. 改动较大；有一些流程处理起来较为复杂，如[说明1]中的管理策略；
3. 同批设备配置多次推送任务出现的冲突问题；

## 方案二
1. 通过添加后台子项目，批量上传局域网下的mid，同时由客户配置下载的url。

说明：此批mid只能通过客户配置的这个url进行下载。从而实现这批设备从局域网url下载的效果；

优点：
1. 改动最小；
2. 用户可控；

缺点：
1. 对客户的要求较高，需要客户过多参与配置，如配置下载url；
2. 这批mid检测到新版本后，每个版本关系返回的下载路径都是这个url；
3. 若设备较多，可能需要将这批设备分成多批，配置不同的url； 

## 方案三
1. 在【版本管理/升级策略】中，增加局域网升级的策略配置，用户可上传一批mid和配置下载的url；

说明：此方案对比方案二，解决了[方案二]中存在的[缺点2]的问题，让url跟随版本关系变化；