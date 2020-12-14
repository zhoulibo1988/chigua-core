# chigua-core 核心组

## 工程结构
``` 
chigua-core
├── chigua-core-auth -- 授权中心
├── chigua-core-generator -- 代码生成封装模块
├── chigua-core-log -- 日志封装模块
├── chigua-core-mybatis -- mybatis拓展封装模块 
├── chigua-core-service -- 基础服务类 
├── chigua-core-swagger -- swagger拓展封装模块
├── chigua-core-tool -- 工具封装模块  
```
### chigua-core-auth（授权中心）

chigua-core-auth：采用springboot security oauth2 来进行授权与认证

操作如下：
```$xslt
利用postMan工具进行
1：启动服务访问获取token接口：http://localhost:8080/oauth/token
2：在Authorization选项添加参数->TYPE选择：Basic Auth; username:client; password:secret
3:在Headers选项添加参数->Content-Type:application/x-www-form-urlencoded
4:在Body选项添加参数->grant_type:password;username:admin;password:123456;captchaCode:XXXXXX
    其中
       1.grant_type 表示是密码模式
       2.username：账号
       3.password：密码
       4.captchaCode：验证码

``` 
如图：

Authorization：

<img src=http://chuantu.xyz/t6/741/1607917269x1700338641.png />

Headers：

<img src=http://chuantu.xyz/t6/741/1607917326x1700340463.png />

Body：

<img src=http://chuantu.xyz/t6/741/1607917369x1700340463.png />

结果：

<img src=http://chuantu.xyz/t6/741/1607917416x1033348159.png />


