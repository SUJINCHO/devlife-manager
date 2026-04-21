import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:8080', // Spring 주소
  timeout: 5000,
  withCredentials: true
})

export default instance