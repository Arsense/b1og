---
title: No.1一步步学习vuejs 环境配置安装篇
date: 2018-02-07 16:11:14
tags: vuejs
categories: vue.js
copyright: true
---

## 一 安装与配置

需要安装node.js和 nmp管理器
http://nodejs.cn/
安装完后测试输入命令查看版本验证
`node -v  `           //查看node.js的版本
`npm -v `               //查看

![](https://i.imgur.com/pyW8ATM.png)

由于有些npm有些资源被屏蔽或者是国外资源的原因，经常会导致用npm安装依赖包的时候失败，所有我还需要npm的国内镜像---cnpm

![](https://i.imgur.com/ab7Sb7k.png)

4. Cmd命令行中输入
` npm install -g cnpm --registry=http://registry.npm.taobao.org`

5.安装vue-cli脚手架构建工具

输入命令  `npm install -g vue-cli`

![](https://i.imgur.com/zyTBpVY.png)
在VueJs目录下，运行命令vue init webpack firstVue。其中，webpack是构建工具、模块打包器，也就是整个项目是基于webpack的。其中，firstVue是项目文件夹的名称，这个文件夹会自动生成在vuejs这个工作目录中。

![](https://i.imgur.com/kSxv96S.png)

 6. cd到我们的项目文件夹firstVue中，运行命令cnpm install 安装包,(注意：我们已经使用淘宝镜像cnpm)
7. 安装完之后，我们发现项目文件夹下多了一个node_modules目录，里面就是项目依赖包资源
进入项目，安装并运行：
$ `cd my-project`
$ `cnpm install`
$` cnpm run dev`
 DONE  Compiled successfully in 4388ms

![](https://i.imgur.com/PCVbLJX.png)​
> `Listening at http://localhost:8080`


访问 localhost:8080


![](https://i.imgur.com/pxPAlpg.png)

## 测试模板

```html

<!DOCTYPE html>
	<html>
	<head>
	<meta charset="utf-8">
	<title>Vue 测试实例 - 菜鸟教程(runoob.com)</title>
	<script src="https://cdn.bootcss.com/vue/2.4.2/vue.min.js"></script>
	</head>
	<body>
	<div id="app">
	  <p>{{ message }}</p>
	</div>
	
	<script>
	new Vue({
	  el: '#app',
	  data: {
	    message: 'Hello Vue.js!'
	  }
	})
	</script>
	</body>
	</html>
	
```
