import React from 'react';
import { Route, Switch } from 'react-router-dom';
import {CatsTable} from "./components/CatsTable";

export const CatsRouter = () => {
    return (
        <Switch>
            <Route path='/cats' component={CatsTable} exact />
        </Switch>
    );
};