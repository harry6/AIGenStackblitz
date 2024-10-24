import { defineStore } from 'pinia';
import { ref } from 'vue';
import type { User } from '../types';

export const useAuthStore = defineStore('auth', () => {
  const currentUser = ref<User | null>(null);
  const isAuthenticated = ref(false);

  const login = async (username: string, password: string) => {
    // Mock login
    if (username === 'admin' && password === 'admin') {
      currentUser.value = {
        id: 1,
        username: 'admin',
        email: 'admin@example.com',
        role: 'admin'
      };
      isAuthenticated.value = true;
      return true;
    }
    return false;
  };

  const logout = () => {
    currentUser.value = null;
    isAuthenticated.value = false;
  };

  return {
    currentUser,
    isAuthenticated,
    login,
    logout
  };
});