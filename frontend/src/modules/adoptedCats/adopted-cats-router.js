import React from 'react';
import { Route, Switch } from 'react-router-dom';
import {AdoptedCatsTable} from "./components/AdoptedCatsTable";

export const AdoptedCatsRouter = () => {
    return (
        <Switch>
            <Route path='/adoptedCats' component={AdoptedCatsTable} exact />
        </Switch>
    );
};