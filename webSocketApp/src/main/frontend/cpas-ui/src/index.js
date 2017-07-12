import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
//import TextCounter from './TextCounter';
import Login from './Login';



ReactDOM.render(<Login userName = 'Dima'/>,
                 document.getElementById('root'));

registerServiceWorker();

