import React, {Component} from 'react';
import './static/css/App.css';
import Greeting from './Greeting';
import { Switch, Route, Redirect } from 'react-router-dom'

class Content extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route exact path='/' component={Greeting}/>
                </Switch>
            </div>
        );
    }
}

export default Content;