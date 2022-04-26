<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Vue测试页面</title>

</head>
<body>
<div id ="app">
  <p>{{message}}}</p>
</div>
<script>
  new Vue({
    el: '#app',
    data :{
      message: 'Hello Vue.js!'
    }
  })
</script>
</body>
</html>