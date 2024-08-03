import { useState } from "react";
import React from "react";
import { loginUser } from "../services/api";
import { Link, Router } from "react-router-dom";
import Register from "./Register";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try {
      const response = await loginUser({
        username,
        password,
      });
      alert(response.data);
    } catch (error) {
      alert("Error logging in");
    }
  };
  return (
    <div>
      <h1>Login</h1>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
      <Link to="/register">
        <button>Register</button>
      </Link>
    </div>
  );
};

export default Login;
