import React, { Component } from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Analysis from './components/Analysis';

import './../tachyons/css/tachyons.css';
import './css/App.css';



class App extends Component {
  render() {
    return (
      <div className="App sans-serif">
        <Header />

        <div className="Main">
          <Analysis />
        </div>

        <Footer />
      </div>
    );
  }
}

export default App;
