import { Layout } from 'antd';
import React from 'react';
import { Logo } from './Logo';
// import { Sections } from './Sections';

const { Sider } = Layout;

export const Aside = function ({ collapsed, onCollapse }) {
  return (
    <Sider collapsible collapsed={collapsed} width='300px' onCollapse={onCollapse}>
      <Logo />
      {/* <Sections /> */}
    </Sider>
  );
};
