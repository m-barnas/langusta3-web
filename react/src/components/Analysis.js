import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Highlighter from './Highlighter';
import {MdRefresh, MdMailOutline} from 'react-icons/lib/md';
import { fetchAllPatterns } from './../util/api';

class Analysis extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
      words: ['příliš', 'kůň', 'ódy'],
      selectedWord: null
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleWordSelect = this.handleWordSelect.bind(this);
    this.parse = this.parse.bind(this);
  }

  handleChange(event) {
    this.setState({
      value: event.target.value
    });
  }
  handleSubmit(event) {
    // this.parse();
    event.preventDefault();
    let data = fetchAllPatterns();

    data.then((data) => {
      console.log(data);
    })
  }
  handleWordSelect(selectedWord) {
    this.setState({
      selectedWord: selectedWord
    })
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
          <h1 className="mt0 tc">Analýza</h1>
          <form className="mw7 center cf mb3" onSubmit={this.handleSubmit}>
            <div className="cf mb2">
              <div className="fl w-50 pr2">
                <textarea className="AnalysisInput FormControl" rows="3" onChange={this.handleChange} value={this.state.value} />
              </div>
              <div className="fl w-50 pl2">
                <div className="AnalysisResult FormControl overflow-y-auto bg-near-white">
                  <Highlighter
                    className="AnalysisResult-inner db"
                    searchWords={this.state.words}
                    textToHighlight={this.state.value}
                    onWordSelect={this.handleWordSelect}
                  />
                </div>
              </div>
            </div>

            <button className="Button Button--primary fr" type="submit">
              <MdRefresh className="Button-icon" /> Analyze
            </button>
          </form>

          <div className="mw7 center cf">
            <div className="fl w-30 pr3">
              <WordAnalysis />
            </div>
            <div className="fl w-70 pl3">
              <WordForms word="advokát" pattern="student" />
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