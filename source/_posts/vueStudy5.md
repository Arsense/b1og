---
title: No.5一步步学习vuejs之事件监听和组件
date: 2018-02-07 20:05:27
tags: vuejs
categories: vue.js
---
## 一监听事件
可以用 v-on 指令监听 DOM 事件，并在触发时运行一些 JavaScript 代码。
```html
<div id="demo1">
<button v-on:click="count+=1">Add 1</button>
<p>you have click the button for {{count}} times!</p>
</div>

<script>
new Vue({
el:"#demo1",
data:{
count:1
}
})
</script>

```
运行结果:
![](https://i.imgur.com/4NMHYve.png)

##  2.事件处理方法



然而许多事件处理逻辑会更为复杂，所以直接把 JavaScript 代码写在 v-on 指令中是不可行的。因此 v-on 还可以接收一个需要调用的方法名称。     
代码如下：
```html
<div id = "demo2">
<button v-on:click="greet">SayHello</button>
</div>
<script>
var demo2 = new Vue({
el:"#demo2",
data:{
name:"Clay",
},
methods:{
greet:function(event){
alert('Hello'+this.name+'!')
if(event){
alert(event.target.tagName)
}
}
}
})

demo2.greet()
</script>
```
运行结果：
![](https://i.imgur.com/BoUwqXZ.png)
## 3 内联处理器中的方法
先贴代码 两个事件属性用到内联
```html
<div id = "demo3">
<button v-on:click="say('hi')">say hi</button>
<button v-on:click="say('sha')">say hello</button>
</div>
<script>
new Vue({
el:"#demo3",
methods:{
say:function(message){
alert(message)
}
}
})
</script>
```
运行结果:除了直接绑定到一个方法，也可以在内联 JavaScript 语句中调用方法：
![](https://i.imgur.com/iOvbFXn.png)
##  4 事件修饰符


为了解决这个问题，Vue.js 为 v-on 提供了事件修饰符。之前提过，修饰符是由点开头的指令后缀来表示的。
在事件处理程序中调用 event.preventDefault() 或 event.stopPropagation() 是非常常见的需求。尽管我们可以在方法中轻松实现这点，但更好的方式是：方法只有纯粹的数据逻辑，而不是去处理 DOM 事件细节。

`.stop`
`.prevent`
`.capture`
`.self`
`.once`

##  5 系统修饰键

可以用如下修饰符来实现仅在按下相应按键时才触发鼠标或键盘事件的监听器。
`.ctrl`
`.alt`
`.shift`
`.meta`
<!-- Alt + C -->
`<input @keyup.alt.67="clear">`

<!-- Ctrl + Click -->
`<div @click.ctrl="doSomething">Do something</div>`
鼠标按钮修饰符
2.1.0 新增
.left
.right
.middle
这些修饰符会限制处理函数仅响应特定的鼠标按钮。

## 二Vue组件
### 2.1什么是组件

组件 (Component) 是 Vue.js 最强大的功能之一。组件可以扩展 HTML 元素，封装可重用的代码。在较高层面上，组件是自定义元素，Vue.js 的编译器为它添加特殊功能。在有些情况下，组件也可以表现为用 is 特性进行了扩展的原生 HTML 元素。
所有的 Vue 组件同时也都是 Vue 的实例，所以可接受相同的选项对象 (除了一些根级特有的选项) 并提供相同的生命周期钩子。

###2.2注册一个组件
要注册一个全局组件，可以使用 Vue.component(tagName, options)。例如：
```html
Vue.component('my-component', {
  // 选项
})
```
 #### 2.2.1全局注册
组件在注册之后，便可以作为自定义元素` <my-component></my-component> `在一个实例的模板中使用。注意确保在初始化根实例之前注册组件：
#### 2.2.2局部注册
你不必把每个组件都注册到全局。你可以通过某个 Vue 实例/组件的实例选项 components注册仅在其作用域中可用的组件：
```html
var Child = {
  template: '<div>A custom component!</div>'
}

new Vue({
  // ...
  components: {
    // <my-component> 将只在父组件模板中可用
    'my-component': Child
  }
})
```
构造 Vue 实例时传入的各种选项大多数都可以在组件里使用。只有一个例外：data 必须是函数。实际上，如果你这么做：
```html
Vue.component('my-component', {
  template: '<span>{{ message }}</span>',
  data: {
    message: 'hello'
  }
})
```
那么 Vue 会停止运行，并在控制台发出警告

### 2.3组件结合

组件设计初衷就是要配合使用的，最常见的就是形成父子组件的关系：组件 A 在它的模板中使用了组件 B。它们之间必然需要相互通信：父组件可能要给子组件下发数据，子组件则可能要将它内部发生的事情告知父组件。然而，通过一个良好定义的接口来尽可能将父子组件解耦也是很重要的。这保证了每个组件的代码可以在相对隔离的环境中书写和理解，从而提高了其可维护性和复用性。
在 Vue 中，父子组件的关系可以总结为 prop 向下传递，事件向上传递。父组件通过 prop给子组件下发数据，子组件通过事件给父组件发送消息。看看它们是怎么工作的。

自定义事件
我们知道，父组件使用 prop 传递数据给子组件。但子组件怎么跟父组件通信呢？这个时候 Vue 的自定义事件系统就派得上用场了。
使用 v-on 绑定自定义事件
每个 Vue 实例都实现了事件接口，即：
使用 `$on(eventName) `监听事件
使用 `$emit(eventName) `触发事件
```html
div id="demo2">
<p>{{totalNumber}}</p>
<button-add v-on:add="addTotal"></button-add>
<button-add v-on:add="addTotal"></button-add> <!-- 这里是监听事件-->
<button-add v-on:add="addTotal"></button-add>
<button-add v-on:add="addTotal"></button-add> <!-- 这里是监听事件-->
</div>


<script>
Vue.component("button-add",{
template:'<button v-on:click="addTotalNumber">{{count}}</button>',
data:function(){
return {
count:0
}
},
methods:{
addTotalNumber:function(){
this.count +=1
this.$emit('add') //这里触发相应的事件
}
}
})

new Vue({
el:"#demo2",
data:{
totalNumber:0
},
methods:{
addTotal:function(){
this.totalNumber+=1
}
}
})
</script>
```
运行结果如下
![](https://i.imgur.com/hsDeyhh.png)


#### 局部注册
你不必把每个组件都注册到全局。你可以通过某个 Vue 实例/组件的实例选项 components注册仅在其作用域中可用的模板解析注意事项组件：
```html
var Child = {
  template: '<div>A custom component!</div>'
}

new Vue({
  // ...
  components: {
    // <my-component> 将只在父组件模板中可用
    'my-component': Child
  }
})
```
### 组件组合
组件设计初衷就是要配合使用的，最常见的就是形成父子组件的关系：组件 A 在它的模板中使用了组件 B。它们之间必然需要相互通信：父组件可能要给子组件下发数据，子组件则可能要将它内部发生的事情告知父组件。然而，通过一个良好定义的接口来尽可能将父子组件解耦也是很重要的。这保证了每个组件的代码可以在相对隔离的环境中书写和理解，从而提高了其可维护性和复用性。
在 Vue 中，父子组件的关系可以总结为 prop 向下传递，事件向上传递。父组件通过 prop给子组件下发数据，子组件通过事件给父组件发送消息。看看它们是怎么工作的。
![](https://i.imgur.com/O5zAWhn.png)
prop 向下传递，事件向上传递

### Prop使用 Prop 传递数据

组件实例的作用域是孤立的。这意味着不能 (也不应该) 在子组件的模板内直接引用父组件的数据。父组件的数据需要通过 prop 才能下发到子组件中。
子组件要显式地用 props 选项声明它预期的数据：
```html
Vue.component('child', {
  // 声明 props
  props: ['message'],
  // 就像 data 一样，prop 也可以在模板中使用
  // 同样也可以在 vm 实例中通过 this.message 来使用
  template: '<span>{{ message }}</span>'
})
```
然后我们可以这样向它传入一个普通字符串：
`<child message="hello!"></child>`
结果：
hello!

     