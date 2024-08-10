import React, { useState } from "react";
import { loginUser } from "../services/api";
import { Link, Navigate } from "react-router-dom";
import { TextField, Button, Container, Typography, Box } from "@mui/material";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try {
      const response = await loginUser({
        username,
        password,
      });
      alert(response);
      Navigate("/home");
    } catch (error) {
      alert("Error logging in");
    }
  };

  return (
    <Container maxWidth="sm">
      <Box
        display="flex"
        flexDirection="column"
        alignItems="center"
        justifyContent="center"
        minHeight="96vh"
      >
        <Typography variant="h4" component="h1" gutterBottom>
          Login
        </Typography>
        <TextField
          label="Username"
          variant="outlined"
          fullWidth
          margin="normal"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <TextField
          label="Password"
          variant="outlined"
          type="password"
          fullWidth
          margin="normal"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <Button
          variant="contained"
          color="primary"
          fullWidth
          onClick={handleLogin}
        >
          Login
        </Button>
        <Link
          to="/register"
          style={{ textDecoration: "none", marginTop: "1rem" }}
        >
          <Button variant="outlined" color="secondary" fullWidth>
            Register
          </Button>
        </Link>
      </Box>
    </Container>
  );
};

export default Login;
