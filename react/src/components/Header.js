import React, { Component } from 'react';
import logo from './../logo.svg';
import DropdownMenu from 'react-dd-menu';
import {MdExpandMore, MdExpandLess} from 'react-icons/lib/md';

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isMenuOpen: false
    }

    this.toggle = this.toggle.bind(this);
    this.close = this.close.bind(this);
  }

  toggle() {
    this.setState({ isMenuOpen: !this.state.isMenuOpen });
  };

  close() {
    this.setState({ isMenuOpen: false });
  };
  render() {
    let menuIcon = null;
    if (this.state.isMenuOpen) {
      menuIcon = <MdExpandLess />
    } else {
      menuIcon = <MdExpandMore />
    }

    let menuOptions = {
      isOpen: this.state.isMenuOpen,
      close: this.close,
      toggle: <a className="link black underline-hover" href="#" onClick={this.toggle}>Hledat {menuIcon}</a>,
      align: 'center',
    };
    return (
      <header className="Header bb b--black-10">
        <div className="Container">
        <nav className="Nav dt-ns w-100 pv3">
          <div className="dtc v-mid">
            <a className="Nav-logo link black underline-hover b" href="#">Langusta3-web</a>
          </div>
          <div className="dtc v-mid tr">
            <ul className="Nav-menu list mv0">
              <li className="dib mr4">
                <DropdownMenu {...menuOptions}>
                  <li><a href="#">Výraz nebo text</a></li>
                  <li><a href="#">Podle vzoru</a></li>
                  <li><a href="#">Regex</a></li>
                  <li><a href="#">Počet slov podle vzoru</a></li>
                </DropdownMenu>
              </li>
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