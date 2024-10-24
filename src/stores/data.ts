import { defineStore } from 'pinia';
import { ref } from 'vue';
import type { User, Lab, Device } from '../types';

export const useDataStore = defineStore('data', () => {
  const users = ref<User[]>([
    { id: 1, username: 'admin', email: 'admin@example.com', role: 'admin' },
    { id: 2, username: 'user1', email: 'user1@example.com', role: 'user' }
  ]);

  const labs = ref<Lab[]>([
    {
      id: 1,
      name: 'Main Lab',
      location: 'Building A',
      devices: [
        { id: 1, name: 'Device 1', status: 'online', labId: 1 },
        { id: 2, name: 'Device 2', status: 'offline', labId: 1 }
      ]
    },
    {
      id: 2,
      name: 'Secondary Lab',
      location: 'Building B',
      devices: [
        { id: 3, name: 'Device 3', status: 'online', labId: 2 }
      ]
    }
  ]);

  const getStats = () => {
    return {
      userCount: users.value.length,
      labCount: labs.value.length,
      deviceCount: labs.value.reduce((acc, lab) => acc + lab.devices.length, 0)
    };
  };

  return {
    users,
    labs,
    getStats
  };
});