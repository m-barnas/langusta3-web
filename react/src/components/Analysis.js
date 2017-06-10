import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Highlighter from './Highlighter';
import {MdRefresh, MdMailOutline} from 'react-icons/lib/md';
import { fetchAnalyzedWords } from './../util/api';
import { getGrammaticalCases } from './../util/enums';
import { getWords } from './../util/data.js';

class Analysis extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
      isLoading: false,
      value: 'Bezpečné heslo je jedno z nejlepších',
      words: [],
      wordStrings: [],
      selectedWord: null,
      selectedPatternData: null
    };

    const grammaticalCases = getGrammaticalCases();

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleWordSelect = this.handleWordSelect.bind(this);
    this.handlePatternSelect = this.handlePatternSelect.bind(this);
    this.parseValue = this.parseValue.bind(this);
  }

  handleChange(event) {
    this.setState({
      value: event.target.value
    });
  }
  handleSubmit(event) {
    event.preventDefault();

    this.setState({
      isLoading: true
    });

    let value = this.parseValue(this.state.value);
    // let words = getWords();

    fetchAnalyzedWords(value).then((words) => {
      let wordStrings = [];

      for (let word of words) {
        wordStrings.push(word.inputValue);
      }
      // console.log(words);

      this.setState({
        isLoading: false,
        words: words,
        wordStrings: wordStrings
      });
    })

    // console.log(value);
  }

  handleWordSelect(selectedWord) {
    this.setState({
      selectedWord: selectedWord,
      selectedPatternData: selectedWord.getData().patterns[0]
    })
  }

  handlePatternSelect(selectedPatternData) {
    console.log('hej');
    this.setState({
      selectedPatternData: selectedPatternData
    })
  }

  parseValue(value) {
    return value.replace(/\s/g, "-");
  }

  render() {
    return (
      <main className="Analysis">
        <div className="Container pv5">
          <h1 className="mt0 tc">Analýza</h1>
          <form className="mw7 center cf mb3" onSubmit={this.handleSubmit}>
            <div className="cf mb2">
              <div className="fl w-50 pr2">
                <textarea className={"AnalysisInput FormControl" + (this.state.isLoading ? " is-loading" : "")}
                 rows="3" onChange={this.handleChange} value={this.state.value}
                 disabled={this.state.isLoading} maxlength="255"/>
              </div>
              <div className="fl w-50 pl2">
                <div className={"AnalysisResult FormControl overflow-y-auto bg-near-white" + (this.state.isLoading ? " is-loading" : "")}>
                  <Highlighter
                    className="AnalysisResult-inner db"
                    searchWords={this.state.wordStrings}
                    textToHighlight={this.state.value}
                    onWordSelect={this.handleWordSelect}
                    words={this.state.words}
                  />
                </div>
              </div>
            </div>

            <button className={"Button Button--primary fr" + (this.state.isLoading ? " is-loading" : "") } 
              type="submit" disabled={this.state.isLoading}>
              <MdRefresh className="Button-icon" /> Analyze
            </button>
          </form>

          <div className="mw7 center cf">
            <div className="fl w-30 pr3">
              <WordAnalysis word={ this.state.selectedWord } onPatternSelect={this.handlePatternSelect} isLoading={this.state.isLoading}/>
            </div>
            <div className="fl w-70 pl3">
              <WordForms word={this.state.selectedWord} patternData={this.state.selectedPatternData}  isLoading={this.state.isLoading}/>
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