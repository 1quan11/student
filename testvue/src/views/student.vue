<template>
<div>
  <table>
    <thead>
    <tr>
      <th><label><input type="checkbox" /></label></th>
      <td>ID</td>
      <td>学号</td>
      <td>姓名</td>
      <td>专业</td>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in stu">
      <td><label><input type="checkbox"/></label></td>
      <td>{{item.id}}</td>
      <td>{{item.stuno}}</td>
      <td>{{item.name}}</td>
      <td>{{item.major}}</td>
      <td><a href="javaScript:;" @click="remove(item.stuno,item.name,$event)">删除</a></td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
      <td colspan="5">
        <a href="#">尾页</a>
        <a href="#">下一页</a>
        <a href="#">上一页</a>
        <a href="#">首页</a>
      </td>
    </tr>
    </tfoot>
  </table>
</div>
</template>
<script>
export default {
  methods: {
    remove(stuno,name, e) {
      alert(stuno),
        //前端发起删除请求
        axios({
          //请求方式
          method: 'GET',
          //请求路径
          url: "/deleteStudentById/{stuno}",
          //url中的请求参数(get传参)
          params: {
            stuno: stuno
          },
        }).then(result => {
          alert(result.data)
        });
      console.log(stuno);
      //filter 过滤掉
      this.list = this.list.filter(item => item.stuno !== stuno)
    }
  },
  name: "student",
  data() {
    return {
      stu:[
        {
          id:'1',
          stuno:'110',
          name:'小泉',
          major:'计算机'
        },
        {
          id:'2',
          stuno:'110',
          name:'小帅',
          major:'计算机'
        },
        {
          id:'3',
          name:'小三',
          stuno:'110',
          major:'计算机'
        }
      ]
    }
  },
  created() {
    const _this = this
    //网络请求
    axios.get('http://localhost:8081/getAll').then(function (resp) {
          _this.stu = resp.data
    })
  }
}
</script>

<style scoped>

</style>
