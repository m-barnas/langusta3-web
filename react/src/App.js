import React, { Component } from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import AnalysisContainer from './containers/AnalysisContainer';
import RegexContainer from './containers/RegexContainer';
import PatternSearchContainer from './containers/PatternSearchContainer';
import PatternCountSearchContainer from './containers/PatternCountSearchContainer';
import AboutContainer from './containers/AboutContainer';
import ContactContainer from './containers/ContactContainer';
// import PatternContainer from './containers/PatternContainer';

// import './../tachyons/css/tachyons.css';
import 'tachyons';
import './css/App.css';

// const isReactComponent = (obj) => Boolean(obj && obj.prototype && Boolean(obj.prototype.isReactComponent));

// const component = (component) => {
//   return isReactComponent(component)
//     ? {component}
//     : {getComponent: (loc, cb)=> component(
//          comp=> cb(null, comp.default || comp))}
// };

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App sans-serif">
          <Header />

          <div className="Main">
            <Route exact={true} path="/" component={AnalysisContainer}/>
            <Route path="/regex" component={RegexContainer}/>
            <Route path="/pattern-search" component={PatternSearchContainer}/>
            <Route path="/pattern-count-search" component={PatternCountSearchContainer}/>
            <Route path="/about" component={AboutContainer}/>
            <Route path="/contact" component={ContactContainer}/>
          </div>

          <Footer />
        </div>
      </Router>
    );
  }
}

export default App;
