<template>
  <div class="page">
    <div class="card">
      <div class="logo">
        <img :src="logo" class="logoImg" alt="logo" />
      </div>

      <h2 class="title">로그인</h2>

      <div class="form">
        <p v-if="errMsg" class="validMsg">{{ errMsg }}</p>
        <div class="input-group">
          <span class="icon">📧</span>
          <input v-model="email" placeholder="이메일 입력" />
        </div>
        <p v-if="emailMsg" class="validMsg">{{ emailMsg }}</p>

        <div class="input-group">
          <span class="icon">🔒</span>
          <input type="password" v-model="password" placeholder="비밀번호 입력" />
        </div>
        <p v-if="passwordMsg" class="validMsg">{{ passwordMsg }}</p>

        <button class="submit-btn" @click="login">로그인</button>
        <p class="login-link">
          계정이 없으신가요?
          <router-link to="/signup">회원가입</router-link>
        </p>
      </div>
    </div>
  </div>
</template>
  
<script setup>
  import { ref } from 'vue'
  import axios from '../api/axios'
  import logo from '../assets/Logo_DevLife Manager.png'
  
  const email = ref('')
  const password = ref('')

  const emailMsg = ref('')
  const passwordMsg = ref('')
  const errMsg = ref('')
  
  const login = async () => {

    try {
      emailMsg.value = "";
      passwordMsg.value = "";
      errMsg.value = "";
      
      // 로그인 서버 통신
      const res = await axios.post('/api/auth/login', {
        email: email.value,
        password: password.value
      })

      alert(res.data.message)
      await router.push('/')
      console.log(res.data)
      
    } catch (e) {
      if (e.response.data.data) {
        // 유효성 체크 에러
        const errors = e.response.data.data;
        emailMsg.value = errors.email;
        passwordMsg.value = errors.password;

      } else if (e.response) {
        errMsg.value = e.response.data.message;
      } else {
        alert("서버 연결 실패");
      }
    }
  }
  </script>
  