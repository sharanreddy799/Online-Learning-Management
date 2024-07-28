import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api/auth",
});

export const registerUser = async (userData) => {
  return await api.post("/register", userData);
};

export const loginUser = async (userData) => {
  return await api.post("/login", userData);
};
