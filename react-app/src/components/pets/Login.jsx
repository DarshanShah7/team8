// Login.js
import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom"; // Import Link for routing
import styles from "./Login.module.css"; // Import your CSS module

const Login = () => {
  const history = useHistory();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = () => {
    if (username === "user" && password === "password") {
      history.push("/dashboard");
    } else {
      setError("Invalid username or password");
    }
  };

  return (
    <div className={styles["login-container"]}>
      <h2 className={styles["login-title"]}>Login</h2>
      <div>
        <input
          type="text"
          className={styles["login-input"]}
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div>
        <input
          type="password"
          className={styles["login-input"]}
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button className={styles["login-button"]} onClick={handleLogin}>
        Login
      </button>
      {error && <div className={styles["login-error"]}>{error}</div>}

      {/* Link to the registration page */}
      <div className={styles["register-link"]}>
        Don't have an account? <Link to="/register">Register</Link>
      </div>
    </div>
  );
};

export default Login;
