import React, {Component} from 'react';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Word from './Word';
import Words from './Words';
import {MdRefresh} from 'react-icons/lib/md';
import { getWords } from './../util/data.js';

export default class Regex extends Component {
  constructor(props) {
    super(props);

    this.state = {
      // value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
      isLoading: false,
      selectedWord: null,
      selectedPatternData: null,
      words: null
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleWordSelect = this.handleWordSelect.bind(this);
    this.handlePatternSelect = this.handlePatternSelect.bind(this);
  }

  handleSubmit(event) {
    event.preventDefault();

    this.setState({
      isLoading: true
    });

    // let value = this.parseValue(this.state.value);
    let words = getWords();

    // fetchAnalyzedWords(value).then((words) => {

      // console.log(words);

      this.setState({
        isLoading: false,
        words: words,
      });
    // })

    // console.log(value);
  }

  handleWordSelect(selectedWord) {
    console.log(selectedWord)
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
  render() {
    let words = this.state.words;

    return (
      <main className="Regex">
        <div className="Container pv5">
          <h1 className="mt0 tc">RegEx</h1>
          <div className="mw7 center cf mb4">
            <form className="flex" onSubmit={this.handleSubmit}>
              <div className="flex-auto">
                <input className="RegexInput FormControl code" type="text" placeholder="/([A-Z])\w+/g"/>
              </div>
              <button className="Button Button--primary ml3" type="submit">
                <MdRefresh className="Button-icon" /> Analyze
              </button>
            </form>
            <div className="mt3">
              { words !== null && 
                <div className="AnalysisResult FormControl overflow-y-auto bg-near-white">
                  <Words ref={(words) => {this.words = words}} onWordSelect={this.handleWordSelect} >
                    {words.map((word, index) => (
                      <Word 
                      className="Word js-word mr2"
                      key={ index }
                      onClick={ (selectedWord) => this.words.handleWordClick(selectedWord) }
                      data={ word }>
                        {word.inputValue}
                      </Word>
                    ))}
                  </Words>
                </div>
              }
            </div>
          </div>
          <div className="mw7 center cf">
            <div className="fl w-30 pr3">
              <WordAnalysis word={ this.state.selectedWord } onPatternSelect={this.handlePatternSelect} isLoading={this.state.isLoading} />
            </div>
            <div className="fl w-70 pl3">
              <WordForms word={this.state.selectedWord} patternData={this.state.selectedPatternData}  isLoading={this.state.isLoading}/>
            </div>
          </div>
        </div>
      </main>
    )
  }
}