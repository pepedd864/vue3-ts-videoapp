const serok = [
  {
    code: 20011,
    message: '保存成功'
  },
  {
    code: 20021,
    message: '删除成功'
  },
  {
    code: 20031,
    message: '更新成功'
  },
  {
    code: 20041,
    message: '查询成功'
  }
]
const sererr = [
  {
    code: 20010,
    message: '保存错误'
  },
  {
    code: 20020,
    message: '删除错误'
  },
  {
    code: 20030,
    message: '更新错误'
  },
  {
    code: 20040,
    message: '查询错误'
  },
  {
    code: 50000,
    message: '服务器错误'
  }
]
const errcode = [
  {
    code: 400,
    message: '请求参数错误'
  },
  {
    code: 401,
    message: '登录失效，请重新登录'
  },
  {
    code: 403,
    message: '没有权限'
  },
  {
    code: 404,
    message: '请求地址不存在'
  },
  {
    code: 405,
    message: '请求方法不支持'
  },
  {
    code: 500,
    message: '服务器错误'
  },
  {
    code: 502,
    message: '网关错误'
  }
]
export { errcode, sererr, serok }
