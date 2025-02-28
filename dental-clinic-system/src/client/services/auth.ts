import axios from 'axios';

const API_URL = 'http://localhost:5000/api'; // Adjust the URL as needed

export const login = async (email, password) => {
    try {
        const response = await axios.post(`${API_URL}/auth/login`, { email, password });
        localStorage.setItem('token', response.data.token);
        return response.data;
    } catch (error) {
        throw new Error('Login failed. Please check your credentials.');
    }
};

export const logout = () => {
    localStorage.removeItem('token');
};

export const getToken = () => {
    return localStorage.getItem('token');
};

export const isAuthenticated = () => {
    const token = getToken();
    return token !== null;
};