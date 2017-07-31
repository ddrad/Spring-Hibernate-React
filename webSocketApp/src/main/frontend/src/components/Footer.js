import React, {Component} from 'react';
import './static/css/cpas.css';

class Footer extends Component {

    render() {
        return (
            <div className="footer">
                <div className="footer-content">
                    <div className="footer-content-main">
                        <div className="footer-content-main-inline">
                            <div className="footer-content-main-item">
                                <ul className="ui-ico">
                                    <li className="heading">Strony produktów</li>
                                    <li className="windows">
                                        <a href="#">Windows</a>
                                    </li>
                                    <li className="office"><a target="_self" className="mscom-link" href="#">Office</a>
                                    </li>
                                    <li className="surface"><a target="_self" className="mscom-link"
                                                           href="#">Surface</a>
                                    </li>
                                    <li className="lumia">
                                        <a target="_self" className="mscom-link" href="#">Lumia</a>
                                    </li>
                                    <li className="xbox"><a target="_self" className="mscom-link" href="#">Xbox</a></li>
                                    <li className="skype">
                                        <a target="_self" className="mscom-link" href="#">Skype</a>
                                    </li>
                                    <li className="msn"><a target="_self" className="mscom-link" href="#">MSN Polska</a></li>
                                    <li className="bing"><a target="_self"
                                                        className="mscom-link" href="#">Bing</a></li>
                                    <li className="msstore"><a target="_self"
                                                           className="mscom-link" href="#">Microsoft Store</a></li>
                                </ul>
                            </div>
                            <div className="footer-content-main-item">
                                <ul className="simple">
                                    <li className="heading">Do pobrania</li>
                                    <li><a href="#">Centrum pobierania</a></li>
                                    <li><a href="#">System Windows - produkty i materiały do pobrania</a></li>
                                    <li><a href="#">Bezpłatne pliki do pobrania</a></li>
                                    <li><a href="#">Internet Explorer</a></li>
                                    <li><a href="#">Sprzęt i sterowniki</a></li>
                                    <li><a href="#">Produkty pakietu Office</a></li>
                                </ul>
                            </div>
                            <div className="footer-content-main-item">
                                <ul className="simple">
                                    <li className="heading">Wsparcie</li>
                                    <li><a href="#">Pomoc techniczna</a></li>
                                    <li><a href="#">Bezpłatny antywirus</a></li>
                                    <li><a href="#">Windows Update: Dodatki Service Pack, poprawki i więcej</a></li>
                                    <li><a href="#">Windows - Pomoc i instrukcje</a></li>
                                    <li><a href="#">Office (Outlook, Excel i inne)</a></li>
                                </ul>
                                <ul className="simple">
                                    <li className="heading">Informacje</li>
                                    <li><a href="#">Konto Microsoft</a></li>
                                    <li><a href="#">Kariera w Microsoft</a></li>
                                    <li><a href="#">Centrum Prasowe</a></li>
                                    <li><a href="#">Odpowiedzialność społeczna</a></li>
                                    <li><a href="#">Mapa witryny</a></li>
                                    <li><a href="#">Kontakt z Microsoft</a></li>
                                </ul>
                            </div>
                            <div className="footer-content-main-item">
                                <ul className="simple">
                                    <li className="heading">Popularne zasoby
                                    </li>
                                    <li><a href="#">Przejdź na Windows 10</a></li>
                                    <li><a href="#">Office 365 - polska baza wiedzy</a></li>
                                    <li><a href="#">Internet Explorer- uaktualnij</a></li>
                                    <li><a href="#">Urządzenia z Windows 10</a></li>
                                    <li><a href="#">Aplikacje i gry na Windows Phone</a></li>
                                    <li><a href="#">Aplikacje i gry na Windows</a></li>
                                    <li><a href="#">Opisy wdrożeń (eng. case studies)</a></li>
                                </ul>
                            </div>
                        </div>


                        <div className="footer-down">

                            {/*<div className="footer-content-main-item">*/}
                        {/*<span>*/}
                        {/*<a target="_self" className="mscom-link"*/}
                           {/*href="#">Polska - Polski</a></span>*/}
                            {/*</div>*/}
                            <div className="footer-content-main-item">
                                <ul className="f-d-u">
                                    <li><a target="_self" className="mscom-link"
                                              href="#">Polska - Polski</a></li>
                                    <li><a href="#">Pomoc</a></li>
                                    <li><a href="#">Poufność i cookies</a></li>
                                    <li><a href="#">Zasady użytkowania</a></li>
                                    <li><a href="#">Znaki towarowe</a></li>
                                    <li><a href="#">Informacje o naszych reklamach</a></li>
                                    <li className="heading">© 2016 Microsoft</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Footer;
