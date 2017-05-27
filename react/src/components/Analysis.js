import React, { Component } from 'react';
import AnalysisData from './AnalysisData';

class Analysis extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 'Příliš žluťoučký kůň úpěl ďábelské ódy',
      words: []
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
    let string = this.state.value;
    let words = string.trim().split(/[\s,]+/);

    this.setState({
      words: words
    })
  }


  render() {
    return (
      <main className="Analysis">
        <div className="Container pv5">

          <form className="cf mb3" onSubmit={this.handleSubmit}>
            <div className="cf flex mb2">
              <div className="flex fl w-50 pr3">
                <textarea className="AnalysisInput FormControl" rows="3" onChange={this.handleChange} value={this.state.value} />
              </div>
              <div className="flex fl w-50 pl3">
                <div className="AnalysisResult FormControl bg-near-white">{ this.state.value }</div>
              </div>
            </div>

            <button className="Button Button--primary fr" type="submit">Analyze</button>
          </form>

          <div className="mw7 center cf">
            <AnalysisData />
          </div>

        </div>
      </main>
    );
  }
}

export default Analysis;