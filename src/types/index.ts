export interface User {
  id: number;
  username: string;
  email: string;
  role: 'admin' | 'user';
}

export interface Device {
  id: number;
  name: string;
  status: 'online' | 'offline' | 'maintenance';
  labId: number;
}

export interface Lab {
  id: number;
  name: string;
  location: string;
  devices: Device[];
}