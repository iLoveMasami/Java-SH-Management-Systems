### 项目简介
由Maven重新搭建学生管理系统SHStudentManagementSystem，目前只生成了Maven项目的框架。
### 启动步骤
#### 本地启动步骤
1. 配置数据库环境，数据库使用Mysql8。首先创建mega_student_system数据库，字符集选择UTF-8，然后相关DDL和DML可以通过src\test\java\entity\InitDatabase.java中相关方法实现。