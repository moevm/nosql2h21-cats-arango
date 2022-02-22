import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import { routes } from '../../../routes';

export function Routes() {
  return (
    <Switch>
      <Redirect from='/' to='/cats' exact />
      {routes.map(( { path, component, name, exact }) => (
        <Route key={name} path={path} exact={exact}>{component}</Route>))}
    </Switch>
  );
}
