# saas平台权限管理系统
## 软件要求
mysql8.0以上
## 技术框架
   |spring boot| shiro|jdk|
   |--------| -----:|-----:|
   |2.3.1.RELEASE|1.4.0|1.8|
## 使用步骤
 **步骤1** 通过doc/sql/auth.sql来初始化表结构
 ### 默认用户-角色-权限关系表
 |用户|角色|权限|
 |---- |----|----|
 |admin|超级管理员|select;save;delete;update|
 |jack|管理员|select;save;update|
 |marry|普通用户|select|
 **步骤2** : 
    访问swagger http://localhost:8090/swagger-ui.html
    ![image](https://raw.githubusercontent.com/kiwi-field/auth/github/image/swagger.png)
  **步骤3**:
    通过登录接口,获取一个Token，默认12小时失效<br>
  **步骤4**:
    根据步骤1中的表格，通过testController可以测试用户是否具有某个角色或者具有某个资源的权限<br>  
## todo
  目前表结构没有按照公司来划分、后续再添加      
