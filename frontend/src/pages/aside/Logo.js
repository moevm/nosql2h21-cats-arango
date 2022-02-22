import React from 'react';
import { Link } from 'react-router-dom';
import { ReactComponent as Logotype } from '../../assets/svg/logo.svg';
import styles from './Aside.module.scss';

export const Logo = function () {
  return (
    <Link to='/' className={styles.logo_wrapper}>
      <Logotype className={styles.logo} />
    </Link>
  );
};
