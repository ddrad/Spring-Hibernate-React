import React, {Component} from 'react';
import Button from 'react-bootstrap/lib/Button'
import {PageHeader} from 'react-bootstrap'

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {login: '', password: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({
                [event.target.name]: event.target.value
            }
        );
    }

    handleSubmit(event) {

        let loginRequest = {
            type: "LOGIN_CUSTOMER",
            sequenceId: "",
            data: {
                login: this.state.login,
                password: this.state.password,
            }
        }

        fetch(`/web-socket-app/login`,
            {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginRequest)
            })
            .then(
                function (response) {
                    console.log(response);
                    if (response.status !== 200) {
                        console.log('Looks like there was a problem. Status Code: ' +
                            response.status);
                        return;
                    }

                    // Examine the text in the response
                    response.json().then(function (data) {
                        console.log(data);
                    });
                }
            )
            .catch(function (err) {
                console.log('Fetch Error :-S', err);
            });

        event.preventDefault();
    }

    render() {
        return (

            <div className="container">
                <div className="row">

                    <div className="Absolute-Center is-Responsive">
                        <PageHeader className="text-center">Log-In</PageHeader>

                        <div className="col-sm-12 col-md-6 col-md-offset-3">

                            <form onSubmit={this.handleSubmit}>

                                <div className="form-group input-group">
                                    <span className="input-group-addon"><i
                                        className="glyphicon glyphicon-user"></i></span>
                                    <input className="form-control" type="text" name='login' placeholder="username"
                                           value={this.state.value} onChange={this.handleChange}/>
                                </div>

                                <div className="form-group input-group">
                                    <span className="input-group-addon"><i
                                        className="glyphicon glyphicon-lock"></i></span>
                                    <input className="form-control" type="password" name='password'
                                           placeholder="password" value={this.state.value}
                                           onChange={this.handleChange}/>
                                </div>

                                <div className="form-group">
                                    <Button type="submit" className="btn btn-primary btn-block">Log-in</Button>
                                </div>
                                <div className="form-group text-center">
                                    <a href="#">Forgot Password</a>&nbsp;|&nbsp;<a href="#">Support</a>
                                </div>
                                <div className="form-group">
                                    <Button type="button" className="btn btn-success btn-block">New
                                        Registration</Button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

        );
    }
}

export default Login;