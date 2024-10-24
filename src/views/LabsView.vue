<script setup lang="ts">
import LabList from '../components/LabList.vue';
</script>

<template>
  <div class="labs-view">
    <el-card>
      <template #header>
        <div class="card-header">
          <h3>Lab Management</h3>
        </div>
      </template>
      
      <LabList />
    </el-card>
  </div>
</template>

<style scoped>
.labs-view {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-header h3 {
  margin: 0;
}
</style>