# 6小时精通spring mvc框架
- https://www.bilibili.com/video/BV1ZF411G7eP?p=2&vd_source=8159de0533e25413535c58268a8d2331
- https://pan.baidu.com/s/1Qemx79X7NTRbSqXBfJicnQ?pwd=l3ub

## 启动问题
- 配置tomcat插件
```
    <build>
        <plugins>
            <!--Tomcat插件 -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <port>5173</port><!--定义访问端口号 -->
                    <path>/</path><!--给访问路径取别名 -->
                </configuration>
            </plugin>
        </plugins>
    </build>
```
- 项目录下必须有webapp包
- 配置maven 命令行 tomcat7:run

## 热加载
1. 必须使用debug模式
2. 重新编译当前类 构建-当前类
- https://www.bilibili.com/video/BV1PV4y1R7ba/?vd_source=8159de0533e25413535c58268a8d2331

### .http请求文件


### 返回JSON格式问题
1. SpringMvcConfig.java配置
```
@EnableWebMvc // 开启转JSON功能
```
2. xml配置
```
   <!--解决No converter found for return value of type: class java.util.ArrayList-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.14.2</version>
        </dependency>
```

## SSM整合流程
1. 创建工程1.
2. SSM整合
   - Spring
     - SpringConfig
   - MyBatis
     - MybatisConfig
     - JdbcConfig
     - jdbc.properties
   - SpringMVC
     - ServletConfig
     - SpringMvcConfig
3. 功能模块表与实体类
   - dao(接口+自动代理 )
   - service(接口+实现类 )
     - 业务层接口测试(整合JUnit )
   - controller
     - 表现层接口测试(PostMan )