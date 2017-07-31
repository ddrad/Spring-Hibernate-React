import React, {Component} from 'react';
import './static/css/App.css';
import Header from './Header'
import Main from './Main'
import Banner from './Banner'
import Footer from "./Footer";
import ConnectWithUs from "./ConnectWithUs";

class App extends Component {
    render() {
        return (
          <div>
              <Header/>
              <Banner/>
              <Main/>
              <ConnectWithUs/>
              <Footer/>
          </div>
        );
    }
}

export default App;
