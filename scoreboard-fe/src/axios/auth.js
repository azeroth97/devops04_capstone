import api from './axios';

export async function login(username, password) {
  const { data } = await api.post('/login', { username, password });
  localStorage.setItem('jwt', data); // data IS the raw JWT string
  return data;
}

export async function signup(payload) {
  const { data } = await api.post('/signup', payload);
  return data;
}
export function logout() {
  localStorage.removeItem('jwt');
  window.location.href = '/login';
}

export function isAuthenticated() {
  return !!localStorage.getItem('jwt');
}