import React, { Component } from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import AnalysisContainer from './containers/AnalysisContainer';
import RegexContainer from './containers/RegexContainer';

import './../tachyons/css/tachyons.css';
import './css/App.css';



class App extends Component {
  render() {
    return (
      <Router>
        <div className="App sans-serif">
          <Header />

          <div className="Main">
            <Route exact={true} path="/" component={AnalysisContainer}/>
            <Route path="/regex" component={RegexContainer}/>
          </div>

          <Footer />
        </div>
      </Router>
    );
  }
}

export default App;
