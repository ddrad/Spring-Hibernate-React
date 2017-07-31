import React, {Component} from 'react';
import './static/css/cpas.css';
import social_button_facebook from './static/img/facebook_ico.png'
import social_button_email from './static/img/email_ico.png'

class ConnectWithUs extends Component {

    render() {
        return (
            <div className="contact" data-cols="1" data-view1="1" data-view2="1" data-view3="1" data-view4="1">
                <div className="span bp0-col-1-1 bp1-col-1-1 bp2-col-1-1 bp3-col-1-1">
                    <div className="row-fluid grid-container pd60 contact-us" data-cols="1" data-view1="1" data-view2="1"
                         data-view3="1" data-view4="1">
                        <div className="contact-text">
                            <div className="contact-text-content">
                                <h2 className="purple">Skontaktuj się&nbsp;z&nbsp;nami</h2>

                                <p className="w50">Nulla dictum tincidunt turpis eu consequat. Sed adipiscing eros a nici dictum
                                    mollis, Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere</p>
                            </div>
                            <div className="social-buttons">
                                <a target="_self" className="" href="#">
                                    <img src={social_button_email} width="112" height="112"/>
                                </a>
                                <a target="_self" href="#">
                                    <img src={social_button_facebook} width="112" height="112"/></a></div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ConnectWithUs;
