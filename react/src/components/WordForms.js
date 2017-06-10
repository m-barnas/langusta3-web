import React, {Component} from 'react';
// import { fetchWordForms } from '../util/api';
import { getGrammaticalCases } from '../util/enums';

class WordForms extends Component {
  constructor(props) {
    super(props);

    this.state = {
      patternData: null,
      wordForms: [],
      grammaticalCases: getGrammaticalCases()
    }
  }
  componentWillReceiveProps(nextProps) {
    if (nextProps.patternData !== null) {
      this.setState({
        patternData: nextProps.patternData
      })
    }
  }
  getSingular(grammaticalCase) {

  }
  getPlural(grammaticalCase) {

  }
  
  render() {
    const patternData = this.state.patternData;
    const grammaticalCases = this.state.grammaticalCases;

    if (patternData !== null) {
      return (
        <div>
          <h2 className="f5 normal ma0 pv1 clip">Všechna tvary slova:</h2>
          <div className="h5 overflow-y-auto">
            <table className="collapse tl w-100">
              <thead>
                <tr>
                  <th className="pv1 pl3"><span className="clip">Pád</span></th>
                  <th className="pv1 pl3">Singular</th>
                  <th className="pv1 pl3 pr3">Plural</th>
                </tr>
              </thead>
              <tbody>
                {grammaticalCases.map((grammaticalCase, index) => (
                  <tr className="striped--near-white" key={index}>
                    <th className="pv1 pl3 v-top"><div>{grammaticalCase}</div></th>
                    <td className="pl3 pt0 pv0 v-top">{
                      patternData[grammaticalCase.toLowerCase()]['singulars'].map((item, index) => {
                        return <div className="pv1" key={index}>{item}</div>  
                      })
                    }</td>
                    <td className="pl3 pr3 pv0 v-top">{
                      patternData[grammaticalCase.toLowerCase()]['plurals'].map((item, index) => {
                        return <div className="pv1" key={index}>{item}</div>
                      })
                    }</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )
    }
    return null;
    
  }
}

export default WordForms;