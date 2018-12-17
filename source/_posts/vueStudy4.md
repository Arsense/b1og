---
title: No.4一步步学习vuejs之表单输入绑定
date: 2018-02-07 19:38:01
tags: vuejs
categories: vue.js
---
## 基础用法
你可以用 v-model 指令在表单控件元素上创建双向数据绑定。它会根据控件类型自动选取正确的方法来更新元素。尽管有些神奇，但 v-model 本质上不过是语法糖，它负责监听用户的输入事件以更新数据，并特别处理一些极端的例子


### 绑定到文本
```html
<div id = "demo4">
<input v-model="message" placeholder="edit me">
<p>Message is {{message}}</p>
</div>

<script>
var vm=new Vue({
el:"#demo4",
data:{
message:''
}
})
</script>
```

绑定到多行文本
注意
input标签改为textarea标签
```html
<div id = "demo4">
<p>Mutiple message is</p>
<p style="white-space: pre-line;">{{ message }}</p>
<br>
<textarea v-model="message" placeholder="add multiple lines">11</textarea>
</div>

<script>
var vm=new Vue({
el:"#demo4",
data:{
message:''
}
})
</script>
```

运行结果如下
![](https://i.imgur.com/m0Ibq6h.png)

### 复选框
- 单个复选框 样例


`<input type="checkbox" id="checkbox" v-model="checked">`
`<label for="checked>">{{checked}}</label>`


- 多个复选框

其实就是多几个单选的标签而已

```html
div id="demo7">
<input type="checkbox" id="jack" value="Jack" v-model ="checkNames">
<label for="jack">Jack</label>
<input type="checkbox" id="clay" value="Clay" v-model ="checkNames">
<label for="clay">Jack</label>
<input type="checkbox" id="scott" value="Scott" v-model ="checkNames">
<label for="scott">Jack</label>
<br>
<span>
CheckedNames are:{{checkNames}}
</span>
</div>


<script>
new Vue({
el:"#demo7",
data:{
checkNames:[]
}
})
</script>
```
## 单选按钮
其实就是把type 中的checkbox改成radio即可
### 选择列表

```html
<div id="example-5">
  <select v-model="selected">
    <option disabled value="">请选择</option>
    <option>A</option>
    <option>B</option>
    <option>C</option>
  </select>
  <span>Selected: {{ selected }}</span>
</div>
new Vue({
  el: '...',
  data: {
    selected: ''
  }
})
```


![](https://i.imgur.com/kceLknJ.png)