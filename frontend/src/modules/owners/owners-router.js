import React from 'react';
import { Route, Switch } from 'react-router-dom';
import {OwnersTable} from "./components/OwnersTable";

export const OwnersRouter = () => {
    return (
        <Switch>
            <Route path='/owners' component={OwnersTable} exact />
        </Switch>
    );
};