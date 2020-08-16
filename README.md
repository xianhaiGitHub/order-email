# order-email
关注微信公众号:技术可期，查看更多公司项目实战干货<br />
异步多线程+设计模式构建发送订单邮件<br />
注意fork 代码到本地后，修改application.properties 文件里的数据库配置为你本人的，虽然本项目不需要数据库，但是不添加会报错<br />
#项目结构<br />
├─src<br />
│  ├─main<br />
│  │  ├─java<br />
│  │  │  └─com<br />
│  │  │      └─sea<br />
│  │  │          └─order<br />
│  │  │              ├─annotation    --自定义注解<br />
│  │  │              ├─common        -- 公共工具<br />
│  │  │              ├─components    -- 公共组件<br />
│  │  │              ├─config        -- 公共配置<br />
│  │  │              ├─controller    -- 视图层<br />
│  │  │              ├─dto           -- 业务DTO<br />
│  │  │              ├─event         -- 事件<br />
│  │  │              │  └─handler   -- 事件处理<br />
│  │  │              ├─factory       --工厂<br />
│  │  │              ├─service       -- 服务<br />
│  │  │              └─strategy      策略<br />
│  │  └─resources<br />
│  │      └─templates                -- 邮件模板<br />
│  └─test<br />
│      └─java<br />
│          └─com<br />
│              └─sea<br />
│                  └─order<br />
│                      └─service      -- 单元测试<br />
└─


如有问题请到QQ群交流:958435758<br />
![images](https://github.com/xianhaiGitHub/order-email/blob/master/images/T1.jpg)
