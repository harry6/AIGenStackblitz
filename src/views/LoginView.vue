<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useAuthStore } from '../stores/auth';

const router = useRouter();
const authStore = useAuthStore();

const username = ref('');
const password = ref('');
const loading = ref(false);
const errorMsg = ref('');

const handleLogin = async () => {
  loading.value = true;
  errorMsg.value = '';
  
  try {
    const success = await authStore.login(username.value, password.value);
    if (success) {
      router.push('/dashboard');
    } else {
      errorMsg.value = 'Invalid credentials';
    }
  } finally {
    loading.value = false;
  }
};
</script>

<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2>Lab Management System</h2>
      <el-form @submit.prevent="handleLogin">
        <el-form-item>
          <el-input
            v-model="username"
            placeholder="Username"
            prefix-icon="el-icon-user"
          />
        </el-form-item>
        <el-form-item>
          <el-input
            v-model="password"
            type="password"
            placeholder="Password"
            prefix-icon="el-icon-lock"
            show-password
          />
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            :loading="loading"
            @click="handleLogin"
            style="width: 100%"
          >
            Login
          </el-button>
        </el-form-item>
        <p v-if="errorMsg" class="error-message">{{ errorMsg }}</p>
      </el-form>
    </el-card>
  </div>
</template>

<style scoped>
.login-container {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f5f7fa;
}

.login-card {
  width: 100%;
  max-width: 400px;
  padding: 20px;
}

.error-message {
  color: #f56c6c;
  text-align: center;
  margin-top: 10px;
}
</style>