# 阿里云动态域名更新程序
 项目背景：电信宽带拨号获取的IP不固定，所以每次IP变动都需要进入阿里云控制台修改映射记录。
 该项目基于springboot-2.1.7，调用阿里云API，实现动态更新域名映射记录，保证本地服务稳定。
 
# 策略
 1.启动时校验域名解析是否匹配
 
 2.定期检查IP更新，默认每5分钟检查
 
 3.提供REST接口供外界手动更新
 
 4.每天凌晨4点检查IP更新
 
# 条件
 先申请阿里云域名的AccessKey
 > https://usercenter.console.aliyun.com/#/manage/ak
 
# 配置
配置文件路径: src/main/resources/application.yml

## 阿里云的accessKey配置：
> aliyun.accessKeyId

> aliyun.accessKeySecret

## 需要配置更新的域名
> aliyun.update.domains=xxx.xxx.top, xxx.xxx.com
> 有多个，请用英文逗号(,)分割

## 启动
1.SpringBoot启动： Run AliyunDomainApplication.java 

2.Docker启动：docker build -t okddns:v1 . && docker run --name onekook-okddns okddns:v1 

# 代码
本机公网ip通过IpUtil.java文件获取。
通过：http://2019.ip138.com/ic.asp 获取后解析。
如果该地址有变化，请及时更新。并修改解析方式

 
