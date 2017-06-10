import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
import WordAnalysis from './WordAnalysis';
import WordForms from './WordForms';
import Highlighter from './Highlighter';
import {MdRefresh, MdMailOutline} from 'react-icons/lib/md';
import { fetchAnalyzedWords } from './../util/api';
import { getGrammaticalCases } from './../util/enums';

class Analysis extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
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

    let value = this.parseValue(this.state.value);

    let words = [
      {
        "inputValue": "heslo",
        "infinitive": "heslo",
        "patterns": [
          {
            "pattern": "sluchadlo",
            "grammaticalGender": "Neuter",
            "wordClass": "Noun",
            "nominative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "genitive": {
              "singulars": [
                "hesla"
              ],
              "plurals": [
                "hesel"
              ]
            },
            "dative": {
              "singulars": [
                "heslu"
              ],
              "plurals": [
                "heslům"
              ]
            },
            "accusative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "vocative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "locative": {
              "singulars": [
                "hesle"
              ],
              "plurals": [
                "heslech"
              ]
            },
            "instrumental": {
              "singulars": [
                "heslem"
              ],
              "plurals": [
                "hesly"
              ]
            }
          },
          {
            "pattern": "vědro",
            "grammaticalGender": "Neuter",
            "wordClass": "Noun",
            "nominative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "genitive": {
              "singulars": [
                "hesla"
              ],
              "plurals": [
                "hesel"
              ]
            },
            "dative": {
              "singulars": [
                "heslu"
              ],
              "plurals": [
                "heslům"
              ]
            },
            "accusative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "vocative": {
              "singulars": [
                "heslo"
              ],
              "plurals": [
                "hesla"
              ]
            },
            "locative": {
              "singulars": [
                "heslu"
              ],
              "plurals": [
                "heslech"
              ]
            },
            "instrumental": {
              "singulars": [
                "heslem"
              ],
              "plurals": [
                "hesly"
              ]
            }
          }
        ]
      },
      {
        "inputValue": "Bezpečné",
        "infinitive": "bezpečný",
        "patterns": [
          {
            "pattern": "mladý",
            "grammaticalGender": "MasculineAnimate",
            "wordClass": "Adjective",
            "nominative": {
              "singulars": [
                "bezpečný",
                "bezpečný",
                "bezpečná",
                "bezpečné"
              ],
              "plurals": [
                "bezpeční",
                "bezpečné",
                "bezpečné",
                "bezpečná"
              ]
            },
            "genitive": {
              "singulars": [
                "bezpečného",
                "bezpečného",
                "bezpečné",
                "bezpečného"
              ],
              "plurals": [
                "bezpečných",
                "bezpečných",
                "bezpečných",
                "bezpečných"
              ]
            },
            "dative": {
              "singulars": [
                "bezpečnému",
                "bezpečnému",
                "bezpečné",
                "bezpečnému"
              ],
              "plurals": [
                "bezpečným",
                "bezpečným",
                "bezpečným",
                "bezpečným"
              ]
            },
            "accusative": {
              "singulars": [
                "bezpečného",
                "bezpečný",
                "bezpečnou",
                "bezpečné"
              ],
              "plurals": [
                "bezpečné",
                "bezpečné",
                "bezpečné",
                "bezpečná"
              ]
            },
            "vocative": {
              "singulars": [
                "bezpečný",
                "bezpečný",
                "bezpečná",
                "bezpečné"
              ],
              "plurals": [
                "bezpeční",
                "bezpečné",
                "bezpečné",
                "bezpečná"
              ]
            },
            "locative": {
              "singulars": [
                "bezpečném",
                "bezpečném",
                "bezpečné",
                "bezpečném"
              ],
              "plurals": [
                "bezpečných",
                "bezpečných",
                "bezpečných",
                "bezpečných"
              ]
            },
            "instrumental": {
              "singulars": [
                "bezpečným",
                "bezpečným",
                "bezpečnou",
                "bezpečným"
              ],
              "plurals": [
                "bezpečnými",
                "bezpečnými",
                "bezpečnými",
                "bezpečnými"
              ]
            }
          }
        ]
      }
    ]

    // fetchAnalyzedWords(value).then((words) => {
      let wordStrings = [];

      for (let word of words) {
        wordStrings.push(word.inputValue);
      }
      // console.log(words);

      this.setState({
        words: words,
        wordStrings: wordStrings
      });

    // })

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
                <textarea className="AnalysisInput FormControl" rows="3" onChange={this.handleChange} value={this.state.value} />
              </div>
              <div className="fl w-50 pl2">
                <div className="AnalysisResult FormControl overflow-y-auto bg-near-white">
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

            <button className="Button Button--primary fr" type="submit">
              <MdRefresh className="Button-icon" /> Analyze
            </button>
          </form>

          <div className="mw7 center cf">
            <div className="fl w-30 pr3">
              <WordAnalysis word={ this.state.selectedWord } onPatternSelect={this.handlePatternSelect} />
            </div>
            <div className="fl w-70 pl3">
              <WordForms word={this.state.selectedWord} patternData={this.state.selectedPatternData} />
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