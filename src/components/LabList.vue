<script setup lang="ts">
import { useDataStore } from '../stores/data';

const props = defineProps<{
  simplified?: boolean;
}>();

const dataStore = useDataStore();
const { labs } = dataStore;
</script>

<template>
  <div class="lab-list">
    <el-table :data="labs" style="width: 100%">
      <el-table-column prop="name" label="Lab Name" />
      <el-table-column prop="location" label="Location" />
      <el-table-column label="Devices" v-if="!simplified">
        <template #default="{ row }">
          <el-collapse>
            <el-collapse-item :title="`Devices (${row.devices.length})`">
              <el-table :data="row.devices" style="width: 100%">
                <el-table-column prop="name" label="Device Name" />
                <el-table-column prop="status" label="Status">
                  <template #default="{ row }">
                    <el-tag :type="row.status === 'online' ? 'success' : 'danger'">
                      {{ row.status }}
                    </el-tag>
                  </template>
                </el-table-column>
              </el-table>
            </el-collapse-item>
          </el-collapse>
        </template>
      </el-table-column>
      <el-table-column label="Device Count" v-if="simplified">
        <template #default="{ row }">
          {{ row.devices.length }}
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
.lab-list {
  width: 100%;
}
</style>