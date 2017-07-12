import React, {Component} from 'react';
import ReactDOM from 'react-dom';



class Login extends Component {

    render() {
        return (
            <div className="Login">
               <h2>Welcome {this.props.userName} for Login</h2>
            </div>
        );
    }
}


Login.defaultProps = {
   userName: 'Unknower'
};

export default Login;