### 项目简介
由Maven重新搭建学生管理系统SHStudentManagementSystem，Hibernate升级至5，其余不变，代码稍作优化。
### 启动步骤
#### 本地启动步骤
1. 配置数据库环境，数据库使用Mysql8。首先创建mega_student_system数据库，字符集选择UTF-8，然后相关DDL和DML可以通过src\test\java\entity\InitDatabase.java中相关方法实现。
2. 安装Tomcat，因为Tomcat8默认不配置SSL，所以在IDEA中不要设置https启动端口，设置http启动端口为8888。
3. mvn war:war打包成war包，复制粘贴至tomcat webapps目录下，添加tomcat应用程序映射，再startup服务器http://localhost:8888/即可访问。
### 注意事项
1. struts2有安全隐患，能不用就不用，github都给出了提示。
2. jsp文件未放在WEB-INF下，故可以直接通过URL访问，有安全隐患。
3. 未结合Spring进行依赖注入。
4. 部分参数未做校验，如空指针校验、是否存在校验。