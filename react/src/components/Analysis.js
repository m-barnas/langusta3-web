import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Highlighter from './Highlighter';
import {MdRefresh, MdMailOutline} from 'react-icons/lib/md';

class Analysis extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
      words: ['příliš', 'kůň', 'ódy'],
      highlighter: null
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.parse = this.parse.bind(this);
  }

  handleChange(event) {
    this.setState({
      value: event.target.value
    });
  }
  handleSubmit(event) {
    this.parse();
    event.preventDefault();
  }

  parse() {
    // let string = this.state.value;
    // let words = string.trim().split(/[\s,]+/);

    // this.setState({
    //   words: words
    // })
  }

  render() {
    return (
      <main className="Analysis">
        <div className="Container pv5">

          <form className="cf mb3" onSubmit={this.handleSubmit}>
            <div className="cf mb2">
              <div className="fl w-50 pr3">
                <textarea className="AnalysisInput FormControl" rows="3" onChange={this.handleChange} value={this.state.value} />
              </div>
              <div className="fl w-50 pl3">
                <div className="AnalysisResult FormControl overflow-y-auto bg-near-white">
                  <Highlighter
                    className="AnalysisResult-inner db"
                    searchWords={this.state.words}
                    textToHighlight={this.state.value}
                  />
                </div>
              </div>
            </div>

            <button className="Button Button--primary fr" type="submit"><MdRefresh className="Button-icon" /> Analyze</button>
          </form>

          <div className="mw6 center cf">
            <div className="fl w-50 pr3">
              <WordAnalysis />
            </div>
            <div className="fl w-50 pl3">
              <WordForms />
            </div>
          </div>

          <div className="mw6 center tc mt5 f6">
            <a className="link gray underline-hover" href="#"><MdMailOutline className="Button-icon" /> Nahlásit chybu/požádat o doplnění</a>
          </div>
        </div>
      </main>
    );
  }
}

export default Analysis;