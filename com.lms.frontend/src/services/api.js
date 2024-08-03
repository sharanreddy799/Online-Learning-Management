import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api/auth",
});

// Interceptor to handle errors globally
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response) {
      // Request was made and server responded with a status code outside 2xx
      console.error("Backend error:", error.response.data);
    } else if (error.request) {
      // Request was made but no response was received
      console.error("No response received:", error.request);
    } else {
      // Something happened in setting up the request
      console.error("Error setting up request:", error.message);
    }
    return Promise.reject(error);
  }
);

export const registerUser = async (userData) => {
  try {
    const response = await api.post("/register", userData);

    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : new Error("Network error");
  }
};

export const loginUser = async (userData) => {
  try {
    const response = await api.post("/login", userData);
    console.log(response.data);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : new Error("Network error");
  }
};
export const getCurrentUser = async () => {
  try {
    const response = await api.get("/currentUser");
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : new Error("Network error");
  }
};

export const getPendingUsers = async () => {
  try {
    const response = await api.get("/pendingUsers");
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : new Error("Network error");
  }
};

export const enableUser = async (userId) => {
  try {
    const response = await api.post(`/enable/${userId}`);
    return response.data;
  } catch (error) {
    throw error.response ? error.response.data : new Error("Network error");
  }
};

export default api;
