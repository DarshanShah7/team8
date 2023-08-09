// Registration.js
import React, { useState } from "react";
import { useHistory, Link } from "react-router-dom";
import styles from "./Registration.module.css"; // Import your CSS module

const Registration = () => {
  const history = useHistory();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [role, setRole] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errors, setErrors] = useState({
    name: "",
    email: "",
    role: "",
  });

  const handleRegistration = () => {
    const newErrors = {};

    if (!name) {
      newErrors.name = "Name is required";
    }
    if (!email) {
      newErrors.email = "Email is required";
    } else if (!/\S+@\S+\.\S+/.test(email)) {
      newErrors.email = "Invalid email format";
    }
    if (!role) {
      newErrors.role = "Role is required";
    }

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    // Simulate a registration process (replace with actual registration logic)
    const newUser = { name, email, role };
    setSuccessMessage("Registration successful!");
  };

  return (
    <div className={styles["registration-container"]}>
      <h2 className={styles["registration-title"]}>Registration</h2>
      <div>
        <input
          type="text"
          className={styles["registration-input"]}
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        {errors.name && <div className={styles["registration-error"]}>{errors.name}</div>}
      </div>
      <div>
        <input
          type="email"
          className={styles["registration-input"]}
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        {errors.email && <div className={styles["registration-error"]}>{errors.email}</div>}
      </div>
      <div>
        <input
          type="text"
          className={styles["registration-input"]}
          placeholder="Role"
          value={role}
          onChange={(e) => setRole(e.target.value)}
        />
        {errors.role && <div className={styles["registration-error"]}>{errors.role}</div>}
      </div>
      <button className={styles["registration-button"]} onClick={handleRegistration}>
        Register
      </button>
      {successMessage && <div className={styles["registration-success"]}>{successMessage}</div>}
      <div className={styles["login-link"]}>
        Already have an account? <Link to="/login">Login</Link>
      </div>
    </div>
  );
};

export default Registration;
