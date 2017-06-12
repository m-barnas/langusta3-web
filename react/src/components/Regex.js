import React, {Component} from 'react';
import RegexForm from './RegexForm';
import { fetchWordsByFilters } from './../util/api';

export default class Regex extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: false,
      words: null,
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleWordSelect = this.handleWordSelect.bind(this);
    this.handlePatternSelect = this.handlePatternSelect.bind(this);
  }

  handleChange(event) {
    this.setState({
      value: event.target.value
    });
  }

  handleSubmit(value, filters) {

    this.setState({
      isLoading: true
    });

    // let value = this.parseValue(this.state.value);
    // let words = getWords();

    fetchWordsByFilters(value, filters).then((words) => {

      this.setState({
        isLoading: false,
        words: [...words],
      });
      this.forceUpdate();
    })

    // console.log(value);
    // console.log(filters);
  }

  handleWordSelect(selectedWord) {
    this.setState({
      selectedWord: selectedWord,
      selectedPatternData: selectedWord.getData().patterns[0]
    })
  }

  handlePatternSelect(selectedPatternData) {
    this.setState({
      selectedPatternData: selectedPatternData
    })
  }
  render() {
    let words = this.state.words;

    return (
      <main className="Regex">
        <div className="Container pv5">
          <h1 className="mt0 tc">Vyhľadávanie slov podľa tvaru</h1>

          <div className="mw7 center cf mb4">
            <RegexForm onSubmit={this.handleSubmit} isLoading={this.state.isLoading}/>
            
            { words !== null && 
            <div className="mt3">
                <div className="mb2">Počet nájdených slov: <strong>{words.length}</strong></div>
                <div className={"AnalysisResult AnalysisResult--lg FormControl overflow-y-auto bg-near-white" + 
                (this.state.isLoading ? " is-loading" : "")}>
                  {words.map((word, index) => {
                    return (<span className="mr3" key={index}>{word} </span>)
                  })}
                </div>
            </div>
            }
          </div>
        </div>
      </main>
    )
  }
}