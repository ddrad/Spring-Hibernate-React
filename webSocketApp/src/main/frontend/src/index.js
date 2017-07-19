import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import Login from './components/login/Login';
import App from './components/app/App';
import Registration from './components/registration/Registration';

import {BrowserRouter as Router, Switch, Route } from 'react-router-dom'



ReactDOM.render(
    <Router>
     <Switch>
      <Route exact path='/' component={App}/>
      <Route path='/login' component={Login}/>
      <Route path='/registration' component={Registration}/>
    </Switch>
    </Router>
    ,document.getElementById('root'));

registerServiceWorker();

