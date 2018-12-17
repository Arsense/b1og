---
title: No.3一步步学习vuejs之计算属性和观察者
date: 2018-02-07 17:02:39
tags: vuejs
categories: vue.js
---
## 一.算属性    

```html
<div id = "demo1">
<p>Original message: "{{message}}"</p>
<p>Computed reversed message: "{{reversedMessage}}"</p>
</div>

<script>
var demo1 = new Vue({
el:"#demo1",
data:{
message:"hello"
},
computed:{
// 计算属性的 getter
reversedMessage:function(){
// `this` 指向 vm 实例
return this.message.split('').reverse().join('')
}
}
})
</script>

```
运行结果
![](https://i.imgur.com/XkvaInP.png)

这里我们声明了一个计算属性 `reversedMessage`。我们提供的函数将用作属性 `vm.reversedMessage `的 `getter` 函数：
```html
console.log(vm.reversedMessage) // => 'olleH'
vm.message = 'Goodbye'
console.log(vm.reversedMessage) // => 'eybdooG'
```
你可以打开浏览器的控制台，自行修改例子中的 vm。vm.reversedMessage 的值始终取决于 vm.message 的值。
你可以像绑定普通属性一样在模板中绑定计算属性。Vue 知道 vm.reversedMessage 依赖于 vm.message，因此当 vm.message 发生改变时，所有依赖 vm.reversedMessage 的绑定也会更新。而且最妙的是我们已经以声明的方式创建了这种依赖关系：计算属性的 getter 函数是没有副作用 (side effect) 的，这使它更易于测试和理解。


## 计算属性缓存 vs 方法

计算属性是基于它们的依赖进行缓存的。计算属性只有在它的相关依赖发生改变时才会重新求值。这就意味着只要 message 还没有发生改变，多次访问 reversedMessage 计算属性会立即返回之前的计算结果，而不必再次执行函数

就是计算属性更厉害 不改变方法就调用一次 方法是访问一次调用一次

## 计算属性的 setter

计算属性默认只有 getter ，不过在需要时你也可以提供一个 setter ：
```html
<div id = "demo2">
{{fullName}}
</div>
<script>
var vm = new Vue({
el:"#demo2",
data:{
firstName:"Foo",
lastName:"Bar"
},

computed:{
fullName:{

get:function(){
return this.firstName+" "+this.lastName
},
set:function(newName){
var names = newName.split(' ')
this.firstName=names[0]
this.lastName = names[names.length-1]
}
}
}
})
</script>
```
现在再运行` vm.fullName = 'John Doe'` 时，setter 会被调用，`vm.firstName `和 `vm.lastName` 也会相应地被更新。

![](https://i.imgur.com/MQ4zH0W.png)


## 侦听器

虽然计算属性在大多数情况下更合适，但有时也需要一个自定义的侦听器。这就是为什么 Vue 通过 watch 选项提供了一个更通用的方法，来响应数据的变化。当需要在数据变化时执行异步或开销较大的操作时，这个方式是最有用的。    

<!-- 因为 AJAX 库和通用工具的生态已经相当丰富，Vue 核心代码没有重复 -->
<!-- 提供这些功能以保持精简。这也可以让你自由选择自己更熟悉的工具。 -->
```html
<script src="https://cdn.jsdelivr.net/npm/axios@0.12.0/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lodash@4.13.1/lodash.min.js"></script>
</head>
<body>

<div id = "demo3">
<p>
Ask yes/no question:
<input v-model="question">
</p>
<p>{{answer}}</p>
</div>


<script>
var watchDemo = new Vue({
el:"#demo3",
data:{
question:"",
answer:"I cannot give you an answer until you answer a question"
},
watch:{
// 如果 `question` 发生改变，这个函数就会运行
question:function(newQuestion){
this.answer = 'Waiting for you to stop trying'
this.getAnswer()
}
},
methods:{
// `_.debounce` 是一个通过 Lodash 限制操作频率的函数。
// 在这个例子中，我们希望限制访问 yesno.wtf/api 的频率
// AJAX 请求直到用户输入完毕才会发出。想要了解更多关于
// `_.debounce` 函数 (及其近亲 `_.throttle`) 的知识，
// 请参考：https://lodash.com/docs#debounce
getAnswer:_.debounce(
function(){
if(this.question.indexOf('?')=== -1){
this.answer="Questions usually contains a question mark :)"
return
}
this.answer="Thinking.."
var vm = this
axios.get("https://yesno.wtf/api")
.then(function(response){
vm.answer=_.capitialize(response.data.answer)
})
.catch(function(error){
vm.anwser="Cannot reach the API"+error
})
},
// 这是我们为判定用户停止输入等待的毫秒数
500
)
}
})



</script>
```
```html
<div id="watch-example">
  <p>
    Ask a yes/no question:
    <input v-model="question">
  </p>
  <p>{{ answer }}</p>
</div>
<!-- 因为 AJAX 库和通用工具的生态已经相当丰富，Vue 核心代码没有重复 -->
<!-- 提供这些功能以保持精简。这也可以让你自由选择自己更熟悉的工具。 -->
<script src="https://cdn.jsdelivr.net/npm/axios@0.12.0/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lodash@4.13.1/lodash.min.js"></script>
<script>
var watchExampleVM = new Vue({
  el: '#watch-example',
  data: {
    question: '',
    answer: 'I cannot give you an answer until you ask a question!'
  },
  watch: {
    // 如果 `question` 发生改变，这个函数就会运行
    question: function (newQuestion) {
      this.answer = 'Waiting for you to stop typing...'
      this.getAnswer()
    }
  },
  methods: {
    // `_.debounce` 是一个通过 Lodash 限制操作频率的函数。
    // 在这个例子中，我们希望限制访问 yesno.wtf/api 的频率
    // AJAX 请求直到用户输入完毕才会发出。想要了解更多关于
    // `_.debounce` 函数 (及其近亲 `_.throttle`) 的知识，
    // 请参考：https://lodash.com/docs#debounce
    getAnswer: _.debounce(
      function () {
        if (this.question.indexOf('?') === -1) {
          this.answer = 'Questions usually contain a question mark. ;-)'
          return
        }
        this.answer = 'Thinking...'
        var vm = this
        axios.get('https://yesno.wtf/api')
          .then(function (response) {
            vm.answer = _.capitalize(response.data.answer)
          })
          .catch(function (error) {
            vm.answer = 'Error! Could not reach the API. ' + error
          })
      },
      // 这是我们为判定用户停止输入等待的毫秒数
      500
    )
  }
})
</script>
```
`I cannot give you an answer until you ask a question!`
在这个示例中，使用 watch 选项允许我们执行异步操作 (访问一个 API)，限制我们执行该操作的频率，并在我们得到最终结果前，设置中间状态。这些都是计算属性无法做到的。




## 二 Class 与 Style 绑定

操作元素的 class 列表和内联样式是数据绑定的一个常见需求。因为它们都是属性，所以我们可以用 v-bind 处理它们：只需要通过表达式计算出字符串结果即可。不过，字符串拼接麻烦且易错。因此，在将 v-bind 用于 class 和 style 时，Vue.js 做了专门的增强。表达式结果的类型除了字符串之外，还可以是对象或数组。


### 绑定 HTML Class

- 对象语法
我们可以传给 v-bind:class 一个对象，以动态地切换 class：
`<div v-bind:class="{ active: isActive }"></div>`
### 表格渲染的v-for
```html
<div id ="demo8">
<input
v-model="newTodoText"
v-on:keyup.enter ="addNewTodo"
placeholder="Add a todo"
>
<!--这里不要打逗号 回显示不出数据 因为是标签内数据 一般用空格分开-->
<ul>
<li
is="todo-item"
v-for="(todo,index) in todos"
v-bind:key="todo.id"
v-bind:title="todo.title"
v-on:remove="todos.splice(index,1)"
></li>
</ul>
</div>



<script>
Vue.component("todo-item",{
template:'\
<li>\
{{title}}\
<button v-on:click="$emit(\'remove\')">X</button>\
</li>\
',
props:['title']
})
new Vue({
el:"#demo8",
data:{
newTodoText:"",
todos:[
{
id: 1,
title:"i am just for fun"
},
{
id:2,
title:"the second function"
},
{
id:3,
title:"i just a litle baby"
}

],
nextTodoId:4
},
methods:{
addNewTodo:function(){
this.todo.push({
id:this.todo.id++,
title:this.newTodoText
})
this.newTodoText=""
}
}
})
```
完成截图
注意这里的 is="todo-item" 属性。这种做法在使用 DOM 模板时是十分必要的，因为在 <ul> 元素内只有 <li> 元素会被看作有效内容。这样做实现的效果与 <todo-item> 相同，但是可以避开一些潜在的浏览器解析错误。查看 DOM 模板解析说明 来了解更多信息。
![](https://i.imgur.com/RGQq5rL.png)