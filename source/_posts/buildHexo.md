---
title: 如何用 windows+github搭建一个优美的hexo博客
date: 2018-01-25 15:48:20
tags: hexo
categories: 前端
copyright: true
thumbnail: https://goss.veer.com/creative/vcg/veer/1600water/veer-145757956.jpg 
---
## 1.Hexo简单介绍

Hexo 是一个快速、简洁且高效的博客框架。Hexo 使用 Markdown（或其他渲染引擎）解析文章，在几秒内，即可利用靓丽的主题生成静态网页。


- 风一般的速度 
Hexo基于Node.js，支持多进程，几百篇文章也可以秒生成。 
- 流畅的撰写 
支持GitHub Flavored Markdown和所有Octopress的插件。 
- 扩展性 
Hexo支持EJS、Swig和Stylus。通过插件支持Haml、Jade和Less.

总之有个动态背景图啥 特别好管理 也非常的优美<br>
展示地址:
[Hexo演示地址](https://arsense.github.io/ "")

![](https://i.imgur.com/wHkvvZh.png)


![](https://i.imgur.com/vJSP5JE.png)
## 2.Hexo安装
### 2.1 安装准备与环境

- [Node.js](https://nodejs.org/en/)
- [Git](https://git-scm.com/)

Git是为了方便管理代码啊 github for windows也可以

### 2.2 本地搭建
	
#### 配置github仓库
1. 登陆你的github账号
创建你的github库， 注意命名规则：<br>
```
你取的名字.github.io
``` 

![](https://i.imgur.com/rMEbZEj.png)

![](https://i.imgur.com/WZj998M.png)
2. 然后克隆到本地 地址如下
 ![](https://i.imgur.com/WYGNGS3.png)
在你想要放置仓库的文件 点击右键 git bash here 前提是安装好了git
或者使用github for windows也行



`git clone` 你的仓库地址

![](https://i.imgur.com/Aqh3u96.png)
#### 安装初始化Hexo
3. 安装Hexo
在刚clone完的git bash界面输入命令<br>

 `npm install -g hexo`
 <br>
 cmd也行


安装完毕 输入命令

`hexo version`
 
查看安装是否成功 

![](https://i.imgur.com/duEUaYV.png)

4. 初始化 Hexo
输入命令 <br>

`hexo init`

初始化 完成hexo的创建
5. 安装hexo相关插件到我们的博客目录下 这里是调用的node.js，命令如下<br>
`npm start`<br>

`hexo s` #全程是hexo server

下图是完全安装后的文件
![](https://i.imgur.com/6POGzQ8.png)
## 3. 运行Hexo
1. 安装好hexo后，通过下面代码可以生成静态页面，生成的静态页面存储在public目录下: 
<br>

`hexo g`  #全称是hexo generate `
 
<br>
2. 运行服务 开启端口
 开启预览访问端口（默认端口4000，git bash下 ‘ctrl + c’ 关闭server）输入命令

`hexo s` #全程是hexo server
 

下图表示运行成功 可以看到地址 我们访问http://localhost:4000/ 
，即可看到hexo自带的hello world 页面 

![](https://i.imgur.com/blJofYy.png)

至此，hexo已经在本地搭建完成。

## 4. 配置主题

hexo默认使用的是landscape主题，下文将采用NexT主题。 
Next主题目前是最好看最流行的
想更换主题的可以参考:

[有哪些好看的 Hexo 主题？](https://www.zhihu.com/question/24422335)
### 安装主题 
将next的代码clone到项目中，保存在github仓库中的`themes/next`目录下:
    

`$ git clone https://github.com/iissnan/hexo-theme-next themes/next`


### 修改配置
1. 修改根目录下的_config.yml配置文件： 

新建的hexo文件中使用的是默认的主题landscape，将其修改为next（next为主题安装的目录名`themes/next`）
2. 修改后运行输入命令
   

 `hexo server -g`  #为`hexo generate`及`hexo server`的缩写


然后浏览器访问就可以看到我们变化的主题啦
![](https://i.imgur.com/3u9wnNW.png)


### 设置主题
- 添加我们的个人介绍
修改根目录下配置文件**_config.yml **
头像的地址也在这儿设置
通过avatar字段设置，站点外头像设置avatar：图片url，站点内头像设置avatar：目录/图片名.图片格式

在根目录下的_config.yml文件中，添加avatar字段：
![](https://i.imgur.com/CllBJP5.png)
NexT 通过 Scheme 提供主题中的主题。 Mist 是 NexT 的第一款 Scheme。启用 Mist 仅需在 主题配置文件 中将 #scheme: Mist 前面的 # 注释去掉即可。
![](https://i.imgur.com/zzHbIl3.png)
修改`themes/next`目录下的_config.yml文件： 
### 添加首页的标签栏

1. 添加标签栏 

 `hexo new page tags ` 


修改刚创建的tags文件夹(**github仓库目录\source\tags**)下的index.md文件： 
![](https://i.imgur.com/u6tQ9GQ.png)
在`themes/next`目录下的_config.yml文件中，将 menu关键字 中 about 前面的注释去掉即可
2. 添加分类


   `hexo new page categories` 

修改刚创建的categories文件夹(**github仓库目录\source\categories**)下的index.md文件
3. 添加About 界面


 `hexo new page about `

在**themes/next**目录下的**_config.yml**文件中，将 menu关键字 中 about 前面的注释去掉即可 
![](https://i.imgur.com/xxH5Na2.png)
同类型的操作还有配置 sitmap 和错误的404界面
4. 404界面

腾讯公益404页面使用方法，新建 404.html 页面，放到主题的 source 目录下(themes/next/source)，内容如下

```html
  <!DOCTYPE HTML>
    <html>
    <head>
      <meta http-equiv="content-type" content="text/html;charset=utf-8;"/>
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
      <meta name="robots" content="all" />
      <meta name="robots" content="index,follow"/>
    </head>
    <body>

    <script type="text/javascript" src="http://www.qq.com/404/search_children.js" charset="utf-8" homePageUrl="your site url " homePageName="回到我的主页"></script>

    </body>
    </html>
```
## 界面美化

### 添加github绶带
[github绶带](https://github.com/blog/273-github-ribbons)

获取源码后，修改**arsense.github.io\themes\next\layout**目录下的_layout文件：
将绶带的代码，添加在</body>上方即可。
![](https://i.imgur.com/oOj7Aw5.png)
完成以上步骤后，运行效果： 


![](https://i.imgur.com/7YfJvUu.png)

### 添加RSS 
输入命令
```bash
npm install --save hexo-generator-feed
```
修改根目录下配置文件**_config.yml **
在**themes/next**目录下的**_config.yml**文件中，
添加
```html
# Set rss to false to disable feed link.
# Leave rss as empty to use site's feed link.
# Set rss to specific value if you have burned your feed already.
rss: /atom.xml
```
![](https://i.imgur.com/bPyFrIj.png)
### 修改底部的#为标签
修改模板
```html
/themes/next/layout/_macro/post.swig，搜索 rel="tag">#，
将 # 换成<i class="fa fa-tag"></i>
```


![](https://i.imgur.com/MoygOwC.png)

### 文章底部添加本文结束

在路径** \themes\next\layout\_macro** 中新建 **passage-end-tag.swig** 文件,并添加以下内容：

```html
<div>
    {% if not is_index %}
        <div style="text-align:center;color: #ccc;font-size:14px;">-------------本文结束<i class="fa fa-paw"></i>感谢您的阅读-------------</div>
    {% endif %}
</div>
```

接着打开**\themes\next\layout\_macro\post.swig**文件，在post-body 之后， post-footer 之前添加如下画红色部分代码（post-footer之前两个DIV）：

```
<div>
  {% if not is_index %}
    {% include 'passage-end-tag.swig' %}
  {% endif %}
</div>
```

然后在**themes\next**打开配置文件（_config.yml),在末尾添加：
## 上传github

这里我们已经基本大功告成

```bash
   hexo clean
    hexo generate  
    hexo deploy
```
输入命令即可部署hexo到github 上
在里面的末尾添加：(请注意在冒号后面要加一个空格，不然会发生错误！)


![](https://i.imgur.com/oGUnh6P.png)

看URL访问
![](https://i.imgur.com/VTyQngd.png)

## 番外篇

## hexo常用命令

hexo命令

常用命令： 
hexo new “postName” #新建文章 
hexo new page “pageName” #新建页面 
hexo generate #生成静态页面至public目录 
hexo server #开启预览访问端口（默认端口4000，’ctrl + c’关闭server） 
hexo deploy #将.deploy目录部署到GitHub

常用复合命令： 
hexo deploy -g 
hexo server -g

简写： 
hexo n == hexo new 
hexo g == hexo generate 
hexo s == hexo server 
hexo d == hexo deploy


### 参考文章

1. [GitHub上搭建Hexo个人博客](http://blog.csdn.net/u012995964/article/details/50152261)
2. [hexo的next主题个性化教程：打造炫酷网站](http://blog.csdn.net/qq_33699981/article/details/72716951)