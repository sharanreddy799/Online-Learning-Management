import React from "react";
import { Link } from "react-router-dom";
import "../assets/css/header.css";
const Header = () => {
  return (
    <header className="header">
      <nav className="navbar">
        <ul className="nav-list">
          <li className="nav-item">
            <Link to="/">Home</Link>
          </li>
          <li className="nav-item">
            <Link to="/login">Login</Link>
          </li>
          <li className="nav-item">
            <Link to="/register">Register</Link>
          </li>
          <li className="nav-item">
            <Link to="/dashboard">Dashboard</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
};
export default Header;
