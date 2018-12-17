---
title: No.2一步步学习vuejs 实例demo篇
date: 2018-02-07 16:30:46
categories: vue.js
tags: vuejs
copyright: true
---
## 简单应用
Vue.js 的核心是一个允许采用简洁的模板语法来声明式的将数据渲染进 DOM 的系统：

```html
<div id="app">
  {{ message }}
</div>

var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})
```

在控制台输入 `app.message="11"` 数据就会发生变化

## 带有指令的例子
```html
<div id = "demo2">
<span v-bind:title="message">
鼠标悬停几秒就会看到信息
</span>
</div>


<script>
var demo2 = new Vue({
el:"#demo2",
data:{
message:"页面加载于"+new Date().toLocaleString()
}
})
</script>

```
这里我们遇到点新东西。你看到的 `v-bind` 属性被称为指令。指令带有前缀 `v-`，以表示它们是 Vue 提供的特殊属性。可能你已经猜到了，它们会在渲染的 DOM 上应用特殊的响应式行为。简言之，这里该指令的作用是：“将这个元素节点的` title` 属性和 Vue 实例的 `message` 属性保持一致”。
再次打开浏览器的 JavaScript 控制台输入 `app2.message = '新消息'`，就会再一次看到这个绑定了 `title` 属性的 HTML 已经进行了更新。
## 条件与循环
```html
<div id="app-3">
  <p v-if="seen">现在你看到我了</p>
</div>

var app3 = new Vue({
  el: '#app-3',
  data: {
    seen: true
  }
})
```
## 绑定数组来渲染项目
使用v-for 指令可以绑定数组的数据来渲染一个项目列表：
```html

<div id="app-4">
  <ol>
    <li v-for="todo in todos">
      {{ todo.text }}
    </li>
  </ol>
</div>

var app4 = new Vue({
  el: '#app-4',
  data: {
    todos: [
      { text: '学习 JavaScript' },
      { text: '学习 Vue' },
      { text: '整个牛项目' }
    ]
  }
})
```




在控制台里，输入`demo4.todos.push({text:'new demasd'})`，你会发现列表中添加了一个新项。


## 处理用户的输入

```html
<div id = "demo5">
<p>{{message}}</p>
<button v-on:click="reverseMessage">逆转消息</button>
</div>
<script>
var demo5 = new Vue({
el:"#demo5",
data: {
message: "Hello Vue.js"
},
methods: {
reverseMessage:function(){
this.message=this.message.split('').reverse().join('')
}
}
})
</script>
```

注意在 reverseMessage 方法中，我们更新了应用的状态，但没有触碰 DOM——所有的 DOM 操作都由 Vue 来处理，你编写的代码不需要关注底层逻辑。


## 和表单的双向绑定
Vue 还提供了 v-model 指令，它能轻松实现表单输入和应用状态之间的双向绑定。
```html
<div id="app-6">
  <p>{{ message }}</p>
  <input v-model="message">
</div>
var app6 = new Vue({
  el: '#app-6',
  data: {
    message: 'Hello Vue!'
  }
})
```

## 组件化构建应用

- 组件注测
- 
在 Vue 里，一个组件本质上是一个拥有预定义选项的一个 Vue 实例，在 Vue 中注册组件很简单
// 定义名为 todo-item 的新组件

Vue.component('todo-item', {
  template: '<li>这是个待办项</li>'
})

- 组件的定义
```javascript
Vue.component('todo-item', {
  // todo-item 组件现在接受一个
  // "prop"，类似于一个自定义属性
  // 这个属性名为 todo。
  props: ['todo'],
  template: '<li>{{ todo.text }}</li>'
})
```

## Vue实例

所有的 Vue 组件都是 Vue 实例，并且接受相同的选项对象即可 (一些根实例特有的选项除外)。

## 模板语法


Vue.js 使用了基于 HTML 的模板语法，允许开发者声明式地将 DOM 绑定至底层 Vue 实例的数据。所有 Vue.js 的模板都是合法的 HTML ，所以能被遵循规范的浏览器和 HTML 解析器解析。
在底层的实现上，Vue 将模板编译成虚拟 DOM 渲染函数。结合响应系统，在应用状态改变时，Vue 能够智能地计算出重新渲染组件的最小代价并应用到 DOM 操作上。
如果你熟悉虚拟 DOM 并且偏爱 JavaScript 的原始力量，你也可以不用模板，直接写渲染 (render) 函数，使用可选的 JSX 语法。


## 插值

- 文本
数据绑定最常见的形式就是使用“Mustache”语法 (双大括号) 的文本插值：
`<span>Message: {{ msg }}</span>`
- `v-once` 标签 值不能再改变

### 指令

指令的职责是，当表达式的值改变时，将其产生的连带影响，响应式地作用于 DOM
所有带v-开头的标签都是

### 缩写


v- 前缀作为一种视觉提示，用来识别模板中 Vue 特定的特性。当你在使用 Vue.js 为现有标签添加动态行为 (dynamic behavior) 时，v- 前缀很有帮助，然而，对于一些频繁用到的指令来说，就会感到使用繁琐。同时，在构建由 Vue.js 管理所有模板的单页面应用程序 (SPA - single page application) 时，v- 前缀也变得没那么重要了。因此，Vue.js 为 v-bind 和 v-on 这两个最常用的指令，提供了特定简写：
v-bind 缩写

<!-- 完整语法 -->
`<a v-bind:href="url">...</a>`

<!-- 缩写 -->
`<a :href="url">...</a>`
v-on 缩写

<!-- 完整语法 -->
`<a v-on:click="doSomething">...</a>`

<!-- 缩写 -->
`<a @click="doSomething">...</a>`


