<script setup lang="ts">
defineProps<{
  title: string;
  value: number;
  icon: string;
}>();
</script>

<template>
  <el-card class="stat-card">
    <div class="stat-content">
      <div class="stat-icon">
        <el-icon><component :is="icon" /></el-icon>
      </div>
      <div class="stat-info">
        <h3>{{ title }}</h3>
        <p class="stat-value">{{ value }}</p>
      </div>
    </div>
  </el-card>
</template>

<style scoped>
.stat-card {
  height: 100%;
}

.stat-content {
  display: flex;
  align-items: center;
  gap: 20px;
}

.stat-icon {
  font-size: 2.5em;
  color: #409eff;
}

.stat-info h3 {
  margin: 0;
  font-size: 1em;
  color: #606266;
}

.stat-value {
  margin: 5px 0 0;
  font-size: 1.8em;
  font-weight: bold;
  color: #303133;
}
</style>