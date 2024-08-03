import "./App.css";
import React from "react";
import Header from "./components/Header";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginPage from "./components/LoginPage";
import Register from "./components/Register";
import Footer from "./components/Footer";
import AppRoutes from "./AppRoutes";
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/*" element={<AppRoutes />} />
        <Route path="/" element={<LoginPage />} /> {/* Default to Login */}
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
