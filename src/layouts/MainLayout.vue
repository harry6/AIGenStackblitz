<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useAuthStore } from '../stores/auth';

const router = useRouter();
const authStore = useAuthStore();
const activeTab = ref('dashboard');

const handleLogout = () => {
  authStore.logout();
  router.push('/login');
};
</script>

<template>
  <el-container class="layout-container">
    <el-header>
      <div class="header-content">
        <h2>Lab Management System</h2>
        <div class="user-info">
          <span>{{ authStore.currentUser?.username }}</span>
          <el-button @click="handleLogout" size="small" type="text">Logout</el-button>
        </div>
      </div>
    </el-header>
    
    <el-container>
      <el-main>
        <el-tabs v-model="activeTab" @tab-click="(tab) => router.push(`/${tab.props.name}`)">
          <el-tab-pane label="Dashboard" name="dashboard" />
          <el-tab-pane label="Users" name="users" />
          <el-tab-pane label="Labs" name="labs" />
        </el-tabs>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.layout-container {
  height: 100vh;
}

.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.el-main {
  padding: 20px;
}
</style>