import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import router from './router/Router'
import App from './components/App';
import {BrowserRouter as Router} from 'react-router-dom'


ReactDOM.render(
    <Router>
        <App/>
    </Router>
    , document.getElementById('root'));

registerServiceWorker();

