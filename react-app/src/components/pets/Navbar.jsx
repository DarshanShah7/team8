// Navbar.jsx
import React from "react";
import { Link } from "react-router-dom"; // If using React Router
import styles from "./Navbar.module.css"; // Import your CSS module

const Navbar = () => {
  return (
    <nav className={styles.navbar}>
      <div className={styles.logo}>Bonds</div>
      <ul className={styles.navLinks}>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/securities">Securities</Link></li>
        <li><Link to="/trades">Trades</Link></li>
        <li><Link to="/login">Login</Link></li>
        {/* Add more navigation links as needed */}
      </ul>
    </nav>
  );
};

export default Navbar;
