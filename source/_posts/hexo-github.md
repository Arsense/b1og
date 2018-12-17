---
title: hexo与github同步源码,git进阶攻略
date: 2018-03-09 17:09:17
tags: hexo
---

## 引言


github虽然搭建博客比较方便，
但是采用hexo，配置一次hexo如此之麻烦，以至于要在另一个工程把所有的都来一遍，十分的费时间，稍有不慎 就会覆盖之前保存的，所以保存源码和配置很有必要

## 创建项目分支保留源码
前面的环境hexo搭建和npm自不多说，见上篇文章。

1. 先克隆hexo主分支到本地 打开git：
`git clone https://github.com/Arsense/Arsense.github.io.git`
2. 查看所有分支 
`git branch -a`
如果报错说
`fatal:Not a git respositoryXXXX`
是因为没有.git配置文件
输入命令
`git init`即可
3. 创建分支
`git branch code`  创建名为code的分支
切换到code分支
`git checkout code`

4. 添加上传文件信息
`git add .` 点表示所有文件
5. 上传

`git commit -m "add code"`
`git push -u origin code`  code为分支名

这时如果报错显示
`error: src refspec romote does not match any`
不同步 需要创建REDEME文件

`touch README`
`git add README`
6. git提交变化

`git commit -m "add code"`
`git push -u origin code`
即可上传成功


## pull到另一个电脑上


先要按前面搭建那篇博文中安装好npm,hexo init成功
然后替换配置文件和source 即可


`git clone -b code https://github.com/Arsense/Arsense.github.io.git`
-b code 是代表克隆这个分支

对了这里 只需要传`source ,scaffolds,themes和_config.yml`

然后在下载的项目中替换就行了

## git 其他常用
#### 删除远程分支
`git branch -r -d origin/branch-name`  
`git push origin :branch-name  `

#### 删除指定目录
`git rm -r public/`
