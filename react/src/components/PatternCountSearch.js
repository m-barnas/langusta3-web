import React, { Component } from 'react';
import { MdRefresh } from 'react-icons/lib/md';
import { fetchWordsByPatternCount } from '../util/api';

export default class PatternCountSearch extends Component {
  constructor() {
    super()

    this.state = {
      value: 2,
      submittedValue: 2,
      words: null
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(event) {
    this.setState({
      value: event.target.value
    })
  }
  handleSubmit(event) {
    event.preventDefault();

    this.setState({
      isLoading: true
    });
  
    fetchWordsByPatternCount(this.state.value).then((data) => {
      this.setState({
        isLoading: false,
        words: data,
        submittedValue: this.state.value
      });
    })
    
  }
  render() {
    const words = this.state.words;

    return (
      <main className="PatternCount">
        <div className="Container pv5">
          <h1 className="mt0 tc">Vyhľadávanie podľa počtu vzorov</h1>
          <div className="mw5 center cf mb4">
            <form className="tc" onSubmit={this.handleSubmit}>
              <div className="mw3 dib">
                <input className={"PatternCountInput FormControl tc" + (this.state.isLoading ? " is-loading" : "")} 
                type="number" placeholder="2" 
                min="0" max="10" onChange={this.handleChange} disabled={this.state.isLoading}
                value={this.state.value}/>
              </div>
              <button className={"Button Button--primary ml3" + (this.state.isLoading ? " is-loading" : "")}
               type="submit" disabled={this.state.isLoading}>
                <MdRefresh className="Button-icon" /> Search
              </button>
            </form>
          </div>

          { words !== null && 
            <div className="mw6 center mt3">
              <h2 className="f5 normal">
                Počet slov, ktoré sa skloňujú podľa {this.state.submittedValue} vzorov: <strong>{words.length}</strong></h2>
              <div className={"AnalysisResult AnalysisResult--lg FormControl overflow-y-auto bg-near-white" + 
              (this.state.isLoading ? " is-loading" : "")}>
                {words.map((item, index) => {
                  return <span className="mr2" key={index}>{item} </span>
                })}
              </div>
            </div>
          }
          
        </div>
      </main>
    )
  }
}