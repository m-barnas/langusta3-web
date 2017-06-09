import React, {Component} from 'react';
import { fetchWordForms } from '../util/api';
import { grammaticalCases, numbers } from '../util/enums';

class WordForms extends Component {
  constructor(props) {
    super(props);

    this.state = {
      wordForms: [{
        'Nominative': {
          'Singular': ['advokát'],
          'Plural': ['advokáti'],
        }},
        {'Genitive': {
          'Singular': ['advokáta'],
          'Plural': ['advokátů'],
        }},
        {'Dative': {
          'Singular': ['advokátovi', 'advokátu'],
          'Plural': ['advokátům'],
        }},
        {'Accusative': {
          'Singular': ['advokáta'],
          'Plural': ['advokáty'],
        }},
        {'Vocative': {
          'Singular': ['advokáte'],
          'Plural': ['advokáti'],
        }},
        {'Locative': {
          'Singular': ['advokátovi', 'advokátu'],
          'Plural': ['advokátech'],
        }},
        {'Instrumental': {
          'Singular': ['advokátem'],
          'Plural': ['advokáty']
        }}
      ],
      // grammaticalCases: grammaticalCases()
    }
  }
  componentDidMount() {
    // let data = fetchWordForms(this.props.word, this.props.pattern);
    

    // data.then((data) => {
    //   let wordForms = data.declinedWordDTOS;

    //   let wordFormsDict = {}
    
    //   for (let grammaticalCase of grammaticalCases()) {
    //     wordFormsDict[grammaticalCase] = {};

    //     for (let number of numbers()) {
    //      wordFormsDict[grammaticalCase][number] = [];
    //     }
    //   }

    //   console.log(wordFormsDict);

    //   this.setState({
    //     wordForms: wordForms
    //   })
    // })  
  }
  componentWillReceiveProps(nextProps) {
  }
  getSingular(grammaticalCase) {

  }
  getPlural(grammaticalCase) {

  }
  
  render() {
    const wordForms = this.state.wordForms;
    let grammaticalCase;
    let number;

    // const parseWords = (words) => {
    //   return ()
    // }

    return (
      <div>
        <h2 className="f5 normal ma0 pv1 clip">Všechna tvary slova:</h2>
        <table className="collapse tl w-100">
          <thead>
            <tr>
              <th className="pv1 pl3"><span className="clip">Pád</span></th>
              <th className="pv1 pl3">Singular</th>
              <th className="pv1 pl3 pr3">Plural</th>
            </tr>
          </thead>
          <tbody>
            {wordForms.map((item, index) => (
              <tr className="striped--near-white" key={index}>
                <th className="pv1 pl3 v-top"><div>{grammaticalCase = Object.keys(item)}</div></th>
                <td className="pl3 pt0 pv0 v-top">{
                  item[grammaticalCase]['Singular'].map((item, index) => {
                    return <div className="pv1" key={index}>{item}</div>  
                  })
                }</td>
                <td className="pl3 pr3 pv0 v-top">{
                  item[grammaticalCase]['Plural'].map((item, index) => {
                    return <div className="pv1" key={index}>{item}</div>
                  })
                }</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    )
  }
}

export default WordForms;