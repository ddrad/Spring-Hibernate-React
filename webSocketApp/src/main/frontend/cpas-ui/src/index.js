import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import Login from './components/login/Login';



ReactDOM.render(<Login/>,
                 document.getElementById('root'));

registerServiceWorker();

