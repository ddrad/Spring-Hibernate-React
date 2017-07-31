import React, {Component} from 'react';
import './static/css/cpas.css';
import ms_header_ico from './static/img/ms_header_ico.png';
import email_header_ico from './static/img/email_header_ico.png'
import facebook_header_ico from './static/img/facebook_header_ico.png';

class Header extends Component {

    render() {
        return (
                <div className="header">
                    <div className="header-top">
                        <div className="header-top-nav">
                            <ul className="nav">
                                <li className="drop"><a href="#">Konto</a>
                                    <ul>
                                        <li><a href="#">Konto_1</a></li>
                                        <li><a href="#">Konto_2</a>
                                            <ul>
                                                <li><a href="#">Konto_2_1</a></li>
                                                <li><a href="#">Konto_2_2</a></li>
                                                <li><a href="#">Konto_2_3</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="#">Zaloguj się</a></li>
                            </ul>
                        </div>
                        <div className="header-top-logo">
                            <a href="./static/img/ms_header_ico.png">
                                <img src={ms_header_ico} alt="Email"/>
                            </a>
                        </div>
                    </div>
                    <div className="logo"><h1>Lorem.to - Jak pomaga</h1></div>
                    <div className="menu">
                        <div className="soc">
                            <a href="./static/img/email_header_ico.png">
                                <img src={email_header_ico} alt="Email"/>
                            </a>
                            <a href="./static/img/facebook_header_ico.png">
                                <img src={facebook_header_ico} alt="Facebook"/>
                            </a>
                        </div>
                        <div id="nav">
                            <ul>
                                <li><a href="#">Main page</a></li>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Article</a></li>
                                <li><a href="#">Workshops</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
        );
    }
}

export default Header;