import React, { Component } from 'react';
import logo from './../logo.svg';

class Header extends Component {
    render() {
        return (
            <header className="Header">
              <div className="Container bb bw1">
                <nav className="Nav dt-ns w-100 pv3">
                    <div className="dtc v-mid">
                        <a className="Nav-logo link black underline-hover b" href="#">Langusta3-web</a>
                    </div>
                    <div className="dtc v-mid tr">
                        <ul className="Nav-menu list mv0">
                            <li className="dib mr4"><a className="link black underline-hover" href="#">Hledat</a></li>
                            <li className="dib mr4"><a className="link black underline-hover" href="#">Napoveda</a></li>
                            <li className="dib mr4"><a className="link black underline-hover" href="#">O projektu</a></li>
                            <li className="dib"><a className="link black underline-hover" href="#">Kontakt</a></li>
                        </ul>
                    </div>
                </nav>
              </div>
            </header>
        );
    }
}

export default Header;