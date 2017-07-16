import React, {Component} from 'react';

class Login extends Component {

 constructor(props) {
    super(props);
    this.state = {login: '', password: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({
        [event.target.name] : event.target.value}
    );
  }

  handleSubmit(event) {
    
    let loginRequest = {
        type: "LOGIN_CUSTOMER",
        sequenceId: "",
      data : {
          login: this.state.login,
          password : this.state.password,
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
    function(response) {  
      console.log(response);
      if (response.status !== 200) {  
        console.log('Looks like there was a problem. Status Code: ' +  
          response.status);  
        return;  
      }

      // Examine the text in the response  
      response.json().then(function(data) {  
        console.log(data);  
      });  
    }  
  )  
  .catch(function(err) {  
    console.log('Fetch Error :-S', err);  
  });

    event.preventDefault();
  }

  render() {
        return (
          <form onSubmit={this.handleSubmit}>
            <label>
                Name:
                <input type="text" name="login" value={this.state.value} onChange={this.handleChange} />
            </label>            
             <label>
                Password:
                <input type="text" name="password" value={this.state.value} onChange={this.handleChange} />
            </label>            
            <input type="submit" value="Submit" />
          </form>    
        );
    }
}

export default Login;