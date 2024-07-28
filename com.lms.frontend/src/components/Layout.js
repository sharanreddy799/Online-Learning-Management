import React from "react";
import { Outlet, Link } from "react-router-dom";
import Home from "../pages/Home";
import Register from "./Register";
import Dashboard from "../pages/Dashboard";
const Layout = () => {
  return (
    <div>
      <nav>
        <Link to="/">
          <Home />
        </Link>
        <Link to="/register">
          <Register />
        </Link>
        <Link to="/dashboard">
          {" "}
          <Dashboard />
        </Link>
      </nav>
    </div>
  );
};

export default Layout;
