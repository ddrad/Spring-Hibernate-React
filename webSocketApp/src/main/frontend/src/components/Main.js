import React, {Component} from 'react';
import { Switch, Route, Redirect } from 'react-router-dom'
import Login from '../components/Login';
import Welcome from './Content';

class Main extends Component {
    render() {
        return (
            <div>
                <Switch>
                    {/*<Route exact path='/' render={() => (isValidTokenAlias('valid-alias-test') ? <Welcome/> : <Redirect to={'/login'}/>*/}
                    {/*)}/>*/}
                    <Route exact path='/' component={Welcome}/>
                    <Route path='/login' component={Login}/>
                    <Route path='/registration' component={Welcome}/>
                </Switch>
            </div>
        );
    }
}

function isValidTokenAlias(alias) {
    {/* Here we have to check token alis*/
    }
    const val = true;
    console.log('isValidTokenAlias = ' + val);
    return val;
}

export default Main;