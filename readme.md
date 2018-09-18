注意:
一.访问静态资源时,默认路径就是resources/static目录为跟目录

二、开启idea自动热部署功能
1、CTRL + SHIFT + A --> 查找make project automatically --> 选中 
2、CTRL + SHIFT + A --> 查找Registry --> 找到并勾选compiler.automake.allow.when.app.running 
最后重启idea
二、使用spring-boot-1.3开始有的热部署功能
1、加maven依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
2、开启热部署
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>//该配置必须
            </configuration>
        </plugin>
    </plugins>
</build>
三、Chrome禁用缓存 
至此，在idea中就可以愉快的修改代码了，修改后可以及时看到效果，无须手动重启和清除浏览器缓存。

Springboot默认集成事物,只主要在方法上加上@Transactional即可