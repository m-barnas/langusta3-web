import React, { Component } from 'react';
import DropdownMenu from 'react-dd-menu';
import Analysis from './Analysis';
import {Link} from 'react-router-dom';
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
      animate: false
    };
    return (
      <header className="Header bb b--black-10">
        <div className="Container">
          <nav className="Nav dt-ns w-100">
            <div className="dtc v-mid">
              <Link to="/" className="Nav-logo link black underline-hover b">Langusta3-web</Link>
            </div>
            <div className="dtc v-mid tr">
              <ul className="Nav-menu list mv0">
                <li className="dib mr4"><Link to="/" className="pv3 db link black underline-hover">Analýza</Link></li>
                <li className="dib mr4">
                  <DropdownMenu {...menuOptions}>
                    <li><Link to="/">Podle vzoru</Link></li>
                    <li><Link to="/">Regex</Link></li>
                    <li><Link to="/">Počet slov podle vzoru</Link></li>
                  </DropdownMenu>
                </li>
                <li className="dib mr4"><Link to="/" className="pv3 db link black underline-hover">O projektu</Link></li>
                <li className="dib"><Link to="/" className="pv3 db link black underline-hover">Kontakt</Link></li>
              </ul>
            </div>
          </nav>
        </div>
      </header>
    );
  }
}

export default Header;