<script setup lang="ts">
import { useDataStore } from '../stores/data';
import StatCard from '../components/StatCard.vue';
import LabList from '../components/LabList.vue';

const dataStore = useDataStore();
const stats = dataStore.getStats();
</script>

<template>
  <div class="dashboard">
    <div class="stats-container">
      <StatCard
        title="Total Users"
        :value="stats.userCount"
        icon="User"
      />
      <StatCard
        title="Total Labs"
        :value="stats.labCount"
        icon="Office"
      />
      <StatCard
        title="Total Devices"
        :value="stats.deviceCount"
        icon="Monitor"
      />
    </div>
    <div class="labs-overview">
      <h3>Labs Overview</h3>
      <LabList :simplified="true" />
    </div>
  </div>
</template>

<style scoped>
.dashboard {
  padding: 20px;
}

.stats-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
  margin-bottom: 30px;
}

.labs-overview {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
}
</style>