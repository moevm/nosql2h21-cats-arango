import React, { useCallback } from 'react';
import { Menu } from 'antd';
import { useHistory } from 'react-router-dom';
import { routes } from '../../routes';

const { SubMenu } = Menu;

export const Sections = function () {
  const { push } = useHistory();
  const navigate = useCallback((path) => {
    push(path);
  }, [push]);

  console.log(routes);

  return (
    <Menu theme='dark' defaultOpenKeys={['Коты в  приюте']} mode='inline' defaultSelectedKeys={['Коты в  приюте']}>
      {routes.map((route) => {
        return (route.routes ?
          <SubMenu key={route.name} title={route.name} icon={route.icon}>
            {route.routes.map((subroute) => {
              return (subroute.name ?
                <Menu.Item
                  key={subroute.name}
                  disabled={Boolean(subroute.disabled)}
                  icon={subroute.icon}
                  onClick={() => {
                    navigate(subroute.path);
                  }}
                >{subroute.name}
                </Menu.Item> : null);
            })}
          </SubMenu>
          : <Menu.Item
            key={route.name}
            icon={route.icon}
            onClick={() => {
              navigate(route.path);
            }}
            >{route.name}
            </Menu.Item>);
      })}
    </Menu>
  );
};
