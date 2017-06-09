import React, {Component} from 'react';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Word from './Word';
import Words from './Words';
import {MdRefresh} from 'react-icons/lib/md';

export default class Regex extends Component {
  // constructor() {
  //   super();
  // }
  render() {
    let wordsData = 'Příliš žluťoučký kůň úpěl ďábelské ódy'.split(' ');

    return (
      <main className="Regex">
        <div className="Container pv5">
          <h1 className="mt0 tc">RegEx</h1>
          <div className="mw7 center cf mb4">
            <form className="flex">
              <div className="flex-auto">
                <input className="RegexInput FormControl code" type="text" placeholder="/([A-Z])\w+/g"/>
              </div>
              <button className="Button Button--primary ml3" type="submit">
                <MdRefresh className="Button-icon" /> Analyze
              </button>
            </form>
            <div className="mt3">
              <div className="AnalysisResult FormControl overflow-y-auto bg-near-white">
                <Words ref={(words) => {this.words = words}}>
                  {wordsData.map((word, index) => (
                    <Word 
                    className="Word js-word mr2"
                    key={ index }
                    onClick={ (selectedWord) => this.words.handleWordClick(selectedWord) }>
                      {word}
                    </Word>
                  ))}
                </Words>
              </div>
            </div>
          </div>
          <div className="mw7 center cf">
            <div className="fl w-50 pr3">
              <WordAnalysis />
            </div>
            <div className="fl w-50 pl3">
              <WordForms />
            </div>
          </div>
        </div>
      </main>
    )
  }
}