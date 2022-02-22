import React, { useState } from 'react';
import { Layout } from 'antd';
import { Aside } from '../../aside';
import styles from './App.module.scss';
import 'antd/dist/antd.css';
import { Routes } from './Routes';

export const App = function () {
  const [collapsed, setCollapsed] = useState(false);
  const onCollapse = (collapse) => {
    setCollapsed(collapse);
  };
  const { Header, Content } = Layout;
  return (
    <Layout className={styles.layout}>
      <Aside collapsed={collapsed} onCollapse={onCollapse} />
      <Layout>
        <Header className={styles.header} />
        <Content className={styles.content}>
          <Routes />
        </Content>
      </Layout>
    </Layout>
  );
};

