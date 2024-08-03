import React from "react";
import { Outlet, Link } from "react-router-dom";
import Home from "../pages/Home";
import Register from "./Register";
import Dashboard from "../pages/Dashboard";
import LoginPage from "./LoginPage";
const Layout = () => {
  return (
    <div>
      <nav>
        <Link to="/Home">
          <Home />
        </Link>
        <Link to="/dashboard">
          <Dashboard />
        </Link>
      </nav>
    </div>
  );
};

export default Layout;
