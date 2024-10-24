<script setup lang="ts">
import { useDataStore } from '../stores/data';

const dataStore = useDataStore();
const { users } = dataStore;
</script>

<template>
  <div class="users-view">
    <el-card>
      <template #header>
        <div class="card-header">
          <h3>User Management</h3>
        </div>
      </template>
      
      <el-table :data="users" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="username" label="Username" />
        <el-table-column prop="email" label="Email" />
        <el-table-column prop="role" label="Role">
          <template #default="{ row }">
            <el-tag :type="row.role === 'admin' ? 'danger' : 'success'">
              {{ row.role }}
            </el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<style scoped>
.users-view {
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