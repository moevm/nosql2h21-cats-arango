import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import { routes } from 'routes';

export function Routes() {
  return (
    <Switch>
      {routes.map(({ routes }) => routes.map(({ path, redirect, component, name, exact }) => redirect ? (<Redirect from={path} to={redirect} exact={exact} />) : (
        <Route key={name} path={path} exact={exact}>{component}</Route>)))}
    </Switch>
  );
}
