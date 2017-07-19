import React, {Component} from 'react';

import Login from './login/Login';
import App from './app/App';
import Registration from './registration/Registration';
import {BrowserRouter as Router, Switch, Route, Link, Redirect} from 'react-router-dom'


const Links = () => (
    <nav>
        <Link to='/'>App</Link>
        <Link to='/login'>Login</Link>
        <Link to='/registration'>Registration</Link>
    </nav>
);

const Main = () => (
    <Router>
        <Switch>
            <Route exact path='/' render={() => (
                isValidTokenAlias('valid-alias-test') ? <App/> : <Redirect to={'/login'}/>
            )}/>
            <Route path='/login' component={Login}/>
            <Route path='/registration' component={Registration}/>
        </Switch>
    </Router>
)

function isValidTokenAlias(alias) {
    {/* Here we have to check token alis*/
    }
    const val = false;
    console.log('isValidTokenAlias = ' + val);
    return val;
}

export default Main