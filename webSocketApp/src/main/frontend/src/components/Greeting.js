import React, {Component} from 'react';
import './static/css/App.css';
import arcticue_1 from './static/img/arcticue_1.png';
import arcticue_2 from './static/img/arcticue_2.png';
import arcticue_3 from './static/img/arcticue_3.png';
import arcticue_4 from './static/img/arcticue_4.png';
import arcticue_5 from './static/img/arcticue_5.png';
import arcticue_6 from './static/img/arcticue_6.png';
import arcticue_7 from './static/img/arcticue_7.png';
import arcticue_8 from './static/img/arcticue_8.png';
import o_yaku_img from './static/img/o_yaku.png';
import pre_f_img from './static/img/pre_f_1.png'
import pre_f_2_img from './static/img/pre_f_2.png'
import pre_f_3_img from './static/img/pre_f_3.png'

class Greeting extends Component {
    render() {
        return (
            <div className="content">
                <div className="content_main_block">
                    <div className="inline">
                        <div className="content_block">
                            <div><span>ARTYKUŁ</span></div>
                            <div className="desc"><p>Yak aktywować darmową subskrypcję Microsoft Azure dla studentów i
                                uczniów w
                                serwisie Dreamspark</p></div>
                            <div className="content_img">
                                <img src={arcticue_1}/>
                            </div>
                        </div>
                        <div className="content_block_separate"></div>
                        <div className="content_block">
                            <div><span>ARTYKUŁ</span></div>
                            <div className="desc"><p>Yak założyć swoją pierwszą stronę WWW w chmurze – krok po kroku</p>
                            </div>
                            <div className="content_img">
                                <img className="large" src={arcticue_2}/>
                            </div>
                        </div>
                    </div>
                    <div className="inline">
                        <div className="content_block">
                            <div><span>ARTYKUŁ</span></div>
                            <div className="desc"><p>Yak aktywować darmową subskrypcję Microsoft Azure dla studentów</p>
                            </div>
                            <div className="content_img">
                                <div className="ex">
                                    <img src={arcticue_3}/>
                                </div>
                            </div>
                        </div>
                        <div className="content_block_separate"></div>
                        <div className="content_block">
                            <div><span>ARTYKUŁ</span></div>
                            <div className="desc"><p> Yak skonfigurować własne repozytorium kodu używając Visual Studio Team
                                Services
                                (wcześniej Visual Studio Online)</p></div>
                            <div className="content_img">
                                <img src={arcticue_4}/>
                            </div>
                        </div>
                    </div>
                    <div className="inline h_sep">
                        <div className="horiz_separate">ZOBACZ WIĘCEJ ARTYKUŁÓW</div>
                    </div>

                    <div className="inline">
                        <div className="content_block">
                            <div><span>VIDEO KURS</span></div>
                            <div className="desc"><p>Yak tworzyć dwuwymiarowe gry w Unity</p><br/></div>
                            <div className="content_img">
                                <img src={arcticue_5}/>
                            </div>
                        </div>
                        <div className="content_block_separate"></div>
                        <div className="content_block">
                            <div><span>VIDEO KURS</span></div>
                            <div className="desc"><p>Azure 101 – Jak napisać bardzo skalowalną aplikację na Azure dzięki
                                Service
                                Bus</p></div>
                            <div className="content_img">
                                <img className="large" src={arcticue_6}/>
                            </div>
                        </div>
                    </div>
                    <div className="inline">
                        <div className="content_block">
                            <div className="content_img">
                                <div className="without-content">
                                    <img src={arcticue_7}/>
                                </div>
                            </div>
                        </div>
                        <div className="content_block_separate"></div>
                        <div className="content_block">
                            <div><span>VIDEO KURS</span></div>
                            <div className="desc"><p> Yak zarządzać automatyczną kopią zapasowa w chmurze</p></div>
                            <div className="content_img">
                                <img className="large" src={arcticue_8}/>
                            </div>
                        </div>
                    </div>
                    <div className="inline h_sep">
                        <div className="horiz_separate">ZOBACZ WIĘCEJ KURSÓW</div>
                    </div>
                </div>

                <div className="o_yak">
                    <div className="yak_block">
                        <div className="yak_block-nav">
                            <h2 className="purple">O YAKU</h2>
                            <p>Jak (ang. Yak) czyli duży ssak z rodziny parzystokopytnych. Jaki to zwierzęta juczne,
                                dające
                                mleko i wełnę, żyjące samotnie lub w niewielkich stadach. Zamieszkują głównie Tybet,
                                Indie i
                                Chiny, ale możesz je także spotkać w Warszawskim ZOO. Właśnie tam adaptowaliśmy jednego
                                z nich,
                                a w zamian Yak zgodził się nam pomóc w opowieści o darmowej subskrypcji chmury Azure od
                                niedawna
                                dostępnej dla każdego ucznia i studenta CAŁKOWICIE BEZPŁATNIE.</p>

                            <ul>
                                <li><a href="#">GALERIA ZDJĘĆ</a></li>
                                <li><a href="#">DOWIEDZ SIĘ WIĘCEJ</a></li>
                            </ul>
                        </div>
                        <div className="yak_block-logo">
                            <a href="./static/img/ms_header_ico.png">
                                <img src={o_yaku_img} alt="O Yaku"/>
                            </a>
                        </div>
                    </div>
                </div>

                <div className="nav-panel">
                    <div className="nav-panel-content">
                        <ul>
                            <li><a href="#"> <img src={pre_f_img}/></a></li>
                            <li className="middle"><a href="#"> <img src={pre_f_2_img} alt="Microsoft Virtual Academy"/></a>
                            </li>
                            <li><a href="#"> <img src={pre_f_3_img} alt="MSDN"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>

        );
    }
}

export default Greeting;
            