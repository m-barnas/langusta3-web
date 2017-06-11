import React, { Component } from 'react';
import DropdownMenu from 'react-dd-menu';
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

  toggle(event) {
    event.preventDefault();
    this.setState({ isMenuOpen: !this.state.isMenuOpen });
  };

  close() {
    this.setState({ isMenuOpen: false });
  };
  render() {
    let menuIcon = null;
    if (this.state.isMenuOpen) {
      menuIcon = <MdExpandLess className="icon ml1" />
    } else {
      menuIcon = <MdExpandMore className="icon ml1" />
    }

    let menuOptions = {
      isOpen: this.state.isMenuOpen,
      close: this.close,
      toggle: <a className="pv2 db link color-inherit underline-hover" href="#" onClick={this.toggle}>Hledat{menuIcon}</a>,
      align: 'center',
      animate: false
    };
    return (
      <header className="Header bb b--black-10">
        <div className="Container">
          <nav className="Nav dt-m dt-l w-100">
            <div className="dtc-ns v-mid tc tl-ns mt3">
              <Link to="/" className="Nav-logo link color-inherit underline-hover b">Langusta3</Link>
            </div>
            <div className="dtc-ns v-mid tc tr-ns">
              <ul className="Nav-menu list mv0 pa0 pv2">
                <li className="dib mr3 mr4-l"><Link to="/" className="pv2 db link color-inherit underline-hover">Analýza</Link></li>
                <li className="dib mr3 mr4-l">
                  <DropdownMenu {...menuOptions}>
                    <li><Link to="/pattern-search">Podle vzoru</Link></li>
                    <li><Link to="/regex">Regex</Link></li>
                    <li><Link to="/pattern-count-search">Počet slov podle vzoru</Link></li>
                  </DropdownMenu>
                </li>
                <li className="dib mr3 mr4-l"><Link to="/about" className="pv2 db link color-inherit underline-hover">O projektu</Link></li>
                <li className="dib"><Link to="/contact" className="pv2 db link color-inherit underline-hover">Kontakt</Link></li>
              </ul>
            </div>
          </nav>
        </div>
      </header>
    );
  }
}

export default Header;