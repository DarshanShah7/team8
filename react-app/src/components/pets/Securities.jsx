import React, { useState, useEffect } from "react";
import { findSecurities } from "../../services/SecurityService";
// import styles from "./Securities.module.css";
import styles from './Securities.module.css';

export const Securities = () => {
    const [securities, setSecurities] = useState([]);

    useEffect(() => {
      findSecurities()
            .then(({data}) => {
              setSecurities(data);
            });
    }, []);
    const formatDate = (dateString) => {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, "0");
      const day = date.getDate().toString().padStart(2, "0");
      return `${year}-${month}-${day}`;
    };
  return (
    <>
        { securities.map(security => 
        <div className={styles.securities}>
        <div className={styles.infoItem}><strong>Issuer:</strong> {security.issuer}</div>
        <div className={styles.infoItem}><strong>Maturity date:</strong> {formatDate(security.maturityDate)}</div>
          <div className={styles.infoItem}><strong>Coupon:</strong> {security.coupon}</div>
          <div className={styles.infoItem}><strong>Type:</strong> {security.type}</div>
          <div className={styles.infoItem}><strong>Face Value:</strong> {security.faceValue}</div>
          <div className={styles.infoItem}><strong>Status:</strong> {security.status}</div>
        </div>)
        }
    </>
  )
};

export default Securities;
