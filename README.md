<h1 align="center">公共库</h1>

<p align="center">
    <a target="_blank" href="https://github.com/datachina/common">
        <img alt="stars" src="https://img.shields.io/github/stars/datachina/common?style=social"/>
    </a>
    <a target="_blank" href="https://opensource.org/licenses/MIT">
        <img alt="license" src="https://img.shields.io/github/license/datachina/common">
    </a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
        <img alt="jdk" src="https://img.shields.io/badge/JDK-11+-green.svg"/>
    </a>
    <a target="_blank" href="https://github.com/jidaojiuyou">
        <img alt="author" src="https://img.shields.io/badge/author-jidaojiuyou-ff3366.svg"/>
    </a>
</p>

## 说明

开发中总有很多重复工作要做。那为什么不将通用代码抽取出来呢?

最终我们决定做公共方法库。这就是common。

common目前分为3个模块。

- lang 只做常用方法,常用工具类
- web 封装一些通用web所需的类
- web-starter 封装Spring Boot/Spring Cloud 中常用方法。

## 仓库

目前暂时只在jitpack发布仓库。

### maven方式

1. 添加jitpack的库

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
	</repository>
</repositories>
```
2. 添加依赖(按需)

```
<dependency>
    <groupId>com.github.datachina.common</groupId>
    <artifactId>common-lang</artifactId>
    <version>自行替换版本号</version>
</dependency>

```

```
<dependency>
    <groupId>com.github.datachina.common</groupId>
    <artifactId>common-web</artifactId>
    <version>自行替换版本号</version>
</dependency>
```

```
<dependency>
    <groupId>com.github.datachina.common</groupId>
    <artifactId>common-web-spring-boot-starter</artifactId>
    <version>自行替换版本号</version>
</dependency>
```

### gradle方式

1. 添加jitpack的库

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

2. 添加依赖

```
dependencies {
        implementation 'com.github.datachina.common:common-lang:自行替换版本号'
}
```

```
dependencies {
        implementation 'com.github.datachina.common:common-web:自行替换版本号'
}
```

```
dependencies {
        implementation 'com.github.datachina.common:common-web-spring-boot-starter:自行替换版本号'
}
```

后续才可能会在maven等仓库发布

## 鸣谢

感谢所有对本库做出贡献的人(排名不分前后)

<p>
    <a target="_blank" href="https://github.com/jidaojiuyou">
        <img alt="author" src="https://img.shields.io/badge/author-jidaojiuyou-ff3366.svg"/>
    </a>
</p>

感谢所有开源作者。参考或使用的部分框架(排名不分前后)

<p>
    <a target="_blank" href="https://github.com/spring-projects/spring-boot">
        <img alt="Spring Boot" src="https://img.shields.io/badge/Framework-Spring%20Boot-00ff00.svg"/>
    </a> 
    <br>
    <a target="_blank" href="https://github.com/JetBrains/java-annotations">
        <img alt="Jetbrains Annotations" src="https://img.shields.io/badge/Library-jetbrains%20annotations-da834f.svg"/>
    </a>
    <br>
    <a target="_blank" href="https://github.com/projectlombok/lombok">
        <img alt="lombok" src="https://img.shields.io/badge/Library-lombok-00ff00.svg"/>
    </a>
    <br>
</p>

## 贡献代码

如果该库对你有帮助请右上角点点 Star,让更多人看到这个仓库。

如果你想贡献代码，请Fork、PR 成为项目贡献者。

## 文档

> 待完善表示文档暂时没有写 后面会补上

1. lang中的异常类用途。(待完善)
2. lang中的util使用示例。(待完善)
3. web中的 [ResultEntity](./common-web/src/main/java/com/data/common/web/response/ResultEntity.java) 和 [ResponseCode](./common-web/src/main/java/com/data/common/web/response/ResponseCode.java) 的用途。(待完善)
4. web-starter中的 [ConditionalOnMissingClassName](./common-web-starter/src/main/java/com/data/common/web/starter/annotation/ConditionalOnMissingClassName.java) 和 [OnMissingClassNameCondition](./common-web-starter/src/main/java/com/data/common/web/starter/condition/OnMissingClassNameCondition.java) 的用途。(待完善)
5. web-starter中的跨域配置 [CorsConfig](./common-web-starter/src/main/java/com/data/common/web/starter/config/CorsConfig.java)。(待完善)
6. web-starter中的jackson时间模块[JacksonModule](./common-web-starter/src/main/java/com/data/common/web/starter/jackson/JacksonModule.java)。 (待完善)
7. web-starter中的[ResponsePack](./common-web-starter/src/main/java/com/data/common/web/starter/annotation/ResponsePack.java) 和 [ResponseBodyAdviceImpl](./common-web-starter/src/main/java/com/data/common/web/starter/response/ResponseBodyAdviceImpl.java) 实现统一返回值。(待完善)
8. 使用 spring-boot-starter-validation 进行优雅的参数校验。(待完善)
9. 使用`@ExceptionHandler`全局异常拦截。(待完善)

## 版本变更

[版本变更记录](./CHANGELOG.md)